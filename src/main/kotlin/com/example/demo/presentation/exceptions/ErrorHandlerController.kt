package com.example.demo.presentation.exceptions

import com.example.demo.shared.utils.GenericResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ErrorHandlerController {

    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(HttpStatus.OK)
    fun notFoundException(notFoundException: NotFoundException) : GenericResponse<String> {
        return GenericResponse(
            status = false,
            message = "Data not found"
        )
    }

    @ExceptionHandler(DuplicateValueException::class)
    @ResponseStatus(HttpStatus.OK)
    fun duplicateValueException(duplicateValueException: DuplicateValueException) : GenericResponse<String>{
        return GenericResponse(
            status = false,
            message = "Duplicate data value"
        )
    }

}