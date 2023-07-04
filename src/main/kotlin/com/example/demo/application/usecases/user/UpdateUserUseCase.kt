package com.example.demo.application.usecases.user

import com.example.demo.presentation.dtos.user.UserDTO

interface UpdateUserUseCase {
    fun execute(userDTO: UserDTO, userId: Long)
}