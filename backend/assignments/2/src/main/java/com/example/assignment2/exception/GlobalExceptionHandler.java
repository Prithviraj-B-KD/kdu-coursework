package com.example.assignment2.exception;

import com.example.assignment2.dto.ErrorDTO;
import com.example.assignment2.exception.customException.InvalidInputException;
import com.example.assignment2.exception.customException.JsonResponseNodeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<ErrorDTO> InValidInputException(Exception exception){
        ErrorDTO errorDTO =  ErrorDTO.builder()
                .message(exception.getMessage())
                .status(HttpStatus.BAD_REQUEST)
                .timestamp(LocalDateTime.now().toString()).build();
        return new ResponseEntity<>(errorDTO,errorDTO.getStatus());
    }
    @ExceptionHandler(JsonResponseNodeException.class)
    public ResponseEntity<ErrorDTO> jsonResponseNodeException(Exception exception){
        ErrorDTO errorDTO =  ErrorDTO.builder()
                .message(exception.getMessage())
                .status(HttpStatus.NOT_FOUND)
                .timestamp(LocalDateTime.now().toString()).build();
        return new ResponseEntity<>(errorDTO,errorDTO.getStatus());
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleAllOtherException(Exception exception){
        ErrorDTO errorDTO =  ErrorDTO.builder()
                .message(exception.getMessage())
                .status(HttpStatus.BAD_REQUEST)
                .timestamp(LocalDateTime.now().toString()).build();
        return new ResponseEntity<>(errorDTO,errorDTO.getStatus());
    }
}
