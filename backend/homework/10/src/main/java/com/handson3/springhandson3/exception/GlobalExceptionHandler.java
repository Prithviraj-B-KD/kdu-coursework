package com.handson3.springhandson3.exception;

import com.handson3.springhandson3.dto.ErrorDTO;
import com.handson3.springhandson3.exception.custom.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

public class GlobalExceptionHandler {

    @ExceptionHandler(value = {CustomException.class})
    public ResponseEntity<ErrorDTO> handleCustomException(Exception exception){
        ErrorDTO error = ErrorDTO.builder()
                .message(exception.getMessage())
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .timestamp(LocalDateTime.now().toString())
                .build();
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ErrorDTO> allKindOfExceptions(Exception exception){
        ErrorDTO error = ErrorDTO.builder()
                .message(exception.getMessage())
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .timestamp(LocalDateTime.now().toString())
                .build();
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
