package com.example.OGCourseRegistration.Service;

import com.example.OGCourseRegistration.DTO.*;
import com.example.OGCourseRegistration.Entity.Courses;
import com.example.OGCourseRegistration.Entity.Students;
import com.example.OGCourseRegistration.Exception.CourseNotFound;
import com.example.OGCourseRegistration.Exception.StudentNotFound;
import com.example.OGCourseRegistration.Repository.RepoCourse;
import com.example.OGCourseRegistration.Repository.RepoStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class ServiceCourse {
    @Autowired
    private RepoCourse repoCourse;
    @Autowired
    private RepoStudent repostu;
    public Students addStudent(StudentDto student) {
        Students newstudent=new Students();
        newstudent.setName(student.getName());
        newstudent.setEmail(student.getEmail());
        newstudent.setPassword(student.getPassword());
        newstudent.setGender(student.getGender());
        newstudent.setPhoneno(student.getPhoneno());
        return repostu.save(newstudent);
    }
    public Courses addCourse(CourseDto course){
        Courses newcourse=new Courses();
        newcourse.setCourse_name(course.getCourse_name());
        newcourse.setCourse_duration(course.getCourse_duration());
        newcourse.setCourse_mentor(course.getCourse_mentor());
        return repoCourse.save(newcourse);
    }

    public Students enrollcourse(long studentId, long courseId) {
        Students student=repostu.findById(studentId).orElseThrow(()->new StudentNotFound("student not found"));
        Courses course=repoCourse.findById(courseId).orElseThrow(()->new CourseNotFound("course not found"));
        student.enrollCourse(course);
        return repostu.save(student);
    }

    public List<Courses> allCourses() {
        return repoCourse.findAll();
    }
    public List<ResponseStudentDto> allStudents() {
        List<Students> students = repostu.findAll();

        List<ResponseStudentDto> response = new ArrayList<>();

        for (Students s : students) {
            ResponseStudentDto dto =
                    new ResponseStudentDto(
                            s.getId(),
                            s.getName(),
                            s.getEmail()
                    );
            response.add(dto);
        }

        return response;
    }


    public StudentCourseResonseDto getAllCourseEnroledby(long id) {
        Students stu = repostu.findById(id)
                .orElseThrow(() -> new StudentNotFound("Student not found"));
        StudentCourseResonseDto response = new StudentCourseResonseDto();
        response.setCourses(stu.getEnrolledcourse());
        response.setName(stu.getName());
        response.setEmail(stu.getEmail());
        return response;
    }

    public Set<Students> getAllStudentEnroledby(long id) {
        Courses course=repoCourse.findById(id).orElseThrow(()->new CourseNotFound("Course not found"));
        return course.getEnrolledsrtudents();
    }

    public Students getStudent(long id) {
        Students student=repostu.findById(id).orElseThrow(()->new StudentNotFound("Student not Found"));
        return student;
    }

    public Courses getCourse(long id) {
        Courses course=repoCourse.findById(id).orElseThrow(()->new CourseNotFound("Course not found"));
        return course;
    }

    public Students updateStudent(long id, updateStudentDto student) {
        Students stu=repostu.findById(id).orElseThrow(()->new StudentNotFound("student not found with "+id));
        stu.setName(student.getName());
        stu.setEmail(student.getEmail());
        stu.setPhoneno(student.getPhoneno());
        stu.setGender(student.getGender());
        return repostu.save(stu);
    }
    public Courses updateCourse(long id, CourseDto coursedto) {
        Courses course=repoCourse.findById(id).orElseThrow(()->new CourseNotFound("course not found with "+id));
        course.setCourse_name(coursedto.getCourse_name());
        course.setCourse_mentor(course.getCourse_mentor());
        course.setCourse_duration(course.getCourse_duration());
        return repoCourse.save(course);
    }

    public ResponseEntity<String> deleteStudent(long id) {
        Students student=repostu.findById(id).orElseThrow(()->new StudentNotFound("student not found with "+id));
        repostu.deleteById(id);
        return ResponseEntity.ok().body("deleted");
    }
    public ResponseEntity<String> deleteCourse(long id) {
        Courses course=repoCourse.findById(id).orElseThrow(()->new CourseNotFound("course not found with "+id));
        repoCourse.deleteById(id);
        return ResponseEntity.ok().body("deleted");
    }
}
