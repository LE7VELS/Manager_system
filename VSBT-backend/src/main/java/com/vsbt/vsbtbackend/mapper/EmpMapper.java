package com.vsbt.vsbtbackend.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vsbt.vsbtbackend.pojo.Emp;
import com.vsbt.vsbtbackend.pojo.EmpExpr;
import com.vsbt.vsbtbackend.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * 员工基本信息Mapper
 */
@Mapper
public interface EmpMapper extends BaseMapper<Emp> {


    /**
     * 根据条件查询员工
     * @param empQueryParam
     * @return
     */

    List<Emp> list(EmpQueryParam empQueryParam);

}
