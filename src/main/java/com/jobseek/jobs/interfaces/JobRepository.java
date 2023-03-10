package com.jobseek.jobs.interfaces;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jobseek.jobs.models.Job;

@Repository
public interface JobRepository extends MongoRepository<Job, ObjectId> {

}
