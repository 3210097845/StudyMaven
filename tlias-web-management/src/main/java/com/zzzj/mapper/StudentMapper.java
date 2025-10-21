package com.zzzj.mapper;

import com.zzzj.pojo.Student;
import com.zzzj.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {
    int getStudentCountByClazzId(Integer id);

    List<Student> page(StudentQueryParam studentQueryParam);

    void save(Student student);

    Student getInfoclazz(Integer id);

    void updatestudent(Student student);

    void deleteById(List<Integer> ids);
}
