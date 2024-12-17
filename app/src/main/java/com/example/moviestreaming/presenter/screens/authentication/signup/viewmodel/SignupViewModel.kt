package com.example.moviestreaming.presenter.screens.authentication.signup.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviestreaming.core.enums.InputType
import com.example.moviestreaming.core.enums.InputType.*
import com.example.moviestreaming.core.functions.isValidEmail
import com.example.moviestreaming.core.helper.FirebaseHelper
import com.example.moviestreaming.domain.remote.model.User
import com.example.moviestreaming.domain.remote.usecase.authentication.RegisterUseCase
import com.example.moviestreaming.domain.remote.usecase.user.SaveUserUseCase
import com.example.moviestreaming.presenter.screens.authentication.signup.action.SignupAction
import com.example.moviestreaming.presenter.screens.authentication.signup.state.SignupState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SignupViewModel(
    private val registerUseCase: RegisterUseCase,
    private val saveUserUseCase: SaveUserUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(SignupState())
    val state = _state.asStateFlow()

    fun submitAction(action: SignupAction) {
        when(action) {
            is SignupAction.OnValueChange -> {
                onValueChange(action.value, action.type)
            }

            is SignupAction.OnPasswordVisibilityChange -> {
                onPasswordVisibilityChange()
            }

            is SignupAction.OnSignup -> {
                onSignup()
            }
        }
    }

    private fun onSignup() {
        viewModelScope.launch {
            try {
                registerUseCase(
                    email = _state.value.email,
                    password = _state.value.password
                )

                saveUserUseCase(user = User(email = _state.value.email))
            } catch (exception: Exception) {
                exception.printStackTrace()

                _state.update { currentState ->
                    currentState.copy(
                        hasError = true,
                        error = FirebaseHelper.validError(exception.message))
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

        enabledSignupButton()
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

    private fun enabledSignupButton() {
        val emailValid = isValidEmail(_state.value.email)
        val passwordValid = state.value.password.isNotBlank()

        _state.update { currentState ->
            currentState.copy(enabledSignupButton = emailValid && passwordValid)
        }
    }
}