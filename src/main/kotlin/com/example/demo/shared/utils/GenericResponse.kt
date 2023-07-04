package com.example.demo.shared.utils

data class GenericResponse<T>(
    val status: Boolean,
    val message: String,
    val data: T? = null
)