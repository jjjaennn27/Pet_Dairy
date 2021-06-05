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


public class Register_Food extends AppCompatActivity {

    private final ArrayList<Food> listFood = new ArrayList<>();
    private RecyclerView recyclerView1;
    private RecyclerAdapter_food adapter1;
    private  RecyclerView.LayoutManager layoutManager1;

    private FloatingActionButton add1, look1;

    long mNow;
    Date mDate;
    SimpleDateFormat mFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.register__food);

        recyclerView1 = (RecyclerView) findViewById(R.id.food_list);
        recyclerView1.setHasFixedSize(true);
        layoutManager1 = new LinearLayoutManager(this);
        ((LinearLayoutManager) layoutManager1).setReverseLayout(true);
        ((LinearLayoutManager) layoutManager1).setStackFromEnd(true);

        add1 = findViewById(R.id.foodButton2);
        look1 = findViewById(R.id.foodButton);

        recyclerView1.setLayoutManager(layoutManager1);
        adapter1 = new RecyclerAdapter_food(listFood);

        recyclerView1.setAdapter(adapter1);

        FirebaseDatabase firebaseDatabase= FirebaseDatabase.getInstance();
        DatabaseReference rootRef = firebaseDatabase.getReference();


        add1.setOnClickListener(new View.OnClickListener() {
            ArrayAdapter<CharSequence>adspin1, adspin2, adspin3;
            String choice_do="";
            String choice_se="";

            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder1 = new AlertDialog.Builder(Register_Food.this);
                View view1 = LayoutInflater.from(Register_Food.this).inflate(R.layout.register__food_writing, null, false);
                builder1.setView(view1);

                final Button btnRec = view1.findViewById(R.id.button2);
                final Button btnnow = view1.findViewById(R.id.btnnow);

                final ImageButton upload1 = view1.findViewById(R.id.up);
                final Spinner Person = view1.findViewById(R.id.name);
                final TextView now = view1.findViewById(R.id.txt);
                final Spinner food1 = view1.findViewById(R.id.spnFood);
                final Spinner food2 = view1.findViewById(R.id.spnFood2);

                ArrayAdapter name = ArrayAdapter.createFromResource(Register_Food.this, R.array.name, android.R.layout.simple_spinner_dropdown_item);
                name.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                Person.setAdapter(name);

                Person.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });
                adspin1 = ArrayAdapter.createFromResource(Register_Food.this, R.array.spinner_do, android.R.layout.simple_spinner_dropdown_item);
                adspin1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                adspin2 = ArrayAdapter.createFromResource(com.example.pet_dairy.Register_Food.this, R.array.spinner_do_g, android.R.layout.simple_spinner_dropdown_item);
                adspin3 = ArrayAdapter.createFromResource(com.example.pet_dairy.Register_Food.this,R.array.spinner_do_s, android.R.layout.simple_spinner_dropdown_item);
                food1.setAdapter(adspin1);

                food1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        if (adspin1.getItem(i).equals("건식 사료")) {
                            choice_do = "건식 사료";
                            adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            food2.setAdapter(adspin2);
                            food2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                    choice_se = adspin2.getItem(i).toString();
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> adapterView) {
                                }
                            });
                        } else if (adspin1.getItem(i).equals("습식 사료")) {
                            choice_do = "습식 사료";
                            adspin3 = ArrayAdapter.createFromResource(com.example.pet_dairy.Register_Food.this, R.array.spinner_do_s, android.R.layout.simple_spinner_dropdown_item);
                            adspin3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            food2.setAdapter(adspin3);
                            food2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                    choice_se = adspin3.getItem(i).toString();
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> adapterView) {
                                }
                            });
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {
                    }
                });

                btnnow.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        now.setText(getTime());
                    }
                });

                btnRec.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(com.example.pet_dairy.Register_Food.this);
                        builder.setTitle("권장 사료량");
                        builder.setMessage("생후~3개월 : 몸무게의 7% \n 3개월~6개월 : 몸무게의 5~7% \n 6개월~12개월 : 몸무게의 4~5% \n 12개월 이상 : 몸무게의 2~3%");
                        builder.setNeutralButton("닫기",null);
                        builder.create().show();
                    }
                });


                final AlertDialog dialog1 = builder1.create();

                upload1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                        DatabaseReference rootRef = firebaseDatabase.getReference("Pet Care");
                        DatabaseReference foodRef = rootRef.child("food");

                        String strPerson = Person.getSelectedItem().toString();
                        String stnNow = now.getText().toString();
                        String strFood1 = food1.getSelectedItem().toString();
                        String strFood2 = food2.getSelectedItem().toString();

                        Food food = new Food(strPerson, stnNow, strFood1, strFood2);
                        if (strPerson.length() == 0) return;

                        foodRef.push().setValue(food);

                        foodRef.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                StringBuffer buffer = new StringBuffer();
                                listFood.clear();
                                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                                    Food food = snapshot.getValue(Food.class);
                                    String strPerson = food.getperson();
                                    String stnNow = food.getnow();
                                    String strFood1 = food.getfood1();
                                    String strFood2 = food.getfood2();
                                    buffer.append(listFood);

                                    listFood.add(food);
                                }
                                adapter1.notifyDataSetChanged();
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {
                            }
                        });
                        dialog1.dismiss();
                        Toast.makeText(getApplicationContext(), "저장되었습니다.", Toast.LENGTH_SHORT).show();
                    }
                });
                dialog1.show();
            }
        });

        look1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                DatabaseReference rootRef = firebaseDatabase.getReference("Pet Care");
                DatabaseReference foodRef = rootRef.child("food");

                foodRef.addValueEventListener(new ValueEventListener() {

                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        StringBuffer buffer = new StringBuffer();
                        listFood.clear();

                        for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                            Food food = snapshot.getValue(Food.class);
                            String  strPerson= food.getperson();
                            String  stnNow = food.getnow();
                            String  strFood1 = food.getfood1();
                            String  strFood2= food.getfood2();
                            buffer.append(listFood);

                            listFood.add(food);
                        }

                        adapter1.notifyDataSetChanged();
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
