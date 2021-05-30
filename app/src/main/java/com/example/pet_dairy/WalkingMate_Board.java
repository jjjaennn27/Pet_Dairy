package com.example.pet_dairy;

import androidx.appcompat.app.AppCompatActivity;

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
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
public class WalkingMate_Board extends AppCompatActivity {

    private final ArrayList<Board> listBundle = new ArrayList<>();
    private  RecyclerView recyclerView;
    private WalkingMate_Board_RecyclerAdapter adapter;
    private  RecyclerView.LayoutManager layoutManager;

    private FloatingActionButton add, look;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.walkingmate_board);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        ((LinearLayoutManager) layoutManager).setReverseLayout(true);
        ((LinearLayoutManager) layoutManager).setStackFromEnd(true);

        add = findViewById(R.id.floatingActionButton2);
        look = findViewById(R.id.floatingActionButton);

        recyclerView.setLayoutManager(layoutManager);
        adapter = new WalkingMate_Board_RecyclerAdapter(listBundle);

        recyclerView.setAdapter(adapter);


        FirebaseDatabase firebaseDatabase= FirebaseDatabase.getInstance();
        DatabaseReference rootRef = firebaseDatabase.getReference();
        DatabaseReference BoardRef = rootRef.child("WalkingBoards");

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(WalkingMate_Board.this);
                View view = LayoutInflater.from(WalkingMate_Board.this).inflate(R.layout.walkingmate_board_writing, null, false);
                builder.setView(view);

                final Button upload = view.findViewById(R.id.btnUp1);
                final EditText Plice = view.findViewById(R.id.PliceText);
                final Spinner Time = view.findViewById(R.id.Timetext1);
                final EditText dog  =  view.findViewById(R.id.Dog_breedText);
                final EditText id = view.findViewById(R.id.IDText1);

                ArrayAdapter timee = ArrayAdapter.createFromResource(WalkingMate_Board.this, R.array.time, android.R.layout.simple_spinner_dropdown_item);
                timee.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                Time.setAdapter(timee);

                Time.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> parent) { }
                });

                final AlertDialog dialog = builder.create();

                upload.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String strPlice = Plice.getText().toString();
                        String strTime = Time.getSelectedItem().toString();
                        String strDog = dog.getText().toString();
                        String  strid = id.getText().toString();

                        Board board = new Board(strPlice, strTime, strDog, strid);
                        if(strPlice.length() == 0)return;

                        BoardRef.push().setValue(board);

                        BoardRef.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                StringBuffer buffer = new StringBuffer();
                                listBundle.clear();
                                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                                    Board board = snapshot.getValue(Board.class);
                                    String  strPlice = board.getPlace();
                                    String strTime = board.getTime();
                                    String strDog = board.getDog_breed();
                                    String  strid = board.getID();
                                    buffer.append(listBundle);

                                    listBundle.add(board);
                                }
                                adapter.notifyDataSetChanged();
                            }
                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {
                            }
                        });
                        dialog.dismiss();
                        Toast.makeText(getApplicationContext(),"저장되었습니다. ", Toast.LENGTH_SHORT).show();
                    }
                });

                dialog.show();
            }
        });



        look.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BoardRef.addValueEventListener(new ValueEventListener() {

                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        StringBuffer buffer = new StringBuffer();
                        listBundle.clear();

                        for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                            Board board = snapshot.getValue(Board.class);
                            String  strPlice = board.getPlace();
                            String strTime = board.getTime();
                            String strDog = board.getDog_breed();
                            String  strid = board.getID();
                            buffer.append(listBundle);

                            listBundle.add(board);
                        }

                        adapter.notifyDataSetChanged();
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                });
            }
        });
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void sampleMethod() {
    }
}