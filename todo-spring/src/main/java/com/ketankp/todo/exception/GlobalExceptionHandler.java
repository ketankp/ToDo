package com.ketankp.todo.exception;

import com.ketankp.todo.dto.ErrorResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.HandlerMethod;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestControllerAdvice
@Log4j2
public class GlobalExceptionHandler {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @ExceptionHandler(CustomNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponseDto customBadRequestException(CustomNotFoundException customNotFoundException, HttpServletRequest httpServletRequest, HandlerMethod handlerMethod){
        String declaringClass = handlerMethod.getMethod().getDeclaringClass().getSimpleName();
        String methodName = handlerMethod.getMethod().getName();
        log.error("Error in {}:{} method",declaringClass,methodName);
        return ErrorResponseDto.builder()
                .code(HttpStatus.BAD_REQUEST.name())
                .message(customNotFoundException.getMessage())
                .timestamp(sdf.format(System.currentTimeMillis()))
                .path(httpServletRequest.getRequestURI())
                .build();
    }
}
