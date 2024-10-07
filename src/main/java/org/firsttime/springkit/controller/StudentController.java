package org.firsttime.springkit.controller;

import org.firsttime.springkit.controller.dto.StudentAddDto;
import org.firsttime.springkit.controller.vo.StudentVo;
import org.firsttime.springkit.domain.Student;
import org.firsttime.springkit.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * 创建学生
     *
     * @param studentAddDto 学生信息
     * @return 学生id
     */
    @PostMapping
    public ResponseEntity<String> addStudent(@RequestBody StudentAddDto studentAddDto) {
        String studentId = studentService.addStudent(studentAddDto);
        return ResponseEntity.ok(studentId);
    }

    /**
     * 查询学生，根据id或者学号
     *
     * @param studentId 学生id
     * @param studentNo 学生学号
     * @return 学生对象
     */
    @GetMapping(value = {"/{student_id}", "/no/{student_no}"})
    public ResponseEntity<StudentVo> getStudent(@PathVariable(value = "student_id", required = false) Optional<String> studentId, @PathVariable(value = "student_no", required = false) String studentNo) {
        Student student = new Student();
        studentId.ifPresent(id -> student.setId(Integer.parseInt(id)));
        student.setNo(studentNo);

        Student studentRes = studentService.getStudent(student);
        if (studentRes == null) {
            return ResponseEntity.ok(null);
        }
        StudentVo studentVo = new StudentVo();
        BeanUtils.copyProperties(student, studentVo);
        return ResponseEntity.ok(studentVo);
    }
}