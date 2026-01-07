package com.example.OGCourseRegistration.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String course_name;
    private String course_mentor;
    private String course_duration;
    @ManyToMany(mappedBy = "enrolledcourse",fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<Students> enrolledsrtudents=new HashSet<>();

    public Courses(String course_name, String course_mentor, String course_duration, Set<Students> enrolledsrtudents) {
        this.course_name = course_name;
        this.course_mentor = course_mentor;
        this.course_duration = course_duration;
        this.enrolledsrtudents = enrolledsrtudents;
    }

    public Courses() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<Students> getEnrolledsrtudents() {
        return enrolledsrtudents;
    }

    public void setEnrolledsrtudents(Set<Students> enrolledsrtudents) {
        this.enrolledsrtudents = enrolledsrtudents;
    }
}
