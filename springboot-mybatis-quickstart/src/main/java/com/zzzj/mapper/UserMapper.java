package com.zzzj.mapper;

import com.zzzj.pojo.User;
import com.zzzj.pojo.User2;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper  // 表示是mybatis中的Mapper接口程序运行时，框架会自动生成接口的实现类对象(代理对象)，并会自动将该实现类对象交给IOC容器管理
public interface UserMapper {
    //查询所有用户
    //@Select("select * from user ")//查询到的内容会自动返回到方法的返回值中
    public List<User> findAll();//每一条数据会自动封装到user对象中，然后user对象会封装到list集合中，最终返回给调用者
    //调用该方法时会自动调用SQL语句，再将结果返回给调用者

    //删除操作
    @Delete("delete from user where id=#{id}")
    public Integer deleteById(Integer id);

    //添加操作
    @Insert("insert into user(username,password,name,age) values(#{username},#{password},#{name},#{age})")
    public Integer insert(User user);
    @Insert("insert into user(username,name,age) values(#{username},#{name},#{age})")
    public Integer insert2(User2 user2);

    //更新操作
    @Update("update user set username=#{username},password=#{password},name=#{name},age=#{age} where id=#{id}")
    public Integer update(User user);
    @Update("update user set age=#{age} where id=#{id}")
    public Integer update2(User user);

    @Select("select * from user where password=#{s2} and username=#{s1}")
    public User findById(@Param("s2") String s1 ,  @Param("s1")String s2);

}
