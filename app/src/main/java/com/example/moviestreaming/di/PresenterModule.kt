package com.example.moviestreaming.di

import com.example.moviestreaming.presenter.screens.authentication.login.viewmodel.LoginViewModel
import com.example.moviestreaming.presenter.screens.authentication.signup.viewmodel.SignupViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val presenterModule = module {

    viewModel {
        SignupViewModel(
            registerUseCase = get(),
            saveUserUseCase = get()
        )
    }

    viewModel {
        LoginViewModel()
    }

}