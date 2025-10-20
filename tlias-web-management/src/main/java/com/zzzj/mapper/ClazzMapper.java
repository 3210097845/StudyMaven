package com.zzzj.mapper;

import com.zzzj.pojo.Clazz;
import com.zzzj.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClazzMapper {

    public List<Clazz> clazzpage(EmpQueryParam clazzQueryParam);

//    void deleteById(Integer id);

    //添加班级
    void save(Clazz clazz);

    Clazz getInfoclazz(Integer id);

    void updateclazz(Clazz clazz);

    void deleteById(Integer id);
}
