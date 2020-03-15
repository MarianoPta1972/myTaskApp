package com.tasklistapp;

import java.util.ArrayList;



public class dataManager {

    static ArrayList<Task> taskList = new ArrayList<>();


    public static ArrayList<Task> getTaskList() {
        return taskList;
    }

    public static void setTaskList (ArrayList<Task> taskList) {
        dataManager.taskList = taskList;
    }


    public void addTask (Task task){
        taskList.add(task);
    }

}
