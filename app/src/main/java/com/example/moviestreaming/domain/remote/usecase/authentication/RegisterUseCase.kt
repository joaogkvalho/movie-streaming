package com.example.moviestreaming.domain.remote.usecase.authentication

import com.example.moviestreaming.domain.remote.repository.authentication.SignupRepository

class RegisterUseCase(
    private val repository: SignupRepository
) {
    suspend operator fun invoke(email: String, password: String) {
        repository.registerUser(email, password)
    }
}