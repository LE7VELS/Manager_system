package com.vsbt.vsbtbackend.controller;


import com.vsbt.vsbtbackend.pojo.Emp;
import com.vsbt.vsbtbackend.pojo.EmpQueryParam;
import com.vsbt.vsbtbackend.pojo.PageResult;
import com.vsbt.vsbtbackend.pojo.Result;
import com.vsbt.vsbtbackend.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping
    public Result page(EmpQueryParam empQueryParam)
    {
        log.info("员工分页查询请求参数： {}", empQueryParam);

        PageResult<Emp> pageResult = empService.page(empQueryParam);
        return Result.success(pageResult);
    }


    /**
     * 保存员工
     * @param emp
     * @return
     */
    @PostMapping
    public Result save(@RequestBody Emp emp){
        log.info("保存员工请求参数： {}", emp);
        empService.save(emp);
        return Result.success();
    }

    /**
     * 删除员工
     * @param id
     * @return
     */
    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids){
        log.info("删除员工请求参数： {}", ids);
        empService.delete(ids);
        return Result.success();
    }

    /**
     * 根据id查询员工
     *
     */
    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id){
        log.info("根据id查询员工请求参数： {}", id);
        Emp emp = empService.getInfo(id);
        return Result.success(emp);
    }

    /**
     * 修改员工信息
     * @param emp
     * @return
     */
    @PutMapping
    public Result update(@RequestBody Emp emp){
        log.info("修改员工信息 {}", emp);
        empService.update(emp);
        return Result.success();
    }

    /**
     * 获取全部员工信息
     *
     */
    @GetMapping("/list")
    public Result listAllEmp(){
        log.info("列出全部员工信息");
        List<Emp> allEmp = empService.listAllEmp();
        return Result.success(allEmp);
    }
}
