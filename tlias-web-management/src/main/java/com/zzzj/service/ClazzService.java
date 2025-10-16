package com.zzzj.service;

import com.zzzj.pojo.Clazz;
import com.zzzj.pojo.EmpQueryParam;
import com.zzzj.pojo.PageResult;
import com.zzzj.pojo.Student;

import java.util.List;

public interface ClazzService {
    /**
     * 班级列表查询
     * @return
     */
    PageResult<Clazz> page(EmpQueryParam clazzQueryParam);

//    void deleteById(Integer ides);

    void save(Clazz clazz);

    Clazz getInfoclazz(Integer id);

    void updateclazz(Clazz clazz);
}
