package com.example.demo.application.services.user

import com.example.demo.application.usecases.user.UpdateUserUseCase
import com.example.demo.domain.repository.UserRepository
import com.example.demo.presentation.dtos.user.UserDTO
import com.example.demo.presentation.exceptions.NotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class UpdateUserServiceImpl(private val userRepository: UserRepository) : UpdateUserUseCase{
    override fun execute(userDTO: UserDTO, userId: Long) {
        val user = userRepository.findByIdOrNull(userId) ?: throw NotFoundException()

        user.name = userDTO.name
        user.email = userDTO.email

        userRepository.save(user)
    }
}