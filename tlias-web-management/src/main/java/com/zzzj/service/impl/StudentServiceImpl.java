package com.zzzj.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zzzj.mapper.StudentMapper;
import com.zzzj.pojo.PageResult;
import com.zzzj.pojo.Student;
import com.zzzj.pojo.StudentQueryParam;
import com.zzzj.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service

public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;


    /**
     * 分页查询
     * @param studentQueryParam
     * @return
     */
    @Override
    public PageResult<Student> page(StudentQueryParam studentQueryParam) {
        //设置分页参数
        PageHelper.startPage(studentQueryParam.getPage(), studentQueryParam.getPageSize());
        //执行查询数据
        List<Student> studentlist = studentMapper.page(studentQueryParam);
        Page<Student> p = (Page<Student>) studentlist;
        return new PageResult<>(p.getTotal(),p.getResult());
    }
    /**
     * 添加学员
     */
    @Override
    public void save(Student student)
    {
        //添加事件和修改时间
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        //调用mapper
        studentMapper.save(student);
    }
    /**
     * 根据id查询学员
     */
    @Override
    public Student getInfostudent (Integer id){
        return studentMapper.getInfoclazz(id);
    }

    /**
     * 修改学员
     * @param student
     */
    @Override
    public void updatestudent(Student student)
    {
        //更新修改时间
        student.setUpdateTime(LocalDateTime.now());
        //调用mapper
        studentMapper.updatestudent(student);
    }
    /**
     * 批量删除学员
     * @param ids
     */
    @Override
    public void deleteByIds(List<Integer> ids)
    {
        studentMapper.deleteById(ids);
    }
    /**
     * 违纪处理
     */
    @Override
    public void handleDiscipline(Integer id, Short score)
    {
        //修改更新时间
        Student student = studentMapper.getInfoclazz(id);
        student.setUpdateTime(LocalDateTime.now());
        student.setViolationCount((short) (student.getViolationCount() + 1));
        student.setViolationScore((short) (student.getViolationScore() + score));
        studentMapper.updatestudent(student);
    }
}