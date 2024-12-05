package com.example.moviestreaming.presenter.screens.authentication.signup.viewmodel

import androidx.lifecycle.ViewModel
import com.example.moviestreaming.core.enums.InputType
import com.example.moviestreaming.core.enums.InputType.*
import com.example.moviestreaming.presenter.screens.authentication.signup.action.SignupAction
import com.example.moviestreaming.presenter.screens.authentication.signup.state.SignupState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SignupViewModel:ViewModel() {

    private val _state = MutableStateFlow(SignupState())
    val state = _state.asStateFlow()

    fun submitAction(action: SignupAction) {
        when(action) {
            is SignupAction.OnValueChange -> {
                onValueChange(action.value, action.type)
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
}