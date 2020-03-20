package com.tasklistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;

import org.json.JSONArray;

import static com.tasklistapp.Status.COMPLETED;
import static com.tasklistapp.Status.INPROGRESS;
import static com.tasklistapp.Status.TODO;

public class TaskActivity extends AppCompatActivity {

    EditText taskName;
    FloatingActionButton btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tasklsinglelayout);

        taskName = findViewById(R.id.taskName);
        btn = findViewById(R.id.floatingActionButton);


        final Spinner spinner = (Spinner) findViewById(R.id.status_spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.status_spinner, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newTask = taskName.getText().toString();
                final Task task = new Task(newTask, getSelectedStatus());
                AlertDialog.Builder alert = new AlertDialog.Builder(TaskActivity.this);
                alert.setTitle("You are going to insert a new Task");
                alert.setMessage("Your Task is: " + taskName.getText() + " and its Status is: " + task.status.name());
                alert.setCancelable(false);

                alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        dataManager.taskList.add(task);
                        Intent intent = new Intent(TaskActivity.this, MainActivity.class);
                        startActivity(intent);
                        Toast.makeText(TaskActivity.this, "your choosen status is: " + spinner.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();
                    }
                });

                alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Intent intent = new Intent(TaskActivity.this, MainActivity.class);
                        startActivity(intent);
                        Toast.makeText(TaskActivity.this, "Your clicked cancel",
                                Toast.LENGTH_SHORT).show();
                    }
                });
                alert.show();

            }

            private Status getSelectedStatus() {
                String newStat = spinner.getSelectedItem().toString();
                if (newStat.equals("TODO")) {return TODO;} else if (newStat.equals("IN PROGRESS")) {
                    return INPROGRESS;} else {return COMPLETED;}

                }

        });
    }


    }


