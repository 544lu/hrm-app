package com.tpl.hrmapp.repository;

import com.tpl.hrmapp.domain.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Integer> {
    //根据levelId查询Job
    @Modifying
    @Query("select j from Job j where id=?1 and levelId =?2")
    Job selectJobByLevelId(Integer id, Integer levelId);

    //根据jobName查询Job
    @Query("select j from Job j where pid=?1 and jobName=?2")
    Job selectJobByPidAndJobName(Integer pid, String JobName);

    //根据keywords查询Job
    @Query("select j from Job j where keywords like %?1%")
    List<Job> selectJobByKeywords(String keywords);

    //全局搜索
    @Query("select j from Job j where jobName like %?1% and pid is null")
    List<Job> overallByJobName(String jobName);

    //全局搜索
    @Query("select j from Job j where mainWork1 like %?1% and pid is not null")
    List<Job> overallByMainWork(String mainWork);
}
