package com.vsbt.vsbtbackend.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.vsbt.vsbtbackend.mapper.StudentMapper;
import com.vsbt.vsbtbackend.pojo.PageResult;
import com.vsbt.vsbtbackend.pojo.StuQueryParam;
import com.vsbt.vsbtbackend.pojo.Student;
import com.vsbt.vsbtbackend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;


    /**
     * 学生分页查询
     * @param stuQueryParam
     * @return PageResult<Student>
     */
    @Override
    public PageResult<Student> page(StuQueryParam stuQueryParam) {
        PageHelper.startPage(stuQueryParam.getPage(), stuQueryParam.getPageSize());
        List<Student> clazzList = studentMapper.list(stuQueryParam);

        Page<Student> p = (Page<Student>) clazzList;
        return new PageResult<Student>(p.getTotal(), p.getResult());
    }

    /**
     * 添加学生数据
     * @param student
     */
    @Override
    public void save(Student student) {
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.insert(student);
    }


    /**
     * 根据ID查询学生信息
     * @param id
     * @return
     */
    @Override
    public Student getById(Integer id) {
        return studentMapper.selectById(id);
    }


    /**
     * 修改学生数据信息
     * @param student
     */
    @Override
    public void update(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.updateById(student);
    }

    /**
     * 批量删除学生信息
     * @param ids
     */
    @Override
    public void delete(List<Integer> ids) {
        studentMapper.deleteByIds(ids);
    }

    /**
     * 违纪处理
     * @param id
     * @param score
     */
    @Override
    public void violationHandle(Integer id, Integer score) {
        studentMapper.updateViolation(id, score);
    }


}
