package com.zzzj.controller;

import com.zzzj.pojo.*;
import com.zzzj.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/clazzs")
public class ClazzController {
    @Autowired
    private ClazzService clazzService;
    /**
     * 班级列表查询
     * @return
     */
    @GetMapping
    public Result page(EmpQueryParam  clazzQueryParam)
    {
        log.info("班级列表查询： {}", clazzQueryParam);

        PageResult <Clazz> pageResult = clazzService.page(clazzQueryParam);
        return Result.success(pageResult);


    }
    /**
     * 添加班级
     */
    @PostMapping
    public Result save(@RequestBody Clazz clazz)
    {
        log.info("添加班级，班级信息： {}", clazz);
        clazzService.save(clazz);
        return Result.success();
    }

    /**
     * 根据id查询班级
     */
    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id)
    {
        log.info("查询班级，班级id： {}", id);
        Clazz clazz = clazzService.getInfoclazz(id);
        return Result.success(clazz);
    }

    /**
     * 修改班级信息
     */
    @PutMapping
    public Result updateclazz(@RequestBody Clazz clazz)
    {
        log.info("修改班级信息： {}", clazz);
        clazzService.updateclazz(clazz);
        return Result.success();
    }
    /**
     * 删除班级
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable(name = "id") Integer ides)
    {
        log.info("删除班级，班级id： {}", ides);
        clazzService.deleteById(ides);
        return Result.success();

    }
    /**
     * 查询所有班级
     */
    @GetMapping("/list")
    public Result clazzlist()
    {
        log.info("查询所有班级");
        List<Clazz> clazzlist = clazzService.findAll();
        return Result.success(clazzlist);
    }
}
