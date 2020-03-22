package com.example.taskmanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.taskmanager.MyApp.db;

public class TambahData extends AppCompatActivity {
    private Button simpan;
    private Button kembali;
    private EditText etTugas;
    private EditText etDeskripsi;
    private EditText etMatkul;
    private EditText etDeadline;
    Task task;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tambah_data);

        simpan = (Button)findViewById(R.id.btn_simpan);
        kembali = (Button)findViewById(R.id.btn_kembali);
        etTugas = (EditText)findViewById(R.id.edit_tugas);
        etMatkul = (EditText)findViewById(R.id.edit_matkul);
        etDeskripsi = (EditText)findViewById(R.id.edit_deskripsi);
        etDeadline = (EditText)findViewById(R.id.edit_deadline);


        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!etTugas.getText().toString().isEmpty()&&!etMatkul.getText().toString().isEmpty()&&
                        !etDeadline.getText().toString().isEmpty()&&!etDeskripsi.getText().toString().isEmpty()){

                    task = new Task();
                    task.setTugas(etTugas.getText().toString());
                    task.setMatkul(etMatkul.getText().toString());
                    task.setDeadline(etDeadline.getText().toString());
                    task.setDeskripsi(etDeskripsi.getText().toString());
                    db.taskDao().insertAll(task);

                    Toast.makeText(getApplicationContext(),"Berhasil",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Gagal",Toast.LENGTH_LONG).show();
                }

            }
        });

        kembali.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent ikembali = new Intent(TambahData.this,MainActivity.class);
                startActivity(ikembali);
                finish();
            }
        });
    }
}
