package com.zzzj;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class EmpService {

    /**
     * 判断给定一个身份证号, 是否是北京地区
     * @param idcard 身份证号
     * @return true: 表示是北京的; false : 表示不是北京的
     */
    public boolean isBeijing(String idcard){
        return idcard.startsWith("11");
    }

    /**
     * 给定一个身份证号, 计算出该用户的年龄
     * @param idcard 身份证号
     */
    public Integer getAge(String idcard)  {
        if(idcard==null ||idcard.length()!=18)
        {
            throw new IllegalArgumentException("身份证号不合法");

        }
        String birthday = idcard.substring(6, 14);
        LocalDate parse = LocalDate.parse(birthday, DateTimeFormatter.ofPattern("yyyyMMdd"));
        return Period.between(parse, LocalDate.now()).getYears();
    }

    /**
     * 给定一个身份证号, 计算出该用户的性别
     * @param idcard 身份证号
     */
    public String getGender(String idcard) {
        if(idcard==null ||idcard.length()!=18)
        {
            throw new IllegalArgumentException("身份证号不合法");

        }
        return Integer.parseInt(idcard.substring(16,17)) % 2 == 1 ? "男" : "女";
    }

    /**
     * 给定一个身份证号, 计算出生年份
     * @param idcard 身份证号
     */
    public String getYear(String idcard){
        return idcard.substring(6,10);
    }

    /**
     * 给定一个身份证号, 计算出生月份
     * @param idcard 身份证号
     */
    public String getMonth(String idcard){
        return idcard.substring(10,12);
    }

}