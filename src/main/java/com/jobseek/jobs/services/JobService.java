package com.jobseek.jobs.services;

import java.util.List;

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
}
