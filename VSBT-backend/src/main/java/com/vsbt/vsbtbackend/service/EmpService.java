package com.vsbt.vsbtbackend.service;

import com.vsbt.vsbtbackend.pojo.Emp;
import com.vsbt.vsbtbackend.pojo.EmpQueryParam;
import com.vsbt.vsbtbackend.pojo.PageResult;

public interface EmpService {

    PageResult<Emp> page(EmpQueryParam empQueryParam);

    void save(Emp emp);
}
