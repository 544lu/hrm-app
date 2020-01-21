package com.tpl.hrmapp.service.impl;

import com.tpl.hrmapp.domain.Job;
import com.tpl.hrmapp.repository.JobRepository;
import com.tpl.hrmapp.service.JobService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JobRepository jobRepo;

    /**
     * 按levelId查询Job
     *
     * @param id
     * @param levelId
     * @return
     */
    @Override
    public Job selectJobByLevelId(Integer id, Integer levelId) {
        Job job = new Job();
        try {
            job = jobRepo.selectJobByLevelId(id, levelId);
        } catch (Exception e) {
            log.error("查询Job时出错");
        }
        return job;
    }

    /**
     * 根据主键id查询Job
     *
     * @param id
     * @return
     */
    @Override
    public Job selectById(Integer id) {
        Job job = new Job();
        try {
            job = jobRepo.getOne(id);
        } catch (Exception e) {
            log.error("查询Job时出错");
        }
        return job;
    }

    /**
     * 根据pid以及jobName查询Job
     *
     * @param pid
     * @param jobName
     * @return
     */
    @Override
    public Job selectByPidAndJobName(Integer pid, String jobName) {
        Job job = new Job();
        try {
            job = jobRepo.selectJobByPidAndJobName(pid, jobName);
        } catch (Exception e) {
            log.error("查询Job时出错");
            e.printStackTrace();
        }
        return job;
    }

    /**
     * 根据keywords查询Job
     *
     * @param keywords
     * @return
     */
    @Override
    public List<Job> selectJobByKeywords(String keywords) {
        List<Job> jobs = new ArrayList<>();
        try {
            jobs = jobRepo.selectJobByKeywords(keywords);
        } catch (Exception e) {
            log.error("根据keywords查询Job时出错");
            e.printStackTrace();
        }
        return jobs;
    }

    @Override
    public List<Job> selectJobByPid(Integer pid) {
        List<Job> jobs = new ArrayList<>();
        try {
            jobs = jobRepo.selectJobByPid(pid);
        } catch (Exception e) {
            log.error("根据pid查询Job时出错");
            e.printStackTrace();
        }
        return jobs;
    }

    @Override
    public String deleteJob(Job job) {
        try {
            jobRepo.delete(job);
        } catch (Exception e) {
            log.error("删除Job时出错");
            e.printStackTrace();
            return "false";
        }
        return "success";
    }

    @Override
    public List<Job> overallByJobName(String jobName) {
        List<Job> jobs = new ArrayList<>();
        try {
            jobs = jobRepo.overallByJobName(jobName);
        } catch (Exception e) {
            log.error("根据keywords查询Job时出错");
            e.printStackTrace();
        }
        return jobs;
    }

    @Override
    public List<Job> overallByMainWork(String mainWork) {
        List<Job> jobs = new ArrayList<>();
        try {
            jobs = jobRepo.overallByMainWork(mainWork);
        } catch (Exception e) {
            log.error("根据keywords查询Job时出错");
            e.printStackTrace();
        }
        return jobs;
    }

    @Override
    public List<Job> insertJob(List<Job> jobList) {
        List<Job> jobs = new ArrayList<>();
        try {
            jobs = jobRepo.saveAll(jobList);
        } catch (Exception e) {
            log.error("添加新的岗位信息时出错");
            e.printStackTrace();
        }
        return jobs;
    }

    @Override
    public Job insertJob(Job job) {
        Job j = null;
        try {
            j = jobRepo.save(job);
        } catch (Exception e) {
            log.error("添加新的岗位信息时出错");
            e.printStackTrace();
        }
        return j;
    }

    @Override
    public Job updateJob(Job job) {
        Job jobUpdate = new Job();
        try {
            jobUpdate = jobRepo.save(job);
        } catch (Exception e) {
            log.error("更新岗位信息时出错");
            e.printStackTrace();
        }
        return jobUpdate;
    }
}
