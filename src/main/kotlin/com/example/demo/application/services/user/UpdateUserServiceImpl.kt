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
        userRepository.findByIdOrNull(userId)?.apply {
            name = userDTO.name
            email = userDTO.email
        }.let { user ->
            user?.let {
                userRepository.save(it)
            } ?: throw NotFoundException()
        }
    }
}