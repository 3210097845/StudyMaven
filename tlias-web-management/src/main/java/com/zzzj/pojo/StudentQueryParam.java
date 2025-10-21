package com.zzzj.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentQueryParam {
    /**
     * 分页查询的传入参数封装
     */
    private Integer page = 1; //页码
    private Integer pageSize = 10; //每页展示记录数
    private String name;
    private Integer clazzId;
    private Integer degree;//最高学历, 1: 初中, 2: 高中 , 3: 大专 , 4: 本科 , 5: 硕士 , 6: 博士
}
