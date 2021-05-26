package com.example.pet_dairy;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


public class Pet_Main extends AppCompatActivity implements View.OnClickListener {
    ImageButton btnFood, btnSnack, btnWalk, btnHealth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pet__main);

        btnFood = findViewById(R.id.imgBtn1);
        btnFood.setOnClickListener(this);
        btnSnack = findViewById(R.id.imgBtn2);
        btnSnack.setOnClickListener(this);
        btnWalk = findViewById(R.id.imgBtn3);
        btnWalk.setOnClickListener(this);
        btnHealth = findViewById(R.id.imgBtn4);
        btnHealth.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgBtn1:
                Intent intent1 = new Intent(Pet_Main.this, Register_Food.class);
                startActivity(intent1);
                break;
            case R.id.imgBtn2:
                Intent intent2 = new Intent(Pet_Main.this, Register_Snack.class);
                startActivity(intent2);
                break;
            case R.id.imgBtn3:
                Intent intent3 = new Intent(Pet_Main.this, Register_Run.class);
                startActivity(intent3);
                break;
            case R.id.imgBtn4:
                Intent intent4 = new Intent(Pet_Main.this, Register_Health.class);
                startActivity(intent4);
                break;
            default: break;
        }

    }
}