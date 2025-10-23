package com.zzzj.controller;

import com.zzzj.pojo.ClazzOption;
import com.zzzj.pojo.JobOption;
import com.zzzj.pojo.Result;
import com.zzzj.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RequestMapping("/report")
@RestController
public class ReportController {

    @Autowired
    private ReportService reportService;

    /**
     * 统计各个职位的员工人数
     */
    @GetMapping("/empJobData")
    public Result getEmpJobData(){
        log.info("统计各个职位的员工人数");
        JobOption jobOption = reportService.getEmpJobData();
        return Result.success(jobOption);
    }
    /**
     * 统计员工性别对应的人数
     */
    @GetMapping("/empGenderData")
    public Result getEmpGenderData(){
        log.info("统计男女性别对应的人数");
        List<Map<String,Object>> mapList= reportService.countEmpJobData();
        return Result.success(mapList);
    }
    /**
     * 统计班级人数
     */
    @GetMapping("/studentCountData")
    public Result getStudentCountData(){
        log.info("统计班级人数");
        ClazzOption mapList= reportService.countStudentCountData();
        return Result.success(mapList);
    }


    /**
     * 统计学员学历
     */
    @GetMapping("/studentDegreeData")
    public Result getStudentDegreeData(){
        log.info("统计学员学历");
        List<Map<String,Object>> mapListt= reportService.countStudentDegreeData();
        return Result.success(mapListt);
    }
}