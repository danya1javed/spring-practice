package com.springpractice.project01.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;

public class Todo {
  private int id;
  private String user;

  @Size(min = 3, message = "Todo description too short!")
  private String desc;

  private Date targetDate;
  private boolean isDone;

  public Todo(){
    super();
  }

  public Todo(int id, String user, String desc, Date targetDate, boolean isDone) {
    super();
    this.id = id;
    this.user = user;
    this.desc = desc;
    this.targetDate = targetDate;
    this.isDone = isDone;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public Date getTargetDate() {
    return targetDate;
  }

  public void setTargetDate(Date targetDate) {
    this.targetDate = targetDate;
  }

  public boolean isDone() {
    return isDone;
  }

  public void setDone(boolean done) {
    isDone = done;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Todo todoModel = (Todo) o;
    return getId() == todoModel.getId() && isDone() == todoModel.isDone() && getUser().equals(todoModel.getUser()) && getDesc().equals(todoModel.getDesc()) && getTargetDate().equals(todoModel.getTargetDate());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getUser(), getDesc(), getTargetDate(), isDone());
  }

  @Override
  public String toString() {
    return "TodoModel{" +
            "id=" + id +
            ", user='" + user + '\'' +
            ", desc='" + desc + '\'' +
            ", targetDate=" + targetDate +
            ", isDone=" + isDone +
            '}';
  }
}
