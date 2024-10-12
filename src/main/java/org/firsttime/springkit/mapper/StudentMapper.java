package org.firsttime.springkit.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.firsttime.springkit.mapper.pojo.StudentDo;

@Mapper
public interface StudentMapper extends BaseMapper<StudentDo> {
}
