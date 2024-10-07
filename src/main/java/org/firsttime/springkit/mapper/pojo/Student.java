package org.firsttime.springkit.mapper.pojo;

import lombok.Data;

@Data
public class Student {
    /**
     * id
     */
    private Integer id;
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