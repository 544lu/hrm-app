package com.tpl.hrmapp.service;

import com.tpl.hrmapp.domain.Job;

import java.util.List;

public interface JobService {
    //根据levelId及id查询Job
    Job selectJobByLevelId(Integer id, Integer levelId);

    //根据id查询Job
    Job selectById(Integer id);

    //根据jobName查询Job
    Job selectByPidAndJobName(Integer pid, String jobName);

    //根据keywords查询job
    List<Job> selectJobByKeywords(String keywords);

    //全局搜索
    List<Job> overallByJobName(String jobName);

    //全局搜索
    List<Job> overallByMainWork(String mainWork);

    //岗位信息批量新增
    List<Job> insertJob(List<Job> jobList);

}
