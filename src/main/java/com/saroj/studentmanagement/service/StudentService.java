package com.saroj.studentmanagement.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.saroj.studentmanagement.dto.StudentDTO;
import com.saroj.studentmanagement.entity.Student;
import com.saroj.studentmanagement.repository.StudentRepository;

import com.saroj.studentmanagement.exception.StudentNotFoundException;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }
    
  
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() ->
                    new StudentNotFoundException("Student not found with id: " + id));
    }
    public Student updateStudent(Long id, Student updatedStudent) {

        Student existingStudent = studentRepository.findById(id)
        		.orElseThrow(() ->
        	    new StudentNotFoundException("Student not found with id: " + id));

        existingStudent.setName(updatedStudent.getName());
        existingStudent.setEmail(updatedStudent.getEmail());
        existingStudent.setCourse(updatedStudent.getCourse());

        return studentRepository.save(existingStudent);
    }
    
    public void deleteStudent(Long id) {

        Student student = studentRepository.findById(id)
        		.orElseThrow(() ->
        	    new StudentNotFoundException("Student not found with id: " + id));
        studentRepository.delete(student);
    }
    
    public Student saveStudent(StudentDTO studentDTO) {

        Student student = new Student();

        student.setName(studentDTO.getName());
        student.setEmail(studentDTO.getEmail());
        student.setCourse(studentDTO.getCourse());

        return studentRepository.save(student);
    }
    
    public List<Student> searchStudentsByName(String name) {
        return studentRepository.findByNameContainingIgnoreCase(name);
    }
    
    
    
    
}