package com.vsbt.vsbtbackend.service.impl;

import com.vsbt.vsbtbackend.mapper.EmpMapper;
import com.vsbt.vsbtbackend.mapper.StudentMapper;
import com.vsbt.vsbtbackend.pojo.ClazzCountOption;
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

    @Autowired
    private StudentMapper studentMapper;


    /**
     * 统计员工职位数据
     * @return
     */
    @Override
    public JobOption getEmpJobData() {
        List<Map<String,Object>> lists =  empMapper.countEmpJobData();

        List<Object> jobList = lists.stream().map(map -> map.get("pos")).toList();
        List<Object> dataList = lists.stream().map(map -> map.get("total")).toList();

        return new JobOption(jobList, dataList);
    }

    /**
     * 统计员工性别数据
     * @return
     */
    @Override
    public List<Map<String, Object>> getEmpGenderData() {

        return empMapper.getEmpGenderData();
    }

    /**
     * 统计学生学位数据
     * @return
     */
    @Override
    public List<Map<String, Object>> getStudentDegreeData() {

        return studentMapper.countStudentDegreeData();
    }

    @Override
    public ClazzCountOption getStudentCountData() {
        List<Map<String, Object>> countList = studentMapper.getStudentCount();
        List<Object> classList = countList.stream().map(map -> map.get("cname")).toList();
        List<Object> dataList = countList.stream().map(map -> map.get("scount")).toList();
        return new ClazzCountOption(classList, dataList);
    }
}
