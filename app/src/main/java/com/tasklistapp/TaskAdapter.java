package com.tasklistapp;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {



       //  ArrayList<Task> taskArrayList; אין צורך כי יש לך אחד בתוך הדאטה מאנג'ר

      //  public TaskAdapter(ArrayList<Task> taskArrayList) { אין צורך
//            this.taskArrayList = taskArrayList;
//        }

        @NonNull
        @Override
        public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.activity_task, parent, false);

            return new TaskViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull final TaskViewHolder holder, int position) {
//            Task item = taskArrayList.get(position);
            Task item = dataManager.taskList.get(position);  // אני משתמשת בARRAY של הדאטה
            holder.taskName.setText(item.getNameTask());
            holder.statusName.setText("status: "+ item.status);

            switch (item.status) {
                case TODO:
                    holder.taskName.setTextColor(Color.RED);
                    break;
                case INPROGRESS:
                    holder.taskName.setTextColor(Color.YELLOW);
                    break;
                case COMPLETED:
                    holder.taskName.setTextColor(Color.GREEN);
                    break;

            }
        }

        @Override
        public int getItemCount() {
            return dataManager.taskList.size();
        } //  גם פה

        public class TaskViewHolder extends RecyclerView.ViewHolder {
        //    RecyclerView recyclerView; זה לא פה
            TextView taskName;
            TextView statusName;

            public TaskViewHolder(@NonNull View itemView) {
                super(itemView);
          //      recyclerView = itemView.findViewById(R.id.taskContainer);  זה לא פה
                taskName = itemView.findViewById(R.id.singleTask);
                statusName = itemView.findViewById(R.id.status);

            }
        }


    }
