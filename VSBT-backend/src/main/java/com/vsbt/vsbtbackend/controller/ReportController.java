package com.vsbt.vsbtbackend.controller;


import com.vsbt.vsbtbackend.pojo.JobOption;
import com.vsbt.vsbtbackend.pojo.Result;
import com.vsbt.vsbtbackend.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService reportService;


    @GetMapping("/empJobData")
    public Result getEmpJobData() {
        log.info("统计员工职位数据");
        JobOption jobOption = reportService.getEmpJobData();
        return Result.success(jobOption);
    }

    @GetMapping("/empGenderData")
    public Result getEmpGenderData() {
        log.info("统计员工性别数据");

        List<Map<String,Object>> genderdata = reportService.getEmpGenderData();
        return Result.success(genderdata);
    }
}
