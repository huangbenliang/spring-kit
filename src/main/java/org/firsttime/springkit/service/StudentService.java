package org.firsttime.springkit.service;

import org.firsttime.springkit.controller.dto.StudentAddDto;
import org.firsttime.springkit.domain.Student;

public interface StudentService {
    String addStudent(StudentAddDto studentAddDto);

    Student getStudent(Student student);
}
