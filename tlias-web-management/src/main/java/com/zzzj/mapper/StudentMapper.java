package com.zzzj.mapper;

import com.zzzj.pojo.Student;
import com.zzzj.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {
    int getStudentCountByClazzId(Integer id);

    List<Student> page(StudentQueryParam studentQueryParam);

    void save(Student student);

    Student getInfoclazz(Integer id);

    void updatestudent(Student student);

    void deleteById(List<Integer> ids);

    @MapKey("name")
    List<Map<String, Object>> countStudentCountData();
    @MapKey("name")
    List<Map<String, Object>> countStudentDegreeData();

}
