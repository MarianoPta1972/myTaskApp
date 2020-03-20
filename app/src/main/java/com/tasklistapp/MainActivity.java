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
    //  TaskAdapter adapter; אני שמה אותו למטה בשורה אחת

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addTaskBtn = findViewById(R.id.addTaskBtn);

        addTaskBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TaskActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

        RecyclerView rv = findViewById(R.id.taskContainer);
        final TaskAdapter adapter = new TaskAdapter();
        rv.setAdapter(adapter);

    }
}


