package com.jobseek.jobs.interfaces;

import java.util.List;

import com.jobseek.jobs.models.Job;

public interface SearchRepository {
  List<Job> searchJobs(String text);
}
