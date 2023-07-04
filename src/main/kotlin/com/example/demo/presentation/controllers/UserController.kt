package com.example.demo.presentation.controllers

import com.example.demo.application.usecases.user.*
import com.example.demo.presentation.dtos.user.UserDTO
import com.example.demo.presentation.dtos.user.request.CreateUserRequest
import com.example.demo.presentation.dtos.user.request.UpdateUserRequest
import com.example.demo.presentation.mappers.UserMapper
import com.example.demo.shared.utils.GenericResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController(
    private val getUsersUseCase: GetUsersUseCase,
    private val getUserByIdUseCase: GetUserByIdUseCase,
    private val createUserUseCase: CreateUserUseCase,
    private val updateUserUseCase: UpdateUserUseCase,
    private val deleteUserUseCase: DeleteUserUseCase
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
        createUserUseCase.execute(userDTO = UserMapper.mapCreateRequestToDto(request = body))
        return GenericResponse(
            status = true,
            message = "Successfully saved user data"
        )
    }

    @PutMapping("{id}")
    fun updateUser(
        @PathVariable id: Long,
        @RequestBody request: UpdateUserRequest
    ) : GenericResponse<String>{
        updateUserUseCase.execute(userDTO = UserMapper.mapUpdateRequestToDto(request = request), userId = id)
        return GenericResponse(
            status = true,
            message = "Successfully updated user data"
        )
    }

    @DeleteMapping("{id}")
    fun deleteUser(
        @PathVariable id: Long
    ) : GenericResponse<String> {
        deleteUserUseCase.execute(userId = id)
        return GenericResponse(
            status = true,
            message = "Successfully deleted user data"
        )
    }

}