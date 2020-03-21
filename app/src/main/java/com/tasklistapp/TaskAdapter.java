package com.tasklistapp;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {


        @NonNull
        @Override
        public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.activity_task, parent, false);

            return new TaskViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull final TaskViewHolder holder, int position) {

            final Task item = dataManager.taskList.get(position);  // אני משתמשת בARRAY של הדאטה
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
                    holder.switchBtn.setChecked(true);
                    break;

            }

            holder.switchBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        holder.taskName.setTextColor(Color.GREEN);
                        item.status = Status.COMPLETED;
                        holder.statusName.setText("status: "+ item.status.name());
                    } else {
                        holder.taskName.setTextColor(Color.YELLOW);
                        item.status = Status.INPROGRESS;
                        holder.statusName.setText("status: "+ item.status.name());
                        holder.switchBtn.setLinkTextColor(Color.YELLOW);

                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return dataManager.taskList.size();
        }

        public class TaskViewHolder extends RecyclerView.ViewHolder {

            TextView taskName;
            TextView statusName;
            Switch switchBtn;

            public TaskViewHolder(@NonNull View itemView) {
                super(itemView);
                taskName = itemView.findViewById(R.id.singleTask);
                statusName = itemView.findViewById(R.id.status);
                switchBtn = itemView.findViewById(R.id.switch1);
            }
        }


    }
