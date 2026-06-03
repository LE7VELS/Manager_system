package com.vsbt.vsbtbackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vsbt.vsbtbackend.pojo.StuQueryParam;
import com.vsbt.vsbtbackend.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {

    /**
     * 根据班级ID统计学生数量
     * @param id
     * @return Integer
     */
    @Select("SELECT COUNT(*) FROM student WHERE clazz_id = #{id}")
    Integer countByClazzId(Integer id);

    /**
     * 分页查询学生数据
     * @param stuQueryParam
     * @return List<Student>
     */
    List<Student> list(StuQueryParam stuQueryParam);

    /**
     * 更新违纪信息
     * @param id
     * @param score
     */
    @Update("update student set violation_count = violation_count + 1 , violation_score = violation_score + #{score} , update_time = now() where id = #{id}")
    void updateViolation(Integer id, Integer score);


    /**
     * 统计学生学位数据
     * @return
     */
    List<Map<String,Object>> countStudentDegreeData();


    @Select("select c.name cname, count(s.id) scount from clazz c left join student s on c.id = s.clazz_id group by c.id")
    List<Map<String,Object>> getStudentCount();
}
