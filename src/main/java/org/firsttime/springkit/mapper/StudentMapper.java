package org.firsttime.springkit.mapper;

import org.firsttime.springkit.controller.dto.StudentAddDto;

import java.util.ArrayList;

public interface StudentMapper {
    String addStudent(StudentAddDto studentAddDto);
}
