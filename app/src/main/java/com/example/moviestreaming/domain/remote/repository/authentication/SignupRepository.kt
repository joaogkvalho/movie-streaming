package com.example.moviestreaming.domain.remote.repository.authentication

interface SignupRepository {
    suspend fun registerUser(email: String, password: String)
}