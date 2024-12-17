package com.example.moviestreaming.presenter.screens.authentication.login.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviestreaming.core.enums.feedback.FeedbackType
import com.example.moviestreaming.core.enums.input.InputType
import com.example.moviestreaming.core.enums.input.InputType.EMAIL
import com.example.moviestreaming.core.enums.input.InputType.PASSWORD
import com.example.moviestreaming.core.functions.isValidEmail
import com.example.moviestreaming.core.helper.FirebaseHelper
import com.example.moviestreaming.presenter.screens.authentication.login.action.LoginAction
import com.example.moviestreaming.presenter.screens.authentication.login.state.LoginState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val _state = MutableStateFlow(LoginState())
    val state = _state.asStateFlow()

    fun submitAction(action: LoginAction) {
        when(action) {
            is LoginAction.OnValueChange -> {
                onValueChange(action.value, action.type)
            }

            is LoginAction.OnPasswordVisibilityChange -> {
                onPasswordVisibilityChange()
            }

            is LoginAction.OnSignIn -> {
                onSignIn()
            }

            is LoginAction.ResetError -> {
                resetError()
            }
        }
    }

    private fun onSignIn() {
        viewModelScope.launch {
            try {
//                registerUseCase(
//                    email = _state.value.email,
//                    password = _state.value.password
//                )
//
//                saveUserUseCase(user = User(email = _state.value.email))
            } catch (exception: Exception) {
                exception.printStackTrace()

                _state.update { currentState ->
                    currentState.copy(
                        hasError = true,
                        feedbackUI = Pair(
                            FeedbackType.ERROR,
                            FirebaseHelper.validError(exception.message))
                        )
                }
            }
        }
    }

    private fun onValueChange(value: String, type: InputType) {
        when(type) {
            EMAIL -> {
                onEmailChange(value)
            }
            PASSWORD -> {
                onPasswordChange(value)
            }
        }

        enabledSignInButton()
    }

    private fun onEmailChange(value: String) {
        _state.update { currentState ->
            currentState.copy(email = value)
        }
    }

    private fun onPasswordChange(value: String) {
        _state.update { currentState ->
            currentState.copy(password = value)
        }
    }

    private fun onPasswordVisibilityChange() {
        _state.update { currentState ->
            currentState.copy(passwordVisibility = !currentState.passwordVisibility)
        }
    }

    private fun enabledSignInButton() {
        val emailValid = isValidEmail(_state.value.email)
        val passwordValid = _state.value.password.isNotBlank()

        _state.update { currentState ->
            currentState.copy(enabledSignInButton = emailValid && passwordValid)
        }
    }

    private fun resetError() {
        _state.update { currentState ->
            currentState.copy(hasError = false, feedbackUI = null)
        }
    }
}