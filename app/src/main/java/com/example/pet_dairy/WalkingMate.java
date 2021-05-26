package com.example.pet_dairy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WalkingMate extends AppCompatActivity implements View.OnClickListener {
    Button btnWrite, btnMap;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.walkingmate);

        btnWrite = findViewById(R.id.btnWrite);
        btnWrite.setOnClickListener(this);
        btnMap = findViewById(R.id.btnMap);
        btnMap.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnWrite:
                intent = new Intent(this, WalkingMate_Board.class);
                break;
            case R.id.btnMap:
                intent = new Intent(this, WalkingMate_map.class);
                break;
            default: break;
        }
        startActivity(intent);
    }
}