package com.vsbt.vsbtbackend.service;

import com.vsbt.vsbtbackend.pojo.Clazz;
import com.vsbt.vsbtbackend.pojo.ClazzQueryParam;
import com.vsbt.vsbtbackend.pojo.PageResult;

public interface ClazzService {
    /**
     * 班级分页查询
     * @param clzzQueryParam
     * @return
     */
    PageResult<Clazz> page(ClazzQueryParam clzzQueryParam);


    /**
     * 添加班级数据
     * @param clzz
     */
    void save(Clazz clzz);

    Clazz getById(Integer id);

    void update(Clazz clzz);

    void delete(Integer id);
}
