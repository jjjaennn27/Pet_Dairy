package com.example.pet_dairy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Register_Run extends AppCompatActivity implements View.OnClickListener {

    EditText place;
    TextView txtmsg, txtNow;
    Spinner spinner1, spinner2;
    ImageButton btn_finish;
    Button btn_mate, btnnow;

    long mNow;
    Date mDate;
    SimpleDateFormat mFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register__run);


        btn_finish= findViewById(R.id.btn_finish);
        btn_finish.setOnClickListener(this);
        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spnFood2);
        place = findViewById(R.id.txtplace);
        txtmsg = findViewById(R.id.txtmsg);
        btn_mate = findViewById(R.id.btn_mate);
        btn_mate.setOnClickListener(this);
        txtNow = findViewById(R.id.txtNow);
        btnnow = findViewById(R.id.btnnow);
        btnnow.setOnClickListener(this);

        // 이름 스피너
        ArrayAdapter name = ArrayAdapter.createFromResource(this, R.array.name, android.R.layout.simple_spinner_dropdown_item);
        name.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(name);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });

        // 산책 시간 스피너
        ArrayAdapter time = ArrayAdapter.createFromResource(this, R.array.time, android.R.layout.simple_spinner_dropdown_item);
        time.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(time);

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_finish:
                txtmsg.setText(" 오늘의 산책정보 등록 완료! ");

                //산책 정보 저장
                FirebaseDatabase firebaseDatabase= FirebaseDatabase.getInstance();
                DatabaseReference rootRef= firebaseDatabase.getReference("Family Pet");

                String Now = txtNow.getText().toString();  //현재 날짜, 시간
                String Person = spinner1.getSelectedItem().toString(); //사람
                String Time = spinner2.getSelectedItem().toString(); //시간
                String Place = place.getText().toString(); //장소

                Walk walk = new Walk(Person, Time, Place, Now);


                DatabaseReference walkRef = rootRef.child("walk");
                walkRef.push().setValue(walk);
                break;

            case R.id.btnnow:
                txtNow.setText(getTime());
                break;

            case R.id.btn_mate:
                Intent intent = new Intent(getApplicationContext(), WalkingMate.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    private String  getTime() {
        long mNow = System.currentTimeMillis();
        Date mDate = new Date(mNow);
        return mFormat.format(mDate);
    }
}