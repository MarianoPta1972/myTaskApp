package com.tasklistapp;

import java.util.Random;

public class Task {
    private String nameTask;
    Status status;
    int stat;

    Random random = new Random();

    public Task(String nameTask, Status status) {
        this.nameTask = nameTask;
        this.status = status;
      // stat = random.nextInt(3);
      // if (stat==0) { this.status=Status.TODO;}
      //  else if (stat==1) {this.status=Status.COMPLETED;} else {
       //     this.status =Status.INPROGRESS;
       // }

    }
//
//    public Task() { אין צורך
//
//    }

    public String getNameTask() {
        return nameTask;
    }

    public void setNameTask(String nameTask) {
        this.nameTask = nameTask;
    }
}
