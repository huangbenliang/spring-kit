package org.firsttime.springkit.mapper.impl;

import org.firsttime.springkit.controller.dto.StudentAddDto;
import org.firsttime.springkit.mapper.StudentMapper;
import org.firsttime.springkit.mapper.pojo.Student;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentMapperImpl implements StudentMapper {
    // 先存入内存，后续集成mysql
    private final List<Student> students = new ArrayList<>();

    @Override
    public String addStudent(StudentAddDto studentAddDto) {
        Student student = new Student();
        BeanUtils.copyProperties(studentAddDto, student);
        prepareStudent(student);

        students.add(student);
        return String.valueOf(student.getId());
    }

    private void prepareStudent(Student student) {
        student.setId(students.size());
    }
}
