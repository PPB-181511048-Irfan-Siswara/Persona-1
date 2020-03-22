package com.example.taskmanager;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "task_table")
public class Task {

    @PrimaryKey
    @NonNull

    @ColumnInfo(name = "tugas")
    private String tugas;

    @ColumnInfo(name = "deskirpsi")
    private String deskripsi;

    @ColumnInfo(name = "matkul")
    private String matkul;

    @ColumnInfo(name = "deadline")
    private String deadline;

    public String getTugas(){
        return tugas;
    }

    public void setTugas(String tugas) {
        this.tugas = tugas;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getMatkul() {
        return matkul;
    }

    public void setMatkul(String matkul) {
        this.matkul = matkul;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
}
