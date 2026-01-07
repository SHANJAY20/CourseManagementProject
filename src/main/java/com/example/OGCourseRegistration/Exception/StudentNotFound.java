package com.example.OGCourseRegistration.Exception;

public class StudentNotFound extends RuntimeException{
    public StudentNotFound(String message){
        super(message);
    }
}
