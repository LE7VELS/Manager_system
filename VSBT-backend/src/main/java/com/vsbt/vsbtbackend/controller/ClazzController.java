package com.vsbt.vsbtbackend.controller;


import com.vsbt.vsbtbackend.pojo.Clazz;
import com.vsbt.vsbtbackend.pojo.ClazzQueryParam;
import com.vsbt.vsbtbackend.pojo.PageResult;
import com.vsbt.vsbtbackend.pojo.Result;
import com.vsbt.vsbtbackend.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/clazzs")
public class ClazzController {

    @Autowired
    private ClazzService clzzService;


    /**
     * 班级分页查询
     * @param clzzQueryParam
     * @return
     */
    @GetMapping
    public Result page(ClazzQueryParam clzzQueryParam) {
        log.info("班级分页查询请求参数： {}", clzzQueryParam);
        PageResult<Clazz> pageResult = clzzService.page(clzzQueryParam);
        return Result.success(pageResult);
    }

    /**
     * 添加班级数据
     * @param clzz
     * @return
     */
    @PostMapping
    public Result addClazz(@RequestBody Clazz clzz) {
        log.info("添加班级数据请求参数： {}", clzz);
        clzzService.save(clzz);
        return Result.success();
    }

    /**
     * 根据ID查询班级信息
     * @param id
     * @return clzz
     */
    @GetMapping("/{id}")
    public Result getClazzById(@PathVariable Integer id) {
        log.info("根据ID查询班级信息： {}", id);
        Clazz clzz = clzzService.getById(id);
        return Result.success(clzz);
    }

    /**
     * 修改班级数据信息
     * @param clzz
     * @return
     */
    @PutMapping
    public Result updateClazz(@RequestBody Clazz clzz) {
        log.info("修改班级数据信息： {}", clzz);
        clzzService.update(clzz);
        return Result.success();
    }


    /**
     * 删除班级信息
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result deleteClazz(@PathVariable Integer id) {
        log.info("删除班级数据信息： {}", id);
        clzzService.delete(id);
        return Result.success();
    }

    /**
     * 显示全部班级信息
     * @return
     */
    @GetMapping("/list")
    public Result listAllClazz() {
        log.info("显示全部班级信息");
        List<Clazz> allClzz = clzzService.showAll();
        return Result.success(allClzz);
    }

}
