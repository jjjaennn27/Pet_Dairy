package com.example.pet_dairy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Register_Run extends AppCompatActivity {

    private final ArrayList<Walk> listRun = new ArrayList<>();
    private  RecyclerView recyclerView2;
    private RecyclerAdapter_run adapter2;
    private  RecyclerView.LayoutManager layoutManager2;

    private FloatingActionButton add2, look2;


    long mNow;
    Date mDate;
    SimpleDateFormat mFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.register__run);

        recyclerView2 = (RecyclerView) findViewById(R.id.run_list);
        recyclerView2.setHasFixedSize(true);
        layoutManager2 = new LinearLayoutManager(this);
        ((LinearLayoutManager) layoutManager2).setReverseLayout(true);
        ((LinearLayoutManager) layoutManager2).setStackFromEnd(true);

        add2 = findViewById(R.id.runButton2);
        look2 = findViewById(R.id.runButton);

        recyclerView2.setLayoutManager(layoutManager2);
        adapter2 = new RecyclerAdapter_run(listRun);

        recyclerView2.setAdapter(adapter2);

        FirebaseDatabase firebaseDatabase= FirebaseDatabase.getInstance();
        DatabaseReference rootRef = firebaseDatabase.getReference();
        DatabaseReference WalkRef = rootRef.child("walk");

        add2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder2 = new AlertDialog.Builder(Register_Run.this);
                View view2 = LayoutInflater.from(Register_Run.this).inflate(R.layout.register__run_writing, null, false);
                builder2.setView(view2);


                final Button btnnow = view2.findViewById(R.id.btnnow);
                final Button btn_mate = view2.findViewById(R.id.btn_mate);

                final ImageButton upload2 = view2.findViewById(R.id.up);
                final TextView txtmsg = view2.findViewById(R.id.txtmsg);
                final TextView txtNow = view2.findViewById(R.id.txtNow);
                final EditText place = view2.findViewById(R.id.txtplace);
                final Spinner spinner1 = view2.findViewById(R.id.spinner1);
                final Spinner spinner2 = view2.findViewById(R.id.spinner2);


                // 이름 스피너
                ArrayAdapter name = ArrayAdapter.createFromResource(Register_Run.this, R.array.name, android.R.layout.simple_spinner_dropdown_item);
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
                ArrayAdapter time = ArrayAdapter.createFromResource(Register_Run.this, R.array.time, android.R.layout.simple_spinner_dropdown_item);
                time.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner2.setAdapter(time);

                spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> parent) { }
                });

                btnnow.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        txtNow.setText(getTime());
                    }
                });

                btn_mate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), WalkingMate.class);
                        startActivity(intent);
                    }
                });


                final AlertDialog dialog2 = builder2.create();

                upload2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        txtmsg.setText(" 오늘의 산책정보 등록 완료! ");

                        //산책 정보 저장
                        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                        DatabaseReference rootRef = firebaseDatabase.getReference("Family Pet");

                        String Now = txtNow.getText().toString();  //현재 날짜, 시간
                        String Person = spinner1.getSelectedItem().toString(); //사람
                        String Time = spinner2.getSelectedItem().toString(); //시간
                        String Place = place.getText().toString(); //장소

                        Walk walk = new Walk(Person, Time, Place, Now);
                        if (Person.length() == 0) return;

                        DatabaseReference walkRef = rootRef.child("walk");
                        walkRef.push().setValue(walk);

                        walkRef.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                StringBuffer buffer = new StringBuffer();
                                listRun.clear();
                                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                                    Walk walk = snapshot.getValue(Walk.class);
                                    String Person = walk.getPerson();
                                    String Time = walk.getTime();
                                    String Place = walk.getPlace();
                                    String Now = walk.getNow();
                                    buffer.append(listRun);

                                    listRun.add(walk);
                                }
                                adapter2.notifyDataSetChanged();
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {
                            }
                        });
                        dialog2.dismiss();
                        Toast.makeText(getApplicationContext(), "저장되었습니다.", Toast.LENGTH_SHORT).show();
                    }
                });
                dialog2.show();
            }
        });


        look2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                WalkRef.addValueEventListener(new ValueEventListener() {

                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        StringBuffer buffer = new StringBuffer();
                        listRun.clear();

                        for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                            Walk walk = snapshot.getValue(Walk.class);
                            String Person = walk.getPerson();
                            String Time = walk.getTime();
                            String Place = walk.getPlace();
                            String Now = walk.getNow();

                            buffer.append(listRun);

                            listRun.add(walk);
                        }

                        adapter2.notifyDataSetChanged();
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                });
            }
        });
    }

    private String  getTime() {
        long mNow = System.currentTimeMillis();
        Date mDate = new Date(mNow);
        return mFormat.format(mDate);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void sampleMethod() {
    }
}