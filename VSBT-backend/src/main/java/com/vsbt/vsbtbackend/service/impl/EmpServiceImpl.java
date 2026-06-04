package com.vsbt.vsbtbackend.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.vsbt.vsbtbackend.mapper.EmpExprMapper;
import com.vsbt.vsbtbackend.mapper.EmpMapper;
import com.vsbt.vsbtbackend.pojo.*;
import com.vsbt.vsbtbackend.service.EmpService;
import com.vsbt.vsbtbackend.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static tools.jackson.databind.cfg.CoercionInputShape.Array;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private EmpExprMapper empExprMapper;

    /**
     * 分页查询员工数据
     * @param page 页码
     * @param pageSize 每页大小
     * @return 分页结果
     */
    @Override
    public PageResult<Emp> page(EmpQueryParam empQueryParam) {
        PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());

        List<Emp> empList = empMapper.list(empQueryParam);

        Page<Emp> p = (Page<Emp>) empList;
        return new PageResult<Emp>(p.getTotal(), p.getResult());
    }


    /**
     * 保存员工
     * @param emp
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void save(Emp emp) {
        //设置创建时间和更新时间
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());

        //保存员工基本信息
        empMapper.insert(emp);

        //保存员工的工作经历
        Integer empId = emp.getId();
        List<EmpExpr> exprList = emp.getExprList();
        if(!CollectionUtils.isEmpty(exprList)){
            exprList.forEach(expr->expr.setEmpId(empId));
            empExprMapper.insertExprList(exprList);
        }
    }

    /**
     * 删除员工
     * @param ids
     */
    @Transactional
    @Override
    public void delete(List<Integer> ids) {

        // mybatis-plus 特性
        empMapper.deleteByIds(ids);
        empExprMapper.deleteByEmpIds(ids);
    }

    /**
     * 根据id查询员工
     * @param id
     * @return
     */
    @Override
    public Emp getInfo(Integer id) {
        return empMapper.getById(id);
    }

    /**
     * 更新员工信息
     * @param emp
     */
    @Transactional
    @Override
    public void update(Emp emp) {
        // 员工基本信息
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.updateById(emp);

        // 删除旧的员工经历信息
        empExprMapper.deleteByEmpIds(Arrays.asList(emp.getId()));

        //增加新的员工信息

        Integer empId = emp.getId();
        List<EmpExpr> exprList = emp.getExprList();
        if(!CollectionUtils.isEmpty(exprList)){
            exprList.forEach(expr->expr.setEmpId(empId));
            empExprMapper.insertExprList(exprList);
        }
    }

    @Override
    public List<Emp> listAllEmp() {
        return empMapper.selectList(null);
    }


    /**
     * 登录
     * @param emp
     * @return
     */
    @Override
    public LoginInfo login(Emp emp) {
        Emp empLogin = empMapper.getUsernameAndPassword(emp);
        if(empLogin != null){
            Map<String,Object> datamap = new HashMap<>();
            datamap.put("id", empLogin.getId());
            datamap.put("username", empLogin.getUsername());

            String jwt = JwtUtils.generateJwt(datamap);
            LoginInfo loginInfo = new LoginInfo(empLogin.getId(), empLogin.getUsername(), empLogin.getName(), jwt);
            return loginInfo;
        }
        return null;
    }


}
