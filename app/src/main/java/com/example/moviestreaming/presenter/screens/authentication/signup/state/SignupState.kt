package com.example.moviestreaming.presenter.screens.authentication.signup.state

import com.example.moviestreaming.core.enums.feedback.FeedbackType

data class SignupState(
    val isLoading: Boolean = false,
    val email: String = "teste@gmail.com",
    val password: String = "teste123",
    val passwordVisibility: Boolean = false,
    val enabledSignupButton: Boolean = true,
    val hasError: Boolean = false,
    val feedbackUI: Pair<FeedbackType, Int>? = null
)
