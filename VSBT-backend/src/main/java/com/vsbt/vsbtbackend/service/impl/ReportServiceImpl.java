package com.vsbt.vsbtbackend.service.impl;

import com.vsbt.vsbtbackend.mapper.EmpMapper;
import com.vsbt.vsbtbackend.pojo.JobOption;
import com.vsbt.vsbtbackend.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private EmpMapper empMapper;



    @Override
    public JobOption getEmpJobData() {
        List<Map<String,Object>> lists =  empMapper.countEmpJobData();

        List<Object> jobList = lists.stream().map(map -> map.get("pos")).toList();
        List<Object> dataList = lists.stream().map(map -> map.get("total")).toList();

        return new JobOption(jobList, dataList);
    }

    @Override
    public List<Map<String, Object>> getEmpGenderData() {

        return empMapper.getEmpGenderData();
    }
}
