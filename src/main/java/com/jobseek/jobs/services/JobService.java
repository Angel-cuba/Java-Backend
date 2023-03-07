package com.jobseek.jobs.services;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobseek.jobs.interfaces.JobRepository;
import com.jobseek.jobs.models.Job;

@Service
public class JobService {
  @Autowired
  private JobRepository jobRepository;

  public List<Job> getJobs() {
    return jobRepository.findAll();
  }

  public Optional<Job> getJobById(ObjectId id) {
    return jobRepository.findById(id);
  }

  public Job addJob(Job job) {
      Optional<Job> presentJob = jobRepository.findById(ObjectId.get());

    if(presentJob.isPresent()){
    jobRepository.save(job);
    }
   jobRepository.save(job);
   return job;
  }

  public void deleteJob(ObjectId id) {
    jobRepository.deleteById(id);
  }

}
