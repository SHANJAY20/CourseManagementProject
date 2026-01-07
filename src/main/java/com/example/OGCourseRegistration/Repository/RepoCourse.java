package com.example.OGCourseRegistration.Repository;

import com.example.OGCourseRegistration.Entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoCourse extends JpaRepository<Courses, Long> {
}
