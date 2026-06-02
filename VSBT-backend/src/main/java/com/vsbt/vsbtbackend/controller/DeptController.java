package com.vsbt.vsbtbackend.controller;

import com.vsbt.vsbtbackend.pojo.Dept;
import com.vsbt.vsbtbackend.pojo.Result;
import com.vsbt.vsbtbackend.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {
//    private static final Logger log = LoggerFactory.getLogger(DeptController.class);

    @Autowired
    private DeptService deptService;

    @GetMapping
    public Result list() {
        log.info("查询全部部门数据");
        List<Dept> deptList = deptService.findAll();

        return Result.success(deptList);
    }

    /**
     * 删除部门数据
     * @param id 部门ID
     */
    @DeleteMapping
    public Result delete(Integer id) {
        log.info("删除部门数据, id = {}",id);
        deptService.deleteById(id);
        return Result.success();
    }


    /**
     * 保存部门数据
     * @param dept 部门对象
     */
    @PostMapping
    public Result save(@RequestBody Dept dept) {
        log.info("保存部门数据, dept = {}" , dept);
        deptService.save(dept);
        return Result.success();
    }

    /**
     * 根据ID查询部门数据
     * @param id 部门ID
     * @return 部门对象
     */
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable("id") Integer deptId) {
        System.out.println("获取部门数据, id = " + deptId);
        Dept dept = deptService.findById(deptId);
        return Result.success(dept);
    }


    @PutMapping
    public  Result update(@RequestBody Dept dept) {
        log.info("更新部门数据, dept = {}" , dept);
        deptService.update(dept);
        return Result.success();
    }

}
