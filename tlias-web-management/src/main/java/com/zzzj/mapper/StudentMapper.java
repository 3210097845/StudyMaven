package com.zzzj.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper {
    int getStudentCountByClazzId(Integer id);
}
