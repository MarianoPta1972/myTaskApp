package com.tasklistapp;

public class Task {
    private String nameTask;

    public Task(String nameTask) {
        this.nameTask = nameTask;
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
