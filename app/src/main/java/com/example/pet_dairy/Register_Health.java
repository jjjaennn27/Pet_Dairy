package com.example.pet_dairy;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class Register_Health extends AppCompatActivity {

    DatePicker datePicker;
    EditText edtDiary;
    Button btnSave,btndiary, btnfind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register__health);
        setTitle("건강 다이어리");


        datePicker = (DatePicker) findViewById(R.id.datePicker);
        edtDiary = (EditText) findViewById(R.id.edtDiary);
        btnSave = (Button) findViewById(R.id.btnSave);
        btndiary = (Button) findViewById(R.id.btndiary);
        btnfind = (Button) findViewById(R.id.btnfind);


        datePicker.init(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth(), (view, year, month, day) -> {
        });


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                Intent myIntent = new Intent(Register_Health.this, Record.class);
                startActivity(myIntent);
                finish();
            }
        });

        btndiary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {
                Intent myIntent = new Intent(Register_Health.this, Diary.class);
                startActivity(myIntent);
                finish();
            }
        });

        btnfind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {
                Intent myIntent = new Intent(Register_Health.this, Register_Health_Find.class);
                startActivity(myIntent);
                finish();
            }
        });
    }
}