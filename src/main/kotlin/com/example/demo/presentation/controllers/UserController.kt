package com.example.demo.presentation.controllers

import com.example.demo.application.usecases.user.CreateUserUseCase
import com.example.demo.application.usecases.user.GetUserByIdUseCase
import com.example.demo.application.usecases.user.GetUsersUseCase
import com.example.demo.presentation.dtos.user.UserDTO
import com.example.demo.presentation.dtos.user.request.CreateUserRequest
import com.example.demo.presentation.mappers.UserMapper
import com.example.demo.shared.utils.GenericResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController(
    private val getUsersUseCase: GetUsersUseCase,
    private val getUserByIdUseCase: GetUserByIdUseCase,
    private val createUserUseCase: CreateUserUseCase
){

    @GetMapping
    fun getAllUsers(
            @RequestParam("page") page: Int
    ) : GenericResponse<List<UserDTO>> {
        val users = getUsersUseCase.execute(page = page)
        return GenericResponse(
            status = true,
            message = "Successfully retrieved users data",
            data = users
        )
    }

    @GetMapping("{id}")
    fun getUserById(
        @PathVariable id: Long
    ) : GenericResponse<UserDTO?> {
        val user = getUserByIdUseCase.execute(userid = id)
        return GenericResponse(
            status = true,
            message = "Successfully retrieve user data based on id",
            data = user
        )
    }

    @PostMapping
    fun createUser(
        @RequestBody body: CreateUserRequest,
    ) : GenericResponse<String> {
        createUserUseCase.execute(userDTO = UserMapper.mapRequestToDto(request = body))
        return GenericResponse(
            status = true,
            message = "Successfully saved user data"
        )
    }

}