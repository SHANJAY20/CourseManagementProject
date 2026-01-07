package com.example.OGCourseRegistration.DTO;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
public class CourseDto {
    @NotEmpty(message = "course name should not be empty")
    private String course_name;
    @NotEmpty(message = "mentor name should not be empty")
    private String course_mentor;
    @NotEmpty(message = "duration should not be empty")
    private String course_duration;

    public CourseDto() {
    }

    public CourseDto(String course_name, String course_mentor, String course_duration) {
        this.course_name = course_name;
        this.course_mentor = course_mentor;
        this.course_duration = course_duration;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_mentor() {
        return course_mentor;
    }

    public void setCourse_mentor(String course_mentor) {
        this.course_mentor = course_mentor;
    }

    public String getCourse_duration() {
        return course_duration;
    }

    public void setCourse_duration(String course_duration) {
        this.course_duration = course_duration;
    }
}
