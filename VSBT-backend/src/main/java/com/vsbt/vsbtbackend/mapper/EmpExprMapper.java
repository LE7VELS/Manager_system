package com.vsbt.vsbtbackend.mapper;


import com.vsbt.vsbtbackend.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * 员工工作经历Mapper
 */
@Mapper
public interface EmpExprMapper {


    /**
     * 批量插入员工工作经历
     * @param exprList
     */
    void insertExprList(List<EmpExpr> exprList);
}
