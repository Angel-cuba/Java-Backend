package com.jobseek.jobs.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "jobs")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Job {
  @Id
  private String _id;
  private String profile;
  private String desc;
  private int exp;
  private List<String> techs;

public String getId() {
  return _id;
}
public void setId(String id) {
  this._id = id;
}
public String getProfile() {
  return profile;
}
public void setProfile(String profile) {
  this.profile = profile;
}
public String getDesc() {
  return desc;
}
public void setDesc(String desc) {
  this.desc = desc;
}
public int getExp() {
  return exp;
}
public void setExp(int exp) {
  this.exp = exp;
}
public List<String> getTechs() {
  return techs;
}
public void setTechs(List<String> techs) {
  this.techs = techs;
}

}
