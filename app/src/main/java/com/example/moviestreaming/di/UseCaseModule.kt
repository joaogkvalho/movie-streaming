package com.example.moviestreaming.di

import com.example.moviestreaming.domain.remote.usecase.authentication.RegisterUseCase
import com.example.moviestreaming.domain.remote.usecase.user.SaveUserUseCase
import org.koin.dsl.module

val useCaseModule = module {

    factory { RegisterUseCase(repository = get()) }

    factory { SaveUserUseCase(repository = get()) }

}