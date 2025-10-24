package com.zzzj.mapper;

import com.zzzj.pojo.Emp;
import com.zzzj.pojo.EmpQueryParam;
import com.zzzj.pojo.LoginInfo;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * 员工信息
 */
@Mapper
public interface EmpMapper {
    /**
     * 分页查询原始方法
     */
//    @Select("select count(*) from  emp e left join  dept d on e.dept_id = d.id")
//    public Long count();//查询记录总数
//    @Select("select e.*,d.name deptName from emp e left join dept d on e.dept_id=d.id limit #{start} , #{pageSize} ")
//    public List<Emp> list(Integer start, Integer pageSize);

    /**
     * 分页查询：引入PageHelper插件
     * 注意事项：
     * 1.- PageHelper只会对紧跟在其后的第一条SQL语句进行分页处理。
     * 2.- PageHelper实现分页查询时，SQL语句的结尾一定一定一定不要加分号(;).。
     */
//    @Select("select e.*,d.name deptName from emp e left join dept d on e.dept_id=d.id order by e.update_time desc ")
//    public List<Emp> list();

    /**
     * 分页条件查询
     */

    public List<Emp> list(EmpQueryParam empqueryparam);

    /**
     * 保存员工基本信息
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into emp(username,password,name,gender,phone,job,salary,image,entry_date,dept_id,create_time,update_time)" +
            " values(#{username},#{password},#{name},#{gender},#{phone},#{job},#{salary},#{image},#{entryDate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);

    /**
     * 批量删除员工
     * @param ids
     */

    void deleteByIds(List< Integer> ids);

    /**
     * 根据id查询员工信息
     */
    //    Emp getById(Integer id);
    /**
     * 根据ID查询员工详细信息
     */
    Emp getById(Integer id);

    /**
     * 更新员工基本信息
     */
    void updateById(Emp emp);

    /**
     * 统计各个职位的员工人数
     */
    @MapKey("pos")
    List<Map<String, Object>> countEmpJobData();

    /**
     * 统计员工性别人数
     * @return
     */
    @MapKey("gender")
    List<Map<String,Object>> countEmpGenderData();

    List<Emp> listName();

    /**
     * 根据用户名和密码查询员工
     */
    Emp getByUsernameAndPassword(Emp emp);
}
