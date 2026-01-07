package com.example.OGCourseRegistration.Exception;

public class CourseNotFound extends RuntimeException {
    public CourseNotFound(String message){
        super(message);
    }
}
