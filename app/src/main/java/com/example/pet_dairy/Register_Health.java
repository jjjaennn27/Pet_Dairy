package com.example.pet_dairy;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Calendar;


public class Register_Health extends AppCompatActivity {

    Button btnSave, btndiary, btnfind, btnAlarm;
    DatePicker datePicker;
    EditText edtDiary;
    String fileName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register__health);
        setTitle("건강 다이어리");


        // 뷰에 있는 위젯들 리턴 받아두기
        datePicker = (DatePicker) findViewById(R.id.datePicker);
        edtDiary = (EditText) findViewById(R.id.edtDiary);
        btndiary = (Button) findViewById(R.id.btnRecord);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnfind = (Button) findViewById(R.id.btnfind);
        btnAlarm = (Button) findViewById(R.id.btnAlarm);

        Calendar c = Calendar.getInstance();
        int cYear = c.get(Calendar.YEAR);
        int cMonth = c.get(Calendar.MONTH);
        int cDay = c.get(Calendar.DAY_OF_MONTH);

        // 첫 시작 시에는 오늘 날짜 일기 읽어주기
        checkedDay(cYear, cMonth, cDay);

        // datePick 기능 만들기
        // datePicker.init(연도,달,일)
        datePicker.init(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth(), new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                // 이미 선택한 날짜에 일기가 있는지 없는지 체크해야할 시간이다
                checkedDay(year, monthOfYear, dayOfMonth);
            }
        });
        // 저장/수정 버튼 누르면 실행되는 리스너
        btndiary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveDiary(fileName);
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                Intent myIntent = new Intent(Register_Health.this, Record.class);
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

        btnAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                Intent myIntent = new Intent(Register_Health.this, Alarm.class);
                startActivity(myIntent);
                finish();
            }
        });


    }

    // 일기 파일 읽기
    private void checkedDay(int year, int monthOfYear, int dayOfMonth) {
        // 파일 이름을 만들어준다. 파일 이름은 "20170318.txt" 이런식으로 나옴
        fileName = year + "" + monthOfYear + "" + dayOfMonth + ".txt";

        // 읽어봐서 읽어지면 일기 가져오고
        // 없으면 catch 그냥 살아? 아주 위험한 생각같다..
        FileInputStream fis = null;
        try {
            fis = openFileInput(fileName);

            byte[] fileData = new byte[fis.available()];
            fis.read(fileData);
            fis.close();

            String str = new String(fileData, "EUC-KR");
            // 읽어서 토스트 메시지로 보여줌
            Toast.makeText(getApplicationContext(), "일기 쓴 날", Toast.LENGTH_SHORT).show();
            edtDiary.setText(str);
            btndiary.setText("수정하기");
        } catch (Exception e) { // UnsupportedEncodingException , FileNotFoundException , IOException
            // 없어서 오류가 나면 일기가 없는 것 -> 일기를 쓰게 한다.
            Toast.makeText(getApplicationContext(), "일기 없는 날", Toast.LENGTH_SHORT).show();
            edtDiary.setText("");
            btndiary.setText("새 일기 저장");
            e.printStackTrace();
        }
    }

    // 일기 저장하는 메소드
    @SuppressLint("WrongConstant")
    private void saveDiary(String readDay) {

        FileOutputStream fos = null;

        try {
            fos = openFileOutput(readDay, MODE_NO_LOCALIZED_COLLATORS); //MODE_WORLD_WRITEABLE
            String content = edtDiary.getText().toString();
            // String.getBytes() = 스트링을 배열형으로 변환?
            fos.write(content.getBytes());
            //fos.flush();
            fos.close();
            // getApplicationContext() = 현재 클래스.this ?
            Toast.makeText(getApplicationContext(), "일기 저장됨", Toast.LENGTH_SHORT).show();

        } catch (Exception e) { // Exception - 에러 종류 제일 상위 // FileNotFoundException , IOException
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "일기가 저장되지않았습니다.", Toast.LENGTH_SHORT).show();
        }
    }

}
