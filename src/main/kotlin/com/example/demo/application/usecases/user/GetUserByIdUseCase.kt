package com.example.demo.application.usecases.user

import com.example.demo.presentation.dtos.user.UserDTO

interface GetUserByIdUseCase {
    fun execute(userid: Long) : UserDTO?
}