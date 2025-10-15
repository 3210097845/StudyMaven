package com.zzzj.mapper;

import com.zzzj.pojo.Clazz;
import com.zzzj.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClazzMapper {

    public List<Clazz> clazzpage(EmpQueryParam clazzQueryParam);
}
