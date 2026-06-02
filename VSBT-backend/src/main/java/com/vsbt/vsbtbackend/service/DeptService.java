package com.vsbt.vsbtbackend.service;

import com.vsbt.vsbtbackend.pojo.Dept;

import java.util.List;

public interface DeptService {
    /**
     * 查询全部部门数据
     * @return 部门列表
     */
    List<Dept> findAll();

    /**
     * 删除部门数据
     * @param id 部门ID
     */
    void deleteById(Integer id);

    /**
     * 保存部门数据
     * @param dept 部门对象
     */
    void save(Dept dept);

    /**
     * 根据ID查询部门数据
     * @param id 部门ID
     * @return 部门对象
     */
    Dept findById(Integer id);

    /**
     * 更新部门数据
     * @param dept 部门对象
     */
    void update(Dept dept);
}
