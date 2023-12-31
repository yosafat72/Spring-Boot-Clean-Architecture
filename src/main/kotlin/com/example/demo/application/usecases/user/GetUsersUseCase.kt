package com.example.demo.application.usecases.user

import com.example.demo.presentation.dtos.user.UserDTO

interface GetUsersUseCase {

    fun execute(page: Int) : List<UserDTO>

}