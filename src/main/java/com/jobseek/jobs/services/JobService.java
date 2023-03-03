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
    return jobRepository.insert(job);
  }


}
