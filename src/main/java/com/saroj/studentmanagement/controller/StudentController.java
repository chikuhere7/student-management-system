package com.saroj.studentmanagement.controller;

import java.util.List;




import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.saroj.studentmanagement.entity.Student;
import com.saroj.studentmanagement.service.StudentService;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.DeleteMapping;

import com.saroj.studentmanagement.dto.StudentDTO;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;



@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping("/students")
    public ResponseEntity<Student> saveStudent(
            @Valid @RequestBody StudentDTO studentDTO) {

        Student savedStudent = studentService.saveStudent(studentDTO);

        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }
    
    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }
    
    
    @PutMapping("/students/{id}")
    public Student updateStudent(
            @PathVariable Long id,
            @RequestBody Student student) {

        return studentService.updateStudent(id, student);
    }
    
    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id) {

        studentService.deleteStudent(id);
        return "Student deleted successfully";
    }
    
    @GetMapping("/students/search/{name}")
    public List<Student> searchStudents(@PathVariable String name) {
        return studentService.searchStudentsByName(name);
    }
    
}