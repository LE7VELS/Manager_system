package com.vsbt.vsbtbackend.service;

import com.vsbt.vsbtbackend.pojo.Clazz;
import com.vsbt.vsbtbackend.pojo.ClazzQueryParam;
import com.vsbt.vsbtbackend.pojo.PageResult;

import java.util.List;

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


    /**
     * 根据ID查询班级数据
     * @param id
     * @return
     */
    Clazz getById(Integer id);

    /**
     * 更新班级数据
     * @param clzz
     */
    void update(Clazz clzz);


    /**
     * 删除班级数据
     * @param id
     */
    void delete(Integer id);

    List<Clazz> showAll();
}
