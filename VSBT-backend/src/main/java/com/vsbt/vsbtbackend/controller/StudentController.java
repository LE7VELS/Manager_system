package com.vsbt.vsbtbackend.controller;


import com.vsbt.vsbtbackend.pojo.*;
import com.vsbt.vsbtbackend.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;


    /**
     * 学生分页查询
     * @param stuQueryParam
     * @return PageResult<Student>
     */
    @GetMapping
    public Result page(StuQueryParam stuQueryParam) {
        log.info("班级分页查询请求参数： {}", stuQueryParam);
        PageResult<Student> pageResult = studentService.page(stuQueryParam);
        return Result.success(pageResult);
    }


    /**
     * 添加学生数据
     * @param student
     * @return
     */
    @PostMapping
    public Result save(@RequestBody Student student) {
        log.info("添加学生数据： {}", student);
        studentService.save(student);
        return Result.success();
    }

    /**
     * 根据ID查询学生信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id) {
        log.info("根据ID查询学生信息： {}", id);
        Student student = studentService.getById(id);
        return Result.success(student);
    }

    /**
     * 修改学生数据信息
     * @param student
     * @return
     */
    @PutMapping
    public Result update(@RequestBody Student student) {
        log.info("修改学生数据信息： {}", student);
        studentService.update(student);
        return Result.success();
    }

    /**
     * 批量删除学生信息
     * @param ids
     * @return
     */
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids) {
        studentService.delete(ids);
        return Result.success();
    }


    /**
     * 违纪处理
     * @param id
     * @param score
     * @return
     */
    @PutMapping("/violation/{id}/{score}")
    public Result violationHandle(@PathVariable Integer id,
                                  @PathVariable Integer score)
    {
        studentService.violationHandle(id, score);
        return Result.success();
    }
}
