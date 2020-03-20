package com.tasklistapp;

import java.util.ArrayList;



public class dataManager { // לפעם הבאה לשים מחלקה עם אות גדולה

    static ArrayList<Task> taskList = new ArrayList<>();


    public static ArrayList<Task> getTaskList() {
        return taskList;
    }

    public static void setTaskList(ArrayList<Task> taskList) {
        dataManager.taskList = taskList;
    }
}

