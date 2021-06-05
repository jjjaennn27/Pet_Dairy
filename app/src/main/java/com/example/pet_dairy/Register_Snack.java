package com.example.pet_dairy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.os.Bundle;

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


public class Register_Snack extends AppCompatActivity {

    private final ArrayList<Snack> listSnack = new ArrayList<>();
    private RecyclerView recyclerView2;
    private RecyclerAdapyer_snack adapter2;
    private  RecyclerView.LayoutManager layoutManager2;

    private FloatingActionButton add2, look2;

    long mNow;
    Date mDate;
    SimpleDateFormat mFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.register__snack);

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


        add2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder2 = new AlertDialog.Builder(Register_Snack.this);
                View view2 = LayoutInflater.from(Register_Snack.this).inflate(R.layout.register__snack_writing, null, false);
                builder2.setView(view2);

                final Button btnDate = view2.findViewById(R.id.btndate);
                final ImageButton upload2 = view2.findViewById(R.id.btnregister);

                final Spinner Give = view2.findViewById(R.id.spnGive);
                final Spinner Type = view2.findViewById(R.id.spnType);
                final TextView Date = view2.findViewById(R.id.txtdate);
                final EditText Many  = view2.findViewById(R.id.txtMany);

                ArrayAdapter give = ArrayAdapter.createFromResource(Register_Snack.this, R.array.name, android.R.layout.simple_spinner_dropdown_item);
                give.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                Give.setAdapter(give);

                Give.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });

                ArrayAdapter type = ArrayAdapter.createFromResource(Register_Snack.this, R.array.종류, android.R.layout.simple_spinner_dropdown_item);
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
    private String  getTime() {
        long mNow = System.currentTimeMillis();
        Date mDate = new Date(mNow);
        return mFormat.format(mDate);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void sampleMethod() {
    }
}
