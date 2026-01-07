package com.example.OGCourseRegistration.Controller;

import com.example.OGCourseRegistration.DTO.*;
import com.example.OGCourseRegistration.Entity.Courses;
import com.example.OGCourseRegistration.Entity.Students;
import com.example.OGCourseRegistration.Service.ServiceCourse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class ControllerCourse {
    @Autowired
    private ServiceCourse serv;

    @PostMapping("addstudent")
    public Students addStudent(@RequestBody @Valid StudentDto student){
        return serv.addStudent(student);
    }
    @PostMapping("addcourse")
    public Courses addCourse(@RequestBody @Valid CourseDto course){
        return serv.addCourse(course);
    }
    @PostMapping("enrollcourse/{student_id}/{course_id}")
    public Students enrollcourse(@PathVariable long student_id,@PathVariable long course_id){
        return serv.enrollcourse(student_id,course_id);
    }
    @GetMapping("course")
    public List<Courses> allCourses(){
        return serv.allCourses();
    }
    @GetMapping("students")
    public List<ResponseStudentDto> allStudents(){
        return serv.allStudents();
    }
    @GetMapping("students/{id}")
    public Students getStudent(@PathVariable long id){
        return serv.getStudent(id);
    }
    @GetMapping("course/{id}")
    public Courses getcourse(@PathVariable long id){
        return serv.getCourse(id);
    }
    @GetMapping("students/enrolledcourses/{id}")
    public StudentCourseResonseDto getAllCourseEnroledby(@PathVariable long id){
        return serv.getAllCourseEnroledby(id);
    }
    @GetMapping("course/enrolledstudents/{id}")
    public Set<Students> getAllStudentEnroledbycourse(@PathVariable long id){
        return serv.getAllStudentEnroledby(id);
    }
    @PutMapping("/updatestudent/{id}")
    public Students updateStudent(@PathVariable long id, @RequestBody updateStudentDto updatestudent){
        return serv.updateStudent(id,updatestudent);
    }
    @PutMapping("/updatecourse/{id}")
    public Courses updateCourse(@PathVariable long id,@RequestBody CourseDto courese){
        return serv.updateCourse(id,courese);
    }
    @DeleteMapping("/deletestudent/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable long id){
        return serv.deleteStudent(id);
    }
    @DeleteMapping("/deletecourse/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable long id){
        return serv.deleteCourse(id);
    }
}
