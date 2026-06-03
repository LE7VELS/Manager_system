package com.vsbt.vsbtbackend.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vsbt.vsbtbackend.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * 员工工作经历Mapper
 */
@Mapper
public interface EmpExprMapper extends BaseMapper<EmpExpr> {


    /**
     * 批量插入员工工作经历
     * @param exprList
     */
    void insertExprList(List<EmpExpr> exprList);


    void deleteByEmpIds(List<Integer> empIds);
}
