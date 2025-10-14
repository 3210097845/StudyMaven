package com.zzzj.service;

import com.zzzj.pojo.JobOption;

import java.util.List;
import java.util.Map;

public interface ReportService {
    /**
     * 统计各个职位的员工人数
     * @return
     */
    JobOption getEmpJobData();

    /**
     * 统计员工性别人数
     * @return
     */

    List<Map<String,Object>> countEmpJobData();
}