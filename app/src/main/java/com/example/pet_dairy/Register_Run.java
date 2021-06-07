package com.example.pet_dairy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;

import android.view.LayoutInflater;
import android.view.MotionEvent;
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
import java.util.List;

public class Register_Run extends AppCompatActivity {

    private final ArrayList<Walk> listRun = new ArrayList<>();
    private  RecyclerView recyclerView2;
    private RecyclerAdapter_run adapter2;
    private  RecyclerView.LayoutManager layoutManager2;

    private FloatingActionButton add2, look2;

    private DrawerLayout drawerLayout;
    private View drawerView;


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
        //DatabaseReference walkRef = rootRef.child("walk");

        add2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder2 = new AlertDialog.Builder(Register_Run.this);
                View view2 = LayoutInflater.from(Register_Run.this).inflate(R.layout.register__run_writing, null, false);
                builder2.setView(view2);


                final Button btnnow = view2.findViewById(R.id.btnnow);
                final Button btn_mate = view2.findViewById(R.id.btn_mate);
                final ImageButton upload2 = view2.findViewById(R.id.up);

                final TextView Now = view2.findViewById(R.id.txtNow);
                final EditText Place = view2.findViewById(R.id.txtplace);
                final Spinner spinner1 = view2.findViewById(R.id.spinner1);
                final Spinner spinner2 = view2.findViewById(R.id.spinner2);

                Button Btn1 = (Button)findViewById(R.id.Btn1);
                Btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent_f =new Intent(Register_Run.this,Register_Food.class);
                        startActivity(intent_f);
                    }
                });
                Button Btn2 = (Button)findViewById(R.id.Btn2);
                Btn2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent_s =new Intent(Register_Run.this,Register_Snack.class);
                        startActivity(intent_s);
                    }
                });
                Button Btn3 = (Button)findViewById(R.id.Btn3);
                Btn3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent_h =new Intent(Register_Run.this,Register_Health.class);
                        startActivity(intent_h);
                    }
                });
                Button Btn4 = (Button)findViewById(R.id.Btn4);
                Btn4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent_r =new Intent(Register_Run.this,Register_Run.class);
                        startActivity(intent_r);
                    }
                });

                Button btn_close = (Button)findViewById(R.id.btn_close);
                btn_close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        drawerLayout.closeDrawers();
                    }
                });

                drawerLayout.setDrawerListener(listener);
                drawerView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        return true;
                    }
                });


                // 이름 스피너
                setNameSpinner(spinner1);

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
                        Now.setText(getTime());
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

                        //산책 정보 저장
                        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                        DatabaseReference rootRef = firebaseDatabase.getReference("Pet Care");
                        DatabaseReference walkRef = rootRef.child("walk");

                        String strTime = spinner2.getSelectedItem().toString(); //시간
                        String strPlace = Place.getText().toString(); //장소
                        String strPerson = spinner1.getSelectedItem().toString(); //사람
                        String strDate = Now.getText().toString();  //현재 날짜, 시간


                        Walk walk = new Walk(strTime, strPlace, strPerson, strDate);
                        if (strPerson.length() == 0) return;

                        walkRef.push().setValue(walk);

                        walkRef.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                StringBuffer buffer = new StringBuffer();
                                listRun.clear();
                                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                                    Walk walk = snapshot.getValue(Walk.class);
                                    String strTime = walk.getTime();
                                    String strPlace = walk.getPlace();
                                    String strPerson = walk.getPerson();
                                    String strDate = walk.getNow();
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

                FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                DatabaseReference rootRef = firebaseDatabase.getReference("Pet Care");
                DatabaseReference walkRef = rootRef.child("walk");

                walkRef.addValueEventListener(new ValueEventListener() {

                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        StringBuffer buffer = new StringBuffer();
                        listRun.clear();
                        for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                            Walk walk = snapshot.getValue(Walk.class);

                            String strTime = walk.getTime();
                            String strPlace = walk.getPlace();
                            String strPerson = walk.getPerson();
                            String strDate = walk.getNow();

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

    private void setNameSpinner(Spinner nameSpinner) {
        Pet_Database.getPersons(dataSnapshot -> {
            List<String> persons = new ArrayList<>();
            for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                Person person = snapshot.getValue(Person.class);
                if (person != null) {
                    persons.add(person.name);
                }
            }

            final ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<>(
                    this, android.R.layout.simple_spinner_dropdown_item, persons);
            spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            nameSpinner.setAdapter(spinnerArrayAdapter);
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

    DrawerLayout.DrawerListener listener = new DrawerLayout.DrawerListener() {
        @Override
        public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
        }

        @Override
        public void onDrawerOpened(@NonNull View drawerView) {
        }
        @Override
        public void onDrawerClosed(@NonNull View drawerView) {
        }
        @Override
        public void onDrawerStateChanged(int newState) {
        }
    };
}