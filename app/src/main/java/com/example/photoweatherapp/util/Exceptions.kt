package com.example.photoweatherapp.util

import kotlin.Exception

sealed class AppException(errorMessage: String?) : Exception(errorMessage) {
    object NetworkException : AppException("Network Exception")

    object UnAuthorizedException : AppException("Unauthorized Exception")

    class GeneralApiError(errorMessage: String?) : AppException(errorMessage)

    class UnKnownException(errorMessage: String?) : AppException(errorMessage)
}
