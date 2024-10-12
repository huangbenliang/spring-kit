package org.firsttime.springkit.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.firsttime.springkit.controller.dto.StudentAddDto;
import org.firsttime.springkit.domain.Student;
import org.firsttime.springkit.mapper.pojo.StudentDo;

public interface StudentService extends IService<StudentDo> {
    String addStudent(StudentAddDto studentAddDto);

    Student getStudent(Student student);
}
