package com.zzzj.controller;


import com.zzzj.pojo.Dept;
import com.zzzj.pojo.Result;
import com.zzzj.service.DeptService;
import com.zzzj.service.impl.DeptServiceimpl;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 日志方式二：使用 slf4j注解
 */
@Slf4j
@RequestMapping("/depts")
/**
 * @RestController 是 Spring 提供的注解，用于标识该类是一个 RESTful 风格的控制器。
 * 它结合了 @Controller 和 @ResponseBody 的作用：
 * - @Controller：将该类标记为 Spring MVC 的控制器组件。
 * - @ResponseBody：表示方法返回值直接写入 HTTP 响应体（通常用于返回 JSON 数据）。
 * 因此，使用 @RestController 后，方法返回的对象会自动转换为 JSON 格式返回给客户端。
 */
@RestController
public class DeptController {

    /**
     * 日志方式一：
     */
    //private static final Logger log = LoggerFactory.getLogger(DeptController.class);
    @Autowired
    private DeptService deptService;
    @Autowired
    private DeptServiceimpl deptServiceimpl;

    /*
    * 查询所有部门
    * */
    @GetMapping
    public Result list(){
        log.info("查询所有部门");
        List<Dept> deptlist = deptService.findAll();
        return Result.success(deptlist);
    }

    /**
     * 根据ID删除部门 - 简单参数接收: 方式一 (HttpServletRequest)
     */
//    @DeleteMapping("/depts")
//    public Result delete(HttpServletRequest request){
//        String idStr = request.getParameter("id");
//        int id = Integer.parseInt(idStr);
//
//        System.out.println("根据ID删除部门: " + id);
//        return Result.success();
//    }

    /*
    * - 方案二：通过Spring提供的 @RequestParam 注解，将请求参数绑定给方法形参
    * @RequestParam 注解的value属性，需要与前端传递的参数名保持一致
    * @RequestParam注解required属性默认为true，代表该参数必须传递，如果不传递将报错。 如果参数可选，可以将属性设置为false。
     * */
//    @DeleteMapping("/depts")
//    public Result delete(@RequestParam(value = "id" , required = false ) Integer deptId){
//        System.out.println("根据ID删除部门: " + deptId);
//        return Result.success();
//    }

//    @DeleteMapping("/depts")
//public Result delete(@RequestParam("id") Integer deptId){
//    System.out.println("根据ID删除部门: " + deptId);
//    return Result.success();
//}

    /*
    * - 方案三(推荐)：如果请求参数名与形参变量名相同，直接定义方法形参即可接收。（省略@RequestParam）
    * */
    @DeleteMapping
    public Result delete(Integer id){
//        System.out.println("根据ID删除部门: " + id);
        log.info("根据ID删除部门: {}" , id );
        deptService.delete(id);
        return Result.success();
    }

    /**
     * 新增部门
     * @RequestBody: 表示将请求体中的JSON数据，映射为Java对象
     * java对象属性名必须与JSON数据中的属性名一致。
     */
    @PostMapping
    public Result save (@RequestBody Dept dept)
    {
//        System.out.println("新增部门，dept=" + dept);
        log.info("新增部门，dept= {}" , dept);
        deptService.add(dept);
        return Result.success();
    }

    /*
    * 查询回显
    * 路径参数：通过请求URL直接传递参数，使用{…}来标识该路径参数，需要使用 @PathVariable获取路径参数。
    * 根据id查询部门 - GET http://localhost:8080/depts/1
    * */
    /**
     * 方法一：
     * /或者是
     * @GettMapping("/depts/{id}")
     * public Result getById(@PathVariable("id") Integer byid){
     *     System.out.println("根据ID查询, id=" + id);
     *     Dept dept = deptService.getById(id);
     *     return Result.success(dept);
     * }
     */
    //方法二:
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id)
    {
//        System.out.println("根据ID查询，id" + id );
        log.info("根据ID查询，id {}" , id );
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }

    /*
    * 根据id修改部门
    * */
    @PutMapping
    public Result update(@RequestBody Dept dept)
    {
//        System.out.println("修改部门，dept=" + dept);
        log.info("修改部门，dept= {}" , dept);
        deptService.update(dept);
        return Result.success();
    }
}
