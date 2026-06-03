package com.vsbt.vsbtbackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vsbt.vsbtbackend.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {

    @Select("SELECT COUNT(*) FROM student WHERE clazz_id = #{id}")
    Integer countByClazzId(Integer id);
}
