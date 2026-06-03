package com.vsbt.vsbtbackend.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.vsbt.vsbtbackend.mapper.ClazzMapper;
import com.vsbt.vsbtbackend.mapper.StudentMapper;
import com.vsbt.vsbtbackend.pojo.Clazz;
import com.vsbt.vsbtbackend.pojo.ClazzQueryParam;
import com.vsbt.vsbtbackend.pojo.Emp;
import com.vsbt.vsbtbackend.pojo.PageResult;
import com.vsbt.vsbtbackend.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzMapper clazzMapper;

    @Autowired
    private StudentMapper studentMapper;

    /**
     * 班级分页查询
     * @param clzzQueryParam
     * @return
     */
    @Override
    public PageResult<Clazz> page(ClazzQueryParam clzzQueryParam) {

        PageHelper.startPage(clzzQueryParam.getPage(), clzzQueryParam.getPageSize());
        List<Clazz> clazzList = clazzMapper.list(clzzQueryParam);

        Page<Clazz> p = (Page<Clazz>) clazzList;
        return new PageResult<Clazz>(p.getTotal(), p.getResult());

    }

    /**
     * 添加班级数据
     * @param clzz
     */
    @Override
    public void save(Clazz clzz) {
        //设置创建时间和更新时间
        clzz.setCreateTime(LocalDateTime.now());
        clzz.setUpdateTime(LocalDateTime.now());
        clazzMapper.insert(clzz);
    }

    /**
     * 根据id查询班级数据
     * @param id
     * @return
     */
    @Override
    public Clazz getById(Integer id) {
        return clazzMapper.selectById(id);
    }

    /**
     * 更新班级数据
     * @param clzz
     */
    @Override
    public void update(Clazz clzz) {
        clzz.setUpdateTime(LocalDateTime.now());
        clazzMapper.updateById(clzz);
    }


    /**
     * 删除指定班级
     * @param id
     */
    @Override
    public void delete(Integer id) {
        Integer count = studentMapper.countByClazzId(id);
        if (count > 0) {
            throw new RuntimeException("该班级下有学生，无法删除");
        }
        clazzMapper.deleteById(id);
    }

    @Override
    public List<Clazz> showAll() {
        return clazzMapper.selectList(null);
    }


}
