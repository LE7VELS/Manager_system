package com.vsbt.vsbtbackend.controller;


import com.vsbt.vsbtbackend.pojo.Emp;
import com.vsbt.vsbtbackend.pojo.EmpQueryParam;
import com.vsbt.vsbtbackend.pojo.PageResult;
import com.vsbt.vsbtbackend.pojo.Result;
import com.vsbt.vsbtbackend.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
