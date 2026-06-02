package com.vsbt.vsbtbackend.service.impl;

import com.vsbt.vsbtbackend.mapper.DeptMapper;
import com.vsbt.vsbtbackend.pojo.Dept;
import com.vsbt.vsbtbackend.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    /**
     * 查询全部部门数据
     * @return 部门列表
     */
    @Override
    public List<Dept> findAll() {
        return deptMapper.selectList(null);
    }

    /**
     * 删除部门数据
     * @param id 部门ID
     */
    @Override
    public void deleteById(Integer id) {
        deptMapper.deleteById(id);

    }

    /**
     * 创建新部门
     * @param dept 部门对象
     */
    @Override
    public void save(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());

        System.out.println("id = " + dept.getId());
        deptMapper.insert(dept);
    }

    /**
     * 根据ID查询部门数据
     * @param id 部门ID
     * @return 部门对象
     */
    @Override
    public Dept findById(Integer id) {
        return deptMapper.selectById(id);
    }


    /**
     * 根据ID修改部门数据
     * @param dept 部门对象
     */
    @Override
    public void update(Dept dept){
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.updateById(dept);
    }
}
