package com.example.OGCourseRegistration.DTO;

import com.example.OGCourseRegistration.Entity.Courses;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class StudentCourseResonseDto {
    private long id;
    private String name;
    private String email;

    private Set<Courses> courses;

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCourses(Set<Courses> courses) {
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Set<Courses> getCourses() {
        return courses;
    }
}
