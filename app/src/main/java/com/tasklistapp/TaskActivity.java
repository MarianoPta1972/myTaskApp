package com.tasklistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class TaskActivity extends AppCompatActivity {

    TextView taskName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tasklsinglelayout);

        taskName =findViewById(R.id.singleTask);


    }
}
