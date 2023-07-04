package com.example.demo.application.services.user

import com.example.demo.application.usecases.user.CreateUserUseCase
import com.example.demo.domain.repository.UserRepository
import com.example.demo.presentation.dtos.user.UserDTO
import com.example.demo.presentation.exceptions.DuplicateValueException
import com.example.demo.presentation.mappers.UserMapper
import org.springframework.stereotype.Service

@Service
class CreateUserServiceImpl(private val userRepository: UserRepository) : CreateUserUseCase {
    override fun execute(userDTO: UserDTO){
        userDTO.name?.let { userRepository.findByName(name = it) }.let {
            if (it != null && (it.name == userDTO.name && it.email == userDTO.email)){
                throw DuplicateValueException()
            }else{
                userRepository.save(UserMapper.mapToDomain(dto = userDTO))
            }
        }
    }
}