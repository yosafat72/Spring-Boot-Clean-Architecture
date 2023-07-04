package com.example.demo.application.usecases

import com.example.demo.presentation.dtos.user.UserDTO

interface UserUseCase {
    fun createUser(userDTO: UserDTO)
    fun updateUser(userDTO: UserDTO)
    fun deleteUser(userDTO: UserDTO)
}