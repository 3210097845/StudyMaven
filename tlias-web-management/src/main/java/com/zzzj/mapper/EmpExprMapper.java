package com.zzzj.mapper;

import com.zzzj.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 员工工作经历
 */
@Mapper
public interface EmpExprMapper {
    void insertBatch(List<EmpExpr> empexprs);
}
