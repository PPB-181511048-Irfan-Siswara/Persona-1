package com.example.taskmanager;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

class TaskDataAdapter extends RecyclerView.Adapter<TaskDataAdapter.TaskViewHolder> {
    private List<Task> tasks;

    public class TaskViewHolder extends RecyclerView.ViewHolder{
        private TextView tugas,deskripsi,matkul,deadline;

        public TaskViewHolder(View view){
            super(view);
            matkul = (TextView) view.findViewById(R.id.matkul);
            tugas = (TextView) view.findViewById(R.id.tugas);
            deskripsi = (TextView) view.findViewById(R.id.deskripsi);
            deadline = (TextView) view.findViewById(R.id.deadline);
        }
    }

    public TaskDataAdapter(List<Task> tasks){
        this.tasks = tasks;
    }

    @Override
    public TaskViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.task_row, parent, false);
        return new TaskViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder (TaskViewHolder holder, int position) {
        Task task = tasks.get(position);
        holder.tugas.setText(task.getTugas());
        holder.deskripsi.setText(task.getDeskripsi());
        holder.matkul.setText(task.getMatkul());
        holder.deadline.setText(task.getDeadline());
    }
    @Override
    public int getItemCount(){
        return tasks.size();
    }
}
