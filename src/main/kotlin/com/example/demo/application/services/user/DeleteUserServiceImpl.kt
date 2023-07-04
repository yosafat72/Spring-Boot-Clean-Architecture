package com.example.demo.application.services.user

import com.example.demo.application.usecases.user.DeleteUserUseCase
import com.example.demo.domain.repository.UserRepository
import com.example.demo.presentation.exceptions.NotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class DeleteUserServiceImpl(private val userRepository: UserRepository) : DeleteUserUseCase {

    override fun execute(userId: Long) {
        return userRepository.findByIdOrNull(userId).let {
            it?.let {
                userRepository.delete(it)
            } ?: throw NotFoundException()
        }

    }


}