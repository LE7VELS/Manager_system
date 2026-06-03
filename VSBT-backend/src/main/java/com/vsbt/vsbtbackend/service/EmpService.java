package com.vsbt.vsbtbackend.service;

import com.vsbt.vsbtbackend.pojo.Emp;
import com.vsbt.vsbtbackend.pojo.EmpQueryParam;
import com.vsbt.vsbtbackend.pojo.PageResult;

import java.util.List;

public interface EmpService {

    PageResult<Emp> page(EmpQueryParam empQueryParam);

    /**
     * 保存员工
     * @param emp
     */
    void save(Emp emp);

    /**
     * 删除员工
     * @param ids
     */
    void delete(List<Integer> ids);

    /**
     * 根据id查询员工
     * @param id
     * @return
     */
    Emp getInfo(Integer id);

    void update(Emp emp);

    List<Emp> listAllEmp();
}
