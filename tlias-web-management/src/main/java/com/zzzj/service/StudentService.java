package com.zzzj.service;

import com.zzzj.pojo.PageResult;
import com.zzzj.pojo.Student;
import com.zzzj.pojo.StudentQueryParam;

import java.util.List;

public interface StudentService {
    /**
     * 学员列表查询（分页查询）
     * @param studentQueryParam
     * @return
     */
    PageResult<Student> page(StudentQueryParam studentQueryParam);

    /**
     * 添加学员
     * @param student
     */
    void save(Student student);

    /**
     * 根据id查询学员
     * @param id
     * @return
     */
    Student getInfostudent(Integer id);

    /**
     * 修改学员信息
     * @param student
     */
    void updatestudent(Student student);

    /**
     * 批量删除学员
     * @param ids
     */
    void deleteByIds(List<Integer> ids);

    /**
     * 违纪处理
     * @param id
     * @param score
     */
    void handleDiscipline(Integer id, Short score);
}
