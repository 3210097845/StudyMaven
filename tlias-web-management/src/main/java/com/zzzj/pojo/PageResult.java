package com.zzzj.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 分页结果封装类
 */
@Data // Lombok注解，自动生成getter、setter、toString等方法
@AllArgsConstructor
@NoArgsConstructor
public class PageResult<T> {
    private Long total;// 总记录数
    private List<T> rows;// 当前页数据
}
