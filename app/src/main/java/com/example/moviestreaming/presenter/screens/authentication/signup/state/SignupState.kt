package com.example.moviestreaming.presenter.screens.authentication.signup.state

data class SignupState(
    val isLoading: Boolean = false,
    val email: String = "teste@gmail.com",
    val password: String = "teste123",
    val passwordVisibility: Boolean = false,
    val enabledSignupButton: Boolean = true,
    val hasError: Boolean = false,
    val error: Int? = null
)
