package com.jobseek.jobs.controllers;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobseek.jobs.interfaces.SearchRepository;
import com.jobseek.jobs.models.Job;
import com.jobseek.jobs.services.JobService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/jobs")
public class PostController {

  @Autowired
  private JobService jobService;

  @Autowired
  private SearchRepository searchRepository;

  @GetMapping
  public ResponseEntity<List<Job>> getJobs() {
    return new ResponseEntity<List<Job>>(jobService.getJobs(), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Optional<Job>> getJobById(@PathVariable ObjectId id) {
    return new ResponseEntity<Optional<Job>>(jobService.getJobById(id), HttpStatus.OK);
  }

  @GetMapping("/byText/{text}")
  public ResponseEntity<List<Job>> getJobsByText(@PathVariable String text) {
    return new ResponseEntity<List<Job>>(searchRepository.searchJobs(text), HttpStatus.OK);
  }

  @PostMapping("/add")
  public ResponseEntity<Job> addJob(@RequestBody Job job) {
    return new ResponseEntity<Job>(jobService.addJob(job), HttpStatus.OK);
  }

}
