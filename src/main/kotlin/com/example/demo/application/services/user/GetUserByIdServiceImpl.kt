package com.example.demo.application.services.user

import com.example.demo.application.usecases.user.GetUserByIdUseCase
import com.example.demo.domain.repository.UserRepository
import com.example.demo.presentation.dtos.user.UserDTO
import com.example.demo.presentation.exceptions.NotFoundException
import com.example.demo.presentation.mappers.UserMapper
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class GetUserByIdServiceImpl(private val userRepository: UserRepository) : GetUserByIdUseCase{

    override fun execute(userid: Long): UserDTO? {
        return userRepository.findByIdOrNull(userid).let {
            it?.let {
                UserMapper.mapToDto(user = it)
            } ?: throw NotFoundException()
        }
    }

}