package com.example.pet_dairy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Family_Register extends AppCompatActivity  {


    TextView tv;
    EditText Name;
    EditText age;
    EditText NickName;
    Button btn_pet, btn_pet2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.family__register);

        tv = findViewById(R.id.tv);
        Name = findViewById(R.id.Name);
        age = findViewById(R.id.age);
        NickName = findViewById(R.id.NickName);
        btn_pet = findViewById(R.id.btn_pet);
        btn_pet2 = findViewById(R.id.btn_pet2);

        btn_pet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Pet_Register1.class);
                startActivity(intent);
            }
        });

        btn_pet2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Pet_Main.class);
                startActivity(intent);
            }
        });
    }


        public void clickSave (View v) {


            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
            DatabaseReference rootRef = firebaseDatabase.getReference("Family Pet");

            String name = Name.getText().toString();
            String Age = age.getText().toString();
            String Nickname = NickName.getText().toString();

            Person person = new Person(name, Age, Nickname);

            DatabaseReference personRef = rootRef.child("persons");
            personRef.push().setValue(person);

            personRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    StringBuffer buffer = new StringBuffer();

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        Person person = snapshot.getValue(Person.class);
                        String name = person.getName();
                        String Age = person.getAge();
                        String Nickname = person.getNickName();

                        buffer.append("이름 : " + name + "\n" + "나이 : " + Age + "\n" + "별명 : " + Nickname + "\n\n");
                    }
                    tv.setText(buffer);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

        }

    }
