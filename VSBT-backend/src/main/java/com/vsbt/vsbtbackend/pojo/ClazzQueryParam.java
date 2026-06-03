package com.vsbt.vsbtbackend.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class ClazzQueryParam {
    // 班级列表分页查询参数
    private Integer page = 1; //页码
    private Integer pageSize = 10; //每页展示记录数
    private String name; //姓名

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate begin; //范围匹配的开始时间(结课时间)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate end; //范围匹配的结束时间(结课时间)
}
