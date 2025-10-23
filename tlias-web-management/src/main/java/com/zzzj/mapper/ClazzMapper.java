package com.zzzj.mapper;

import com.zzzj.pojo.Clazz;
import com.zzzj.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ClazzMapper {

    public List<Clazz> clazzpage(EmpQueryParam clazzQueryParam);

//    void deleteById(Integer id);

    //添加班级
    void save(Clazz clazz);

    //根据id查询班级
    Clazz getInfoclazz(Integer id);

    //修改班级信息
    void updateclazz(Clazz clazz);

    //删除班级
    void deleteById(Integer id);

    //查询所有班级
    List<Clazz> findAll();
    @MapKey("name")
    List<Map<String, Object>> countStudentCountData();
}
