package com.vsbt.vsbtbackend.service;


import com.vsbt.vsbtbackend.pojo.PageResult;
import com.vsbt.vsbtbackend.pojo.StuQueryParam;
import com.vsbt.vsbtbackend.pojo.Student;

import java.util.List;

public interface StudentService {

    /**
     * 学生分页查询
     * @param stuQueryParam
     * @return PageResult<Student>
     */
    PageResult<Student> page(StuQueryParam stuQueryParam);


    /**
     * 添加学生数据
     * @param student
     */
    void save(Student student);


    /**
     * 根据ID查询学生信息
     * @param id
     * @return Student
     */
    Student getById(Integer id);


    /**
     * 修改学生数据信息
     * @param student
     */
    void update(Student student);

    /**
     * 批量删除学生信息
     * @param ids
     */
    void delete(List<Integer> ids);

    /**
     * 违纪处理
     * @param id
     * @param score
     */
    void violationHandle(Integer id, Integer score);
}
