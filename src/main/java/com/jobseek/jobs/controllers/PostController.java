package com.jobseek.jobs.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobseek.jobs.models.Job;
import com.jobseek.jobs.services.JobService;

@RestController
@RequestMapping("/jobs")
public class PostController {

  @Autowired
  private JobService jobService;

  @GetMapping
  public ResponseEntity<List<Job>> getJobs() {
    return new ResponseEntity<List<Job>>(jobService.getJobs(), HttpStatus.OK);
  }
}
