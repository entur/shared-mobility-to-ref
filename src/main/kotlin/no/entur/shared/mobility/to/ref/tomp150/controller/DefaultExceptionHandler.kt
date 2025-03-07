package no.entur.shared.mobility.to.ref.tomp150.controller

import jakarta.servlet.http.HttpServletResponse
import jakarta.validation.ConstraintViolationException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class DefaultExceptionHandler {
    @ExceptionHandler(NotImplementedError::class)
    fun onNotImplemented(
        ex: NotImplementedError,
        response: HttpServletResponse,
    ): Unit = response.sendError(HttpStatus.NOT_IMPLEMENTED.value())

    @ExceptionHandler(ConstraintViolationException::class)
    fun onConstraintViolation(
        ex: ConstraintViolationException,
        response: HttpServletResponse,
    ): Unit = response.sendError(HttpStatus.BAD_REQUEST.value(), ex.constraintViolations.joinToString(", ") { it.message })
}
