package com.vsbt.vsbtbackend.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vsbt.vsbtbackend.pojo.Emp;
import com.vsbt.vsbtbackend.pojo.EmpExpr;
import com.vsbt.vsbtbackend.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;


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

    /**
     * 根据id查询员工
     * @param id
     * @return
     */
    Emp getById(Integer id);


    /**
     * 统计员工职位数据
     * @return
     */
    List<Map<String,Object>> countEmpJobData();

    /**
     * 统计员工性别数据
     * @return
     */
    List<Map<String,Object>> getEmpGenderData();

    /**
     * 根据班级ID统计员工数量
     * @param id
     * @return Integer
     */
    @Select("SELECT COUNT(*) FROM emp WHERE dept_id = #{id}")
    Integer countByEmpId(Integer id);


    @Select("SELECT * FROM emp WHERE username = #{username} AND password = #{password}")
    Emp getUsernameAndPassword(Emp emp);
}
