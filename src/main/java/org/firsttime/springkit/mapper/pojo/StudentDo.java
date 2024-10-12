package org.firsttime.springkit.mapper.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName(value = "student", autoResultMap = true)
public class StudentDo {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 学号
     */
    private String no;
    /**
     * 姓
     */
    @TableField("first_name")
    private String firstName;

    /**
     * 名
     */
    @TableField("last_name")
    private String lastName;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 性别
     */
    private String gender;

    /**
     * create date time.
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * update date time.
     */
    @TableField("update_time")
    private LocalDateTime updateTime;
}