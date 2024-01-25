package com.example.handson3.exception;

import com.example.handson3.dto.ErrorDTO;
import com.example.handson3.exception.customExceptions.ResourceNotFoundException;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleResourceNotFoundException(ResourceNotFoundException exception){
        ErrorDTO errorDTO =  ErrorDTO.builder()
                .message(exception.getMessage())
                .status(HttpStatus.NOT_FOUND)
                .timestamp(LocalDateTime.now().toString()).build();
        return new ResponseEntity<>(errorDTO,errorDTO.getStatus());
    }
    @ExceptionHandler(BadRequestException.class)
   public ResponseEntity<ErrorDTO> handleBadRequestException(BadRequestException exception){
        ErrorDTO errorDTO =  ErrorDTO.builder()
                .message(exception.getMessage())
                .status(HttpStatus.BAD_REQUEST)
                .timestamp(LocalDateTime.now().toString()).build();
       return new ResponseEntity<>(errorDTO,errorDTO.getStatus());
   }

   @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleAllOtherException(Exception exception){
       ErrorDTO errorDTO =  ErrorDTO.builder()
               .message(exception.getMessage())
               .status(HttpStatus.INTERNAL_SERVER_ERROR)
               .timestamp(LocalDateTime.now().toString()).build();
       return new ResponseEntity<>(errorDTO,errorDTO.getStatus());
   }
}
