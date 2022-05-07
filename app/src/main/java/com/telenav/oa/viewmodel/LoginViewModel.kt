package com.telenav.oa.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.telenav.oa.domain.usecase.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel : ViewModel() {
    @Inject
    lateinit var loginUseCase: LoginUseCase

    fun login(username: String, password: String) {
        viewModelScope.launch {
            loginUseCase(username, password)
        }
    }

}