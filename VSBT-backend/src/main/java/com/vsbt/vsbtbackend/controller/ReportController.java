package com.vsbt.vsbtbackend.controller;


import com.vsbt.vsbtbackend.pojo.ClazzCountOption;
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

    /**
     * 统计员工职位数据
     * @return
     */
    @GetMapping("/empJobData")
    public Result getEmpJobData() {
        log.info("统计员工职位数据");
        JobOption jobOption = reportService.getEmpJobData();
        return Result.success(jobOption);
    }

    /**
     * 统计员工性别数据
     * @return
     */
    @GetMapping("/empGenderData")
    public Result getEmpGenderData() {
        log.info("统计员工性别数据");

        List<Map<String,Object>> genderdata = reportService.getEmpGenderData();
        return Result.success(genderdata);
    }

    /**
     * 统计学生学位数据
     * @return List<Map<String,Object>> degreeData
     */
    @GetMapping("/studentDegreeData")
    public Result getStudentDegreeData() {
        log.info("统计学生学位数据");
        List<Map<String,Object>> degreeData = reportService.getStudentDegreeData();
        return Result.success(degreeData);
    }


    /**
     * 班级人数统计
     * @return clazzCountOption
     */
    @GetMapping("/studentCountData")
    public Result getStudentCountData() {
        log.info("班级人数统计");
        ClazzCountOption clazzCountOption = reportService.getStudentCountData();
        return Result.success(clazzCountOption);
    }

}
