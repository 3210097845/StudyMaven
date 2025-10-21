package com.zzzj.controller;

import com.zzzj.pojo.PageResult;
import com.zzzj.pojo.Result;
import com.zzzj.pojo.Student;
import com.zzzj.pojo.StudentQueryParam;
import com.zzzj.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/students")
@Slf4j

public class StudentController {
    @Autowired
    private StudentService studentService;
    /**
     * 学员列表查询（分页查询）
     */
    @GetMapping
    public Result page(StudentQueryParam studentQueryParam) {
        log.info("学员列表查询：{}", studentQueryParam);
        PageResult<Student> pageResult = studentService.page(studentQueryParam);
        return Result.success(pageResult);
    }
    /**
     * 添加学员
     */
    @PostMapping
    public Result save(@RequestBody  Student student) {
        log.info("添加学员：{}", student);
        studentService.save(student);
        return Result.success();
    }
    /**
     * 根据id查询学员
     */
    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id)
    {
        log.info("查询学员，学员id：{}", id);
        Student student = studentService.getInfostudent(id);
        return Result.success(student);
    }
    /**
     * 修改学生信息
     */
    @PutMapping
    public Result update(@RequestBody Student student)
    {
        log.info("修改学生信息：{}", student);
        studentService.updatestudent(student);
        return Result.success();
    }
    
    /**
     * 批量删除学员 - 通过路径变量
     */
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids)
    {
        log.info("删除学员，学员id：{}", ids);
        studentService.deleteByIds(ids);
        return Result.success();
    }
    
    /**
     * 批量删除学员 - 通过查询参数(兼容旧版前端)
     */
    @DeleteMapping
    public Result deleteByIds(@RequestParam List<Integer> ids)
    {
        log.info("删除学员，学员id：{}", ids);
        studentService.deleteByIds(ids);
        return Result.success();
    }
    /**
     * 违纪处理
     */
}