package com.tasklistapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {



        ArrayList<Task> taskArrayList;

        public TaskAdapter(ArrayList<Task> taskArrayList) {
            this.taskArrayList = taskArrayList;
        }

        @NonNull
        @Override
        public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tasklsinglelayout, parent, false);

            return new TaskViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull final TaskViewHolder holder, int position) {
            Task item = taskArrayList.get(position);
            holder.taskName.setText(item.getNameTask());
        }

        @Override
        public int getItemCount() {
            return taskArrayList.size();
        }

        public class TaskViewHolder extends RecyclerView.ViewHolder {
            RecyclerView recyclerView;
            TextView taskName;

            public TaskViewHolder(@NonNull View itemView) {
                super(itemView);
                recyclerView = itemView.findViewById(R.id.taskContainer);
                taskName = itemView.findViewById(R.id.singleTask);

            }
        }


    }
