package com.zzzj.mapper;

import com.zzzj.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Mapper 注解的作用是将该接口标记为 MyBatis 的 Mapper 接口。
 * 这样 MyBatis 在启动时会自动为该接口生成代理实现类，
 * 并将其注册到 Spring 容器中，使得可以在 Service 层通过@Autowired 注入使用。
 */
@Mapper
public interface DeptMapper {
//方式一：手动结果映射
//    @Results({
//           @Result(column = "create_time", property = "createTime"),
//            @Result(column = "update_time", property = "updateTime")
//    })
//    方式二：起别名
//@Select("select id, name, create_time createTime, update_time updateTime from dept")
    @Select("select id,name,dept.create_time,dept.update_time from dept order by  update_time desc ;")
   public List<Dept> findAll();

    //根据i d删除部门
    @Delete("delete from dept where id=#{id}")
    public void delete(Integer id);

    //添加部门
    @Insert("insert into dept(name,create_time,update_time) values(#{name},#{createTime},#{updateTime})")
    public void add(Dept dept);

    //根据id查询部门
    @Select("select id,name,dept.create_time,dept.update_time from dept where id=#{id}")
    Dept getById(Integer id);

    //修改部门
     @Update("update dept set name=#{name},update_time=#{updateTime} where id=#{id}")
   public void update(Dept dept);

     //查询部门人数
    @Select("select count(*) from emp e where e.dept_id=#{id}")
    int countEmp(Integer id);
}
