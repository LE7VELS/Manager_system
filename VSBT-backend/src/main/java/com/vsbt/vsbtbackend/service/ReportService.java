package com.vsbt.vsbtbackend.service;

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

    List<Map<String, Object>> getEmpGenderData();
}
