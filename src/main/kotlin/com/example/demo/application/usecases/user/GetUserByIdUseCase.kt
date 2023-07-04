package com.example.demo.application.usecases.user

import com.example.demo.presentation.dtos.UserDTO

interface GetUserByIdUseCase {
    fun execute(userid: Long) : UserDTO?
}