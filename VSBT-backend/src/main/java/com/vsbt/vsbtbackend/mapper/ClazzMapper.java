package com.vsbt.vsbtbackend.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vsbt.vsbtbackend.pojo.Clazz;
import com.vsbt.vsbtbackend.pojo.ClazzQueryParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClazzMapper extends BaseMapper<Clazz> {

    /**
     * 根据条件查询班级 分页
     * @param clzzQueryParam
     * @return
     */
    List<Clazz> list(ClazzQueryParam clzzQueryParam);
}
