package com.example.OGCourseRegistration.Repository;

import com.example.OGCourseRegistration.Entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoStudent extends JpaRepository<Students,Long> {
}
