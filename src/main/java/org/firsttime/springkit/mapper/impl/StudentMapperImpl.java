package org.firsttime.springkit.mapper.impl;

import org.firsttime.springkit.controller.dto.StudentAddDto;
import org.firsttime.springkit.domain.Student;
import org.firsttime.springkit.mapper.StudentMapper;
import org.firsttime.springkit.mapper.pojo.StudentDo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentMapperImpl implements StudentMapper {
    // 先存入内存，后续集成mysql
    private final List<StudentDo> students = new ArrayList<>();

    @Override
    public String addStudent(StudentAddDto studentAddDto) {
        StudentDo student = new StudentDo();
        BeanUtils.copyProperties(studentAddDto, student);
        prepareStudent(student);

        students.add(student);
        return String.valueOf(student.getId());
    }

    @Override
    public Student getStudent(Student student) {
        List<StudentDo> res = students;
        if (student.getId() != null) {
            res = res.stream().filter(s -> s.getId().equals(student.getId())).toList();
        }
        if (StringUtils.hasText(student.getNo())) {
            res = res.stream().filter(s -> s.getNo().equals(student.getNo())).toList();
        }

        if (CollectionUtils.isEmpty(res)) {
            return null;
        }
        BeanUtils.copyProperties(res.get(0), student);
        return student;
    }

    private void prepareStudent(StudentDo student) {
        student.setId(students.size());
    }
}
