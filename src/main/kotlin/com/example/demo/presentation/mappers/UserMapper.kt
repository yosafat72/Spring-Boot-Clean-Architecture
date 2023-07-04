package com.example.demo.presentation.mappers

import com.example.demo.domain.model.User
import com.example.demo.presentation.dtos.user.UserDTO
import com.example.demo.presentation.dtos.user.request.CreateUserRequest
import com.example.demo.presentation.dtos.user.request.UpdateUserRequest
import org.springframework.stereotype.Component

@Component
object UserMapper {

    fun mapToDto(user: User): UserDTO {
        return UserDTO(
                id = user.id,
                name = user.name,
                email = user.email
        )
    }

    fun mapToDomain(dto: UserDTO): User {
        return User(
                id = dto.id,
                name = dto.name,
                email = dto.email
        )
    }

    fun mapCreateRequestToDto(request: CreateUserRequest) : UserDTO{
        return UserDTO(
            name = request.name,
            email = request.email
        )
    }

    fun mapUpdateRequestToDto(request: UpdateUserRequest) : UserDTO{
        return UserDTO(
            name = request.name,
            email = request.email
        )
    }

}