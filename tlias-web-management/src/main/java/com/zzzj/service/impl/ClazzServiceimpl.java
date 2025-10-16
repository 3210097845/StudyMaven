package com.zzzj.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zzzj.mapper.ClazzMapper;
import com.zzzj.pojo.Clazz;
import com.zzzj.pojo.EmpQueryParam;
import com.zzzj.pojo.PageResult;
import com.zzzj.pojo.Student;
import com.zzzj.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClazzServiceimpl implements ClazzService {

    @Autowired
    private ClazzMapper clazzMapper;
    @Override
    public PageResult<Clazz> page(EmpQueryParam clazzQueryParam)
    {
        //设置分页参数
        PageHelper.startPage(clazzQueryParam.getPage(), clazzQueryParam.getPageSize());
        //执行查询数据
        List<Clazz> clazzlist = clazzMapper.clazzpage(clazzQueryParam);
        Page<Clazz> p = (Page<Clazz>) clazzlist;
        return new PageResult<>(p.getTotal(),p.getResult());
    }

    /**
     * 添加班级
     */
    @Override
    public void save(Clazz clazz)
    {
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.save(clazz);
    }

    /**
     * 根据id查询班级
     * @param id
     */
    @Override
   public  Clazz getInfoclazz (Integer id){

        return clazzMapper.getInfoclazz(id);
    }

    /**
     * 修改班级信息
     */
    @Override
    public void updateclazz(Clazz clazz)
    {
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.updateclazz(clazz);
    }
//    @Override
//    public void deleteById(Integer id)
//    {
//        clazzMapper.deleteById(id);
//    }
}
