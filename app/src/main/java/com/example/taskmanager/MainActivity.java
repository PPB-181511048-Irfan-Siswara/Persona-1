package com.example.taskmanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static com.example.taskmanager.MyApp.db;

public class MainActivity extends AppCompatActivity {
    private TaskDataAdapter mAdapter;
	private List<Task> tasks = new ArrayList<>();
	private Button btnTambahDataActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTaskDataAdapter();
        setupRecyclerView();

        /* tombol tambah data*/
        btnTambahDataActivity = (Button) findViewById(R.id.btn_tambah);
        btnTambahDataActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iTambahData = new Intent(MainActivity.this, TambahData.class);
                startActivity(iTambahData);
            }
        });
    }
    private void setTaskDataAdapter(){
        db = Room.databaseBuilder(getApplicationContext(),
                TaskDatabase.class,"Tugas").allowMainThreadQueries().build();
        tasks = db.taskDao().getAll();

        mAdapter = new TaskDataAdapter(tasks);
    }
    private void setupRecyclerView(){
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(mAdapter);


        /*geser item tugas*/
        SwipeController swipeController = new SwipeController();

        ItemTouchHelper itemTouchhelper = new ItemTouchHelper(swipeController);
        itemTouchhelper.attachToRecyclerView(recyclerView);
    }
}
