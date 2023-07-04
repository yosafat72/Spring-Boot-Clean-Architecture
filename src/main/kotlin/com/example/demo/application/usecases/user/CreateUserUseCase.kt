package com.example.demo.application.usecases.user

import com.example.demo.presentation.dtos.user.UserDTO

interface CreateUserUseCase {
    fun execute(userDTO: UserDTO)
}