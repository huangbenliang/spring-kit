package org.firsttime.springkit.controller.vo;

import lombok.Data;

@Data
public class StudentVo {
    /**
     * 学号
     */
    private String no;
    /**
     * 姓
     */
    private String firstName;

    /**
     * 名
     */
    private String lastName;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 性别
     */
    private String gender;
}