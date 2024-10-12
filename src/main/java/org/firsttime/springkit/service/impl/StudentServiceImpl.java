package org.firsttime.springkit.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.firsttime.springkit.controller.dto.StudentAddDto;
import org.firsttime.springkit.domain.Student;
import org.firsttime.springkit.mapper.StudentMapper;
import org.firsttime.springkit.mapper.pojo.StudentDo;
import org.firsttime.springkit.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, StudentDo> implements StudentService {

    @Override
    public String addStudent(StudentAddDto studentAddDto) {
        if (studentAddDto.getAge() <= 0 || studentAddDto.getAge() > 100) {
            throw new IllegalArgumentException("studentDo age is valid");
        }

        StudentDo studentDo = new StudentDo();
        BeanUtils.copyProperties(studentAddDto, studentDo);
        this.save(studentDo);
        return String.valueOf(studentDo.getId());
    }

    @Override
    public Student getStudent(Student student) {
        LambdaQueryWrapper<StudentDo> queryWrapper = Wrappers.lambdaQuery(StudentDo.class).eq(student.getId() != null
                , StudentDo::getId, student.getId()).eq(student.getNo() != null, StudentDo::getNo, student.getNo());

        StudentDo studentDo = this.baseMapper.selectOne(queryWrapper);
        if (studentDo == null) {
            return null;
        }
        BeanUtils.copyProperties(studentDo, student);
        return student;
    }
}
