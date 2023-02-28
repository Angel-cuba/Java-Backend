package com.jobseek.jobs.interfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import com.jobseek.jobs.models.Job;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Component
public class SearchImplement implements SearchRepository {

  @Autowired
  MongoClient mongoClient;

  @Autowired
  MongoConverter mongoConverter;

  @Override
  public List<Job> searchJobs(String text) {
    final List<Job> jobs = new ArrayList<>();

    MongoDatabase database = mongoClient.getDatabase("job-seek");
        MongoCollection<Document> collection = database.getCollection("jobs");

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                        new Document("text",
                        new Document("query", text)
                        .append("path", Arrays.asList("techs", "desc", "profile")))),
                        new Document("$sort",
                        new Document("exp", 1L)),
                        new Document("$limit", 5L)));
          
        result.forEach(doc -> jobs.add(mongoConverter.read(Job.class, doc)));

    return jobs;
  }
  
}
