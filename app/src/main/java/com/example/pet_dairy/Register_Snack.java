package com.example.pet_dairy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;

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


public class Register_Snack extends AppCompatActivity {

    private final ArrayList<Snack> listSnack = new ArrayList<>();
    private RecyclerView recyclerView2;
    private RecyclerAdapyer_snack adapter2;
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
        setContentView(R.layout.register__snack);

        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        drawerView = (View)findViewById(R.id.drawer);
        recyclerView2 = (RecyclerView) findViewById(R.id.snack_list);
        recyclerView2.setHasFixedSize(true);
        layoutManager2 = new LinearLayoutManager(this);
        ((LinearLayoutManager) layoutManager2).setReverseLayout(true);
        ((LinearLayoutManager) layoutManager2).setStackFromEnd(true);

        add2 = findViewById(R.id.snackButton2);
        look2 = findViewById(R.id.snackButton);

        recyclerView2.setLayoutManager(layoutManager2);
        adapter2 = new RecyclerAdapyer_snack(listSnack);

        recyclerView2.setAdapter(adapter2);

        FirebaseDatabase firebaseDatabase= FirebaseDatabase.getInstance();
        DatabaseReference rootRef = firebaseDatabase.getReference();


        Button Btn1 = (Button)findViewById(R.id.Btn1);
        Btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_f =new Intent(Register_Snack.this,Register_Food.class);
                startActivity(intent_f);
            }
        });
        Button Btn2 = (Button)findViewById(R.id.Btn2);
        Btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_s =new Intent(Register_Snack.this,Register_Snack.class);
                startActivity(intent_s);
            }
        });
        Button Btn3 = (Button)findViewById(R.id.Btn3);
        Btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_h =new Intent(Register_Snack.this,Register_Health.class);
                startActivity(intent_h);
            }
        });
        Button Btn4 = (Button)findViewById(R.id.Btn4);
        Btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_r =new Intent(Register_Snack.this,Register_Run.class);
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
        add2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder2 = new AlertDialog.Builder(Register_Snack.this);
                View view2 = LayoutInflater.from(Register_Snack.this).inflate(R.layout.register__snack_writing, null, false);
                builder2.setView(view2);

                final Button btnDate = view2.findViewById(R.id.btndate);
                final ImageButton upload2 = view2.findViewById(R.id.up);

                final Spinner Give = view2.findViewById(R.id.spnGive);
                final Spinner Type = view2.findViewById(R.id.spnType);
                final TextView Date = view2.findViewById(R.id.txtdate);
                final EditText Many  = view2.findViewById(R.id.txtMany);

                setNameSpinner(Give);

                ArrayAdapter type = ArrayAdapter.createFromResource(Register_Snack.this, R.array.??????, android.R.layout.simple_spinner_dropdown_item);
                type.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                Type.setAdapter(type);

                Type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });

                btnDate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Date.setText(getTime());
                    }
                });

                final AlertDialog dialog2 = builder2.create();

                upload2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                        DatabaseReference rootRef = firebaseDatabase.getReference("Pet Care");
                        DatabaseReference snackRef = rootRef.child("snack");

                        String strGive = Give.getSelectedItem().toString();
                        String strType = Type.getSelectedItem().toString();
                        String strDate = Date.getText().toString();
                        String strMany = Many.getText().toString();

                        Snack snack = new Snack(strGive,strType, strMany, strDate);
                        if (strGive.length() == 0) return;

                        snackRef.push().setValue(snack);

                        snackRef.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                StringBuffer buffer = new StringBuffer();
                                listSnack.clear();
                                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                                    Snack snack = snapshot.getValue(Snack.class);
                                    String strGive = snack.getGive();
                                    String strType = snack.getType();
                                    String strDate= snack.getDate();
                                    String strMany = snack.getMany();
                                    buffer.append(listSnack);

                                    listSnack.add(snack);
                                }
                                adapter2.notifyDataSetChanged();
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {
                            }
                        });
                        dialog2.dismiss();
                        Toast.makeText(getApplicationContext(), "?????????????????????.", Toast.LENGTH_SHORT).show();
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
                DatabaseReference snackRef = rootRef.child("snack");

                snackRef.addValueEventListener(new ValueEventListener() {

                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        StringBuffer buffer = new StringBuffer();
                        listSnack.clear();
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            Snack snack = snapshot.getValue(Snack.class);
                            String strGive = snack.getGive();
                            String strType = snack.getType();
                            String strDate= snack.getDate();
                            String strMany = snack.getMany();
                            buffer.append(listSnack);

                            listSnack.add(snack);
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
}