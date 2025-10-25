package com.zzzj.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zzzj.mapper.EmpExprMapper;
import com.zzzj.mapper.EmpMapper;
import com.zzzj.pojo.*;
import com.zzzj.service.EmpService;
import com.zzzj.utils.JwtUtils;
import org.apache.ibatis.annotations.Options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 员工管理
 */
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private EmpExprMapper empExprMapper;

    @Override
    public PageResult<Emp> page(EmpQueryParam empqueryparam) {
        /**
         *
         * 原始方法
         */
//        //获取总记录数
//        Long count = empMapper.count();
//        //获取每一页的数据列表
//        Integer start = (page - 1) * pageSize;//计算起始索引
//        List<Emp> emplist = empMapper.list(start, pageSize);
//        //封装结果
//       return  new PageResult<Emp>(count,emplist);

        /**
         * 引入PageHelper分页插件
         *
         */
        //设置分页参数
        PageHelper.startPage(empqueryparam.getPage(), empqueryparam.getPageSize());
        //执行查询数据
        List<Emp> emplist = empMapper.list(empqueryparam);
        Page<Emp> p = (Page<Emp>) emplist;
        //封装结果
        return new PageResult<>(p.getTotal(),p.getResult());


    }
    /**
     * 添加员工
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void save(Emp emp) {
        //设置时间为当前更新时间
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);

        //添加员工工作经历
        List<EmpExpr> empexprs = emp.getExprList();
        if(!CollectionUtils.isEmpty(empexprs))
        {
            empexprs.forEach(empExpr-> {
                empExpr.setEmpId(emp.getId());
            });
            empExprMapper.insertBatch(empexprs);
        }

    }

    /**
     * 批量删除员工
     * @param ids
     */
    @Transactional
    @Override
    public void deleteByIds(List<Integer> ids) {
        empMapper.deleteByIds(ids);
        empExprMapper.deleteByEmpIds(ids);

    }
    /**
     * 根据id查询员工
     */
//    @Override
//    public Emp getInfo(Integer id) {
//        return empMapper.getById(id);
//    }
    @Override
    public Emp getInfo(Integer id) {
        return empMapper.getById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(Emp emp) {
        //根据id更新员工基本信息
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.updateById(emp);
        //根据员工id删除员工工作经历(先删后改）
        empExprMapper.deleteByEmpIds(Arrays.asList(emp.getId()));
        Integer empId = emp.getId();
        List<EmpExpr> exprList = emp.getExprList();
        if(!CollectionUtils.isEmpty(exprList)){
            exprList.forEach(empExpr -> empExpr.setEmpId(empId));
            empExprMapper.insertBatch(exprList);
        }

    }
    @Override
    public List<Emp> listName() {
        return empMapper.listName();
    }

    /**
     * 登录功能
     */
    @Override
    public LoginInfo login(Emp emp) {
        Emp log=empMapper.getByUsernameAndPassword(emp);
        if(log==null)
            return null;
        else
        {
            //生成JWT令牌
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", log.getId());
            claims.put("username", log.getUsername());
            String jwt = JwtUtils.generateJwt(claims);//生成JWT令牌
            LoginInfo loginInfo = new LoginInfo(log.getId(), log.getUsername(), log.getName(), jwt );
            return loginInfo;
        }

    }
}