package com.example.OGCourseRegistration.Entity;

import com.example.OGCourseRegistration.Enum.Gender;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity

public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private String  phoneno;
    private String gender;
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "enrolled_courses",
        joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    @JsonManagedReference
    private Set<Courses> enrolledcourse=new HashSet<>();


    public Students(String name, String email, String password, String  phoneno, String gender, Set<Courses> enrolledcourse) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneno = phoneno;
        this.gender = gender;
        this.enrolledcourse = enrolledcourse;
    }
    public void enrollCourse(Courses course) {
        this.enrolledcourse.add(course);
        course.getEnrolledsrtudents().add(this);
    }
    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String  getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Students() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Courses> getEnrolledcourse() {
        return enrolledcourse;
    }

    public void setEnrolledcourse(Courses enrolledcourse) {
        this.enrolledcourse.add(enrolledcourse);
    }
}
