package com.example.OGCourseRegistration.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(StudentNotFound.class)
    public ResponseEntity<String> studentError(Exception er){
            return ResponseEntity.badRequest().body(er.getMessage());
    }
    @ExceptionHandler(CourseNotFound.class)
    public ResponseEntity<String> CourseError(Exception er){
        return new ResponseEntity<>(er.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> validationerror(MethodArgumentNotValidException er){
        Map<String,String > errors=new HashMap<>();
        er.getBindingResult().getFieldErrors().forEach(error->errors.put(error.getField(),error.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errors);
    }
}
