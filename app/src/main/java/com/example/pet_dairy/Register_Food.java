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


public class Register_Food extends AppCompatActivity {

    private final ArrayList<Food> listFood = new ArrayList<>();
    private RecyclerView recyclerView1;
    private RecyclerAdapter_food adapter1;
    private  RecyclerView.LayoutManager layoutManager1;
    private DrawerLayout drawerLayout;
    private View drawerView;

    private FloatingActionButton add1, look1;

    long mNow;
    Date mDate;
    SimpleDateFormat mFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.register__food);

        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        drawerView = (View)findViewById(R.id.drawer);
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


        Button Btn1 = (Button)findViewById(R.id.Btn1);
        Btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_f =new Intent(Register_Food.this,Register_Food.class);
                startActivity(intent_f);
            }
        });
        Button Btn2 = (Button)findViewById(R.id.Btn2);
        Btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_s =new Intent(Register_Food.this,Register_Snack.class);
                startActivity(intent_s);
            }
        });
        Button Btn3 = (Button)findViewById(R.id.Btn3);
        Btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_h =new Intent(Register_Food.this,Register_Health.class);
                startActivity(intent_h);
            }
        });
        Button Btn4 = (Button)findViewById(R.id.Btn4);
        Btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_r =new Intent(Register_Food.this,Register_Run.class);
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



                setNameSpinner(Person);
                adspin1 = ArrayAdapter.createFromResource(Register_Food.this, R.array.spinner_do, android.R.layout.simple_spinner_dropdown_item);
                adspin1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                adspin2 = ArrayAdapter.createFromResource(com.example.pet_dairy.Register_Food.this, R.array.spinner_do_g, android.R.layout.simple_spinner_dropdown_item);
                adspin3 = ArrayAdapter.createFromResource(com.example.pet_dairy.Register_Food.this,R.array.spinner_do_s, android.R.layout.simple_spinner_dropdown_item);
                food1.setAdapter(adspin1);

                food1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        if (adspin1.getItem(i).equals("?????? ??????")) {
                            choice_do = "?????? ??????";
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
                        } else if (adspin1.getItem(i).equals("?????? ??????")) {
                            choice_do = "?????? ??????";
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
                        builder.setTitle("?????? ?????????");
                        builder.setMessage("??????~3?????? : ???????????? 7% \n 3??????~6?????? : ???????????? 5~7% \n 6??????~12?????? : ???????????? 4~5% \n 12?????? ?????? : ???????????? 2~3%");
                        builder.setNeutralButton("??????",null);
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
                        Toast.makeText(getApplicationContext(), "?????????????????????.", Toast.LENGTH_SHORT).show();
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