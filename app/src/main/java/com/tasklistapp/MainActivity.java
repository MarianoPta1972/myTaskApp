package com.tasklistapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    final int REQUEST_CODE = 12345;

    Button addTaskBtn;
    TaskAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    addTaskBtn =findViewById(R.id.addTaskBtn);
        RecyclerView taskContainer = findViewById(R.id.taskContainer);
        taskContainer.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL,false));
        adapter = new TaskAdapter(dataManager.taskList);
        taskContainer.setAdapter(adapter);

        addTaskBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TaskActivity.class);

                startActivityForResult(intent, REQUEST_CODE);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE && resultCode == RESULT_OK){
            if(data != null){
                dataManager.setTaskList(new ArrayList<Task>());
                String taskString = data.getStringExtra("list");
                try {
                    JSONArray array = new JSONArray(taskString);
                    for (int i = 0; i < array.length(); i++) {
                        Gson gson = new Gson();
                        Task task = gson.fromJson(array.getString(i), Task.class);
                        dataManager.addTask(task);

                    }

                    adapter.taskArrayList = dataManager.taskList;
                    adapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
