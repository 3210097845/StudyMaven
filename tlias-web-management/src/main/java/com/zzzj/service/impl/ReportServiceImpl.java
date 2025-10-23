package com.zzzj.service.impl;

import com.zzzj.mapper.ClazzMapper;
import com.zzzj.mapper.EmpMapper;
import com.zzzj.mapper.StudentMapper;
import com.zzzj.pojo.ClazzOption;
import com.zzzj.pojo.JobOption;
import com.zzzj.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class  ReportServiceImpl implements ReportService {

    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private ClazzMapper clazzMapper;
    @Autowired
    private StudentMapper studentMapper;
        
    @Override
    public JobOption getEmpJobData() {
        List<Map<String,Object>> list = empMapper.countEmpJobData();
        List<Object> jobList = list.stream().map(dataMap -> dataMap.get("pos")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("total")).toList();
        return new JobOption(jobList, dataList);
    }

    @Override
    public List<Map<String,Object>> countEmpJobData() {
        return empMapper.countEmpGenderData();
    }

    /**
     * 统计班级人数
     * @return
     */
    @Override
    public ClazzOption countStudentCountData()
    {
        List<Map<String,Object>> list = studentMapper.countStudentCountData();
        List<Object> clazzList = list.stream().map(dataMap -> dataMap.get("name")).toList();//获取班级名称
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("total")).toList();//获取班级人数
        return new ClazzOption (clazzList, dataList);
    }
    /**
     * 统计学员学历
     * @return
     */
    @Override
    public List<Map<String,Object>> countStudentDegreeData()
    {
        return studentMapper.countStudentDegreeData();
    }


}