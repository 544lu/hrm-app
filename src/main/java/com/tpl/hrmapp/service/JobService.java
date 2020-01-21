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

    //根据pid查询Job
    List<Job> selectJobByPid(Integer pid);

    //根据id删除Job
    String deleteJob(Job job);

    //全局搜索
    List<Job> overallByJobName(String jobName);

    //全局搜索
    List<Job> overallByMainWork(String mainWork);

    //岗位信息批量新增
    List<Job> insertJob(List<Job> jobList);

    //岗位信息新增
    Job insertJob(Job job);

    //岗位信息更新（岗位名称更新）
    Job updateJob(Job job);
}
