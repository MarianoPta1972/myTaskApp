package com.tasklistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;

import org.json.JSONArray;

public class TaskActivity extends AppCompatActivity {

    EditText taskName;
    FloatingActionButton btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tasklsinglelayout);

        taskName =findViewById(R.id.taskName);
        btn = findViewById(R.id.floatingActionButton);

    btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            JSONArray array = new JSONArray();
            for (int i = 0; i < dataManager.taskList.size(); i++) {
                Task task = dataManager.getTaskList().get(i);
                String taskObject = new Gson().toJson(task);
                array.put(taskObject);
            }

            Intent intent = new Intent();
            intent.putExtra("list", array.toString());

            setResult(Activity.RESULT_OK, intent);
            finish();
        }
    });

    Task task = new Task ();
    String name = taskName.getText().toString();
    task.setNameTask(name);
    dataManager.addTask(task);

    }
}
