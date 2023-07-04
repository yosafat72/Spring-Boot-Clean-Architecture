package com.example.demo.application.usecases.user

import com.example.demo.presentation.dtos.UserDTO

interface GetUsersUseCase {

    fun execute(page: Int) : List<UserDTO>

}