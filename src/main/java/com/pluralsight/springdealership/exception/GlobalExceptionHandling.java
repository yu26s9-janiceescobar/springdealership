package com.pluralsight.springdealership.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandling{
   @ExceptionHandler(DealershipNotFoundException.class)
   public ResponseEntity<Map<String, String>> handleDealershipNotFound(DealershipNotFoundException ex){
       return ResponseEntity.status(HttpStatus.NOT_FOUND)
               .body(Map.of("message", ex.getMessage()));
   }
}
