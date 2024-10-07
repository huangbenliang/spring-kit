package org.firsttime.springkit.mapper;

import org.firsttime.springkit.controller.dto.StudentAddDto;
import org.firsttime.springkit.domain.Student;

public interface StudentMapper {
    String addStudent(StudentAddDto studentAddDto);

    Student getStudent(Student student);
}
