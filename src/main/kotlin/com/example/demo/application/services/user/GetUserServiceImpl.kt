package com.example.demo.application.services.user

import com.example.demo.application.usecases.user.GetUsersUseCase
import com.example.demo.domain.model.User
import com.example.demo.domain.repository.UserRepository
import com.example.demo.presentation.dtos.user.UserDTO
import com.example.demo.presentation.mappers.UserMapper
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class GetUserServiceImpl(private val userRepository: UserRepository) : GetUsersUseCase{

    override fun execute(page: Int): List<UserDTO> {
        val users = userRepository.findAll(PageRequest.of(page, 10)).get().collect(Collectors.toList())
        return users.map { UserMapper.mapToDto(user = it) }

    }

}