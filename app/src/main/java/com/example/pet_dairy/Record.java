package com.example.pet_dairy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Record extends AppCompatActivity {

    TextView tv2;
    EditText idText1;
    EditText idText2;
    EditText idText3;
    EditText idText4;
    EditText idText5;
    Button savebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.record);

        tv2 = findViewById(R.id.tv2);
        idText1 = findViewById(R.id.idText1);
        idText2 = findViewById(R.id.idText2);
        idText3 = findViewById(R.id.idText3);
        idText4 = findViewById(R.id.idText4);
        idText5 = findViewById(R.id.idText5);
        savebutton = findViewById(R.id.savebutton);


        savebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                DatabaseReference rootRef = firebaseDatabase.getReference("Family Pet");

                String IdText1 = idText1.getText().toString();
                String IdText2 = idText2.getText().toString();
                String IdText3 = idText3.getText().toString();
                String IdText4 = idText4.getText().toString();
                String IdText5 = idText5.getText().toString();

                Record_H record_h = new Record_H(IdText1, IdText2, IdText3, IdText4, IdText5);

                DatabaseReference record_hRef = rootRef.child("Record_H");
                record_hRef.push().setValue(record_h);

                record_hRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        StringBuffer buffer = new StringBuffer();

                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                            Record_H record_h = snapshot.getValue(Record_H.class);
                            String IdText1 = record_h.getIdText1();
                            String IdText2 = record_h.getIdText2();
                            String IdText3 = record_h.getIdText3();
                            String IdText4 = record_h.getIdText4();
                            String IdText5 = record_h.getIdText5();

                            buffer.append("몸무게 : " + IdText1 + "\n" + "배변/구토 : " + IdText2 + "\n" + "투약기록 : " +
                                    IdText3 + "\n +" + "접종일정 : " + IdText4 + "\n" + "입력날짜 : " + IdText5 + "\n\n");
                        }
                        tv2.setText(buffer);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }

    public void clickSave(View view) {
    }
}