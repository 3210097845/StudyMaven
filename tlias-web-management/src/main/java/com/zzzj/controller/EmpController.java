package com.zzzj.controller;

import com.zzzj.anno.LogOperation;
import com.zzzj.pojo.Emp;
import com.zzzj.pojo.EmpQueryParam;
import com.zzzj.pojo.PageResult;
import com.zzzj.pojo.Result;
import com.zzzj.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理
 */
@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {

    @Autowired
    private EmpService empService;
    //传参方式一：

//    @GetMapping
//    public Result  page(@RequestParam(defaultValue = "1") Integer page,
//                        @RequestParam(defaultValue = "10") Integer pageSize,
//                        String name , Integer gender,
//                        @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
//                        @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end)//@DateTimeFormat(pattern = "yyyy-MM-dd")日期时间类型参数接收时,需要通过这个注解指定前端传递的日期格式
//    {
//        log.info("查询请求参数： {}, {}, {}, {}, {}, {}", page, pageSize, name, gender, begin, end);
//        PageResult<Emp> pageResult = empService.page(page, pageSize, name, gender, begin, end);
//        return Result.success(pageResult);
//

    //
@GetMapping
public Result  page(EmpQueryParam empqueryparam)//@DateTimeFormat(pattern = "yyyy-MM-dd")日期时间类型参数接收时,需要通过这个注解指定前端传递的日期格式
{
    log.info("查询请求参数： {}", empqueryparam);
    PageResult<Emp> pageResult = empService.page(empqueryparam);
    return Result.success(pageResult);

}

 /**
 * 显式处理 /emps/list 请求
 */
@GetMapping("/list")
public Result pageList(EmpQueryParam empqueryparam) {
    log.info("查询请求参数： {}", empqueryparam);
    List<Emp> emplist = empService.listName();
    return Result.success(emplist);
}

/**
 * 添加员工
 */
@LogOperation
@PostMapping
    public Result save(@RequestBody Emp emp)
{
    log.info("新增员工，员工信息： {}", emp);
    empService.save(emp);
    return Result.success();
}

/**
 * 删除员工
 */
//方式一：
//@DeleteMapping()
//    public Result delete(Integer[] ids)
//{
//    log.info("删除员工，员工id： {}",Arraays.asList(ids));
//    empService.delete(ids);
    //return Result.success();

//方式二：
    @LogOperation
    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids)
    {
        log.info("删除员工，员工id： {}", ids);
        empService.deleteByIds(ids);
        return Result.success();

    }
///**
// * 根据id查询员工数据
// */
//@GetMapping("/{id}")
//    public Result get(@PathVariable Integer id)
//{
//    log.info("查询员工，员工id： {}", id);
//    Emp emp = empService.getInfo(id);
//    return Result.success(emp);
//}
    /**
     * 查询回显
     */
    @GetMapping("/{id}/info")
    public Result getInfo(@PathVariable Integer id){
        log.info("根据id查询员工的详细信息");
        Emp emp  = empService.getInfo(id);
        return Result.success(emp);
    }
    /**
     * 更新员工信息
     */
    @LogOperation
    @PutMapping
    public Result update(@RequestBody Emp emp)
{
    log.info("更新员工信息： {}", emp);
    empService.update(emp);
    return Result.success();
}
}