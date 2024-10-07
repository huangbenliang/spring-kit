package org.firsttime.springkit.service.impl;


import org.firsttime.springkit.controller.dto.StudentAddDto;
import org.firsttime.springkit.mapper.StudentMapper;
import org.firsttime.springkit.service.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentMapper studentMapper;

    public StudentServiceImpl(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @Override
    public String addStudent(StudentAddDto studentAddDto) {
        if (studentAddDto.getAge() <= 0 || studentAddDto.getAge() > 100) {
            throw new IllegalArgumentException("student age is valid");
        }
        return studentMapper.addStudent(studentAddDto);
    }
}
