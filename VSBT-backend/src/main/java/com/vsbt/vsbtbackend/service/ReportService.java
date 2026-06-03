package com.vsbt.vsbtbackend.service;

import com.vsbt.vsbtbackend.pojo.ClazzCountOption;
import com.vsbt.vsbtbackend.pojo.JobOption;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


public interface ReportService {

   /**
    * 统计员工职位数据
    * @return
    */
    JobOption getEmpJobData();


    /**
     * 统计性别数据
     * @return
     */
    List<Map<String, Object>> getEmpGenderData();

    /**
     * 统计学生学位数据
     * @return
     */
    List<Map<String, Object>> getStudentDegreeData();
    /**
     * 统计班级人数数据
     * @return
     */
    ClazzCountOption getStudentCountData();


}
