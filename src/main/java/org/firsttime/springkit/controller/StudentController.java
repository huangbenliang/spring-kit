package org.firsttime.springkit.controller;

import org.firsttime.springkit.controller.dto.StudentAddDto;
import org.firsttime.springkit.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<String> getStudentById(@RequestBody StudentAddDto studentAddDto) {
        String studentId = studentService.addStudent(studentAddDto);
        return ResponseEntity.ok(studentId);
    }
}