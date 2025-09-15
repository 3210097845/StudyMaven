package com.zzzj.mapper;

import com.zzzj.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 员工信息
 */
@Mapper
public interface EmpMapper {
    @Select("select count(*) from  emp e left join  dept d on e.dept_id = d.id")
    public Long count();//查询记录总数
    @Select("select e.*,d.name deptName from emp e left join dept d on e.dept_id=d.id limit #{start} , #{pageSize} ")
    public List<Emp> list(Integer start, Integer pageSize);

}