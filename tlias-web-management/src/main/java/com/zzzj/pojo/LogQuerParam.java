package com.zzzj.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data//添加getter和setter方法
@NoArgsConstructor
@AllArgsConstructor
public class LogQuerParam {
    private Integer page = 1; //页码
    private Integer pageSize = 10; //每页展示记录数
}
