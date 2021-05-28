package com.example.pet_dairy;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register_Food extends AppCompatActivity {

    ImageButton register;

    ArrayAdapter<CharSequence> adspin0, adspin1, adspin2, adspin3;
    String choice_do="";
    String choice_se="";
    TextView txtmsg;
    Button btnRec;
    EditText edittxt_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register__food);
        txtmsg = findViewById(R.id.textView);
        register = findViewById(R.id.btn_finish);
        btnRec = findViewById(R.id.btnRec);
        edittxt_time = findViewById(R.id.edittxt_time);
        final Spinner spnper = (Spinner)findViewById(R.id.spnPer); //0
        final Spinner spnfood = (Spinner)findViewById(R.id.spnFood); //1
        final Spinner spnfood2 = (Spinner)findViewById(R.id.spnFood2); //2
        adspin0 = ArrayAdapter.createFromResource(this, R.array.name, android.R.layout.simple_spinner_dropdown_item);
        adspin1 = ArrayAdapter.createFromResource(this, R.array.spinner_do, android.R.layout.simple_spinner_dropdown_item);
        adspin1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adspin2 = ArrayAdapter.createFromResource(com.example.pet_dairy.Register_Food.this, R.array.spinner_do_g, android.R.layout.simple_spinner_dropdown_item);
        adspin3 = ArrayAdapter.createFromResource(com.example.pet_dairy.Register_Food.this,R.array.spinner_do_s, android.R.layout.simple_spinner_dropdown_item);
        spnfood.setAdapter(adspin1);


        ArrayAdapter PerAdapter = ArrayAdapter.createFromResource(this,
                R.array.name, android.R.layout.simple_spinner_item);
        PerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnper.setAdapter(PerAdapter);

        spnfood.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (adspin1.getItem(i).equals("건식 사료")) {
                    choice_do = "건식 사료";
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spnfood2.setAdapter(adspin2);
                    spnfood2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
                    spnfood2.setAdapter(adspin3);
                    spnfood2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtmsg.setText("오늘의 밥 정보 등록 완료!");

                //밥 정보 저장
                FirebaseDatabase firebaseDatabase= FirebaseDatabase.getInstance();
                DatabaseReference rootRef= firebaseDatabase.getReference();

                String person = spnper.getSelectedItem().toString(); //사람
                String time = edittxt_time.getText().toString(); //시간
                String food1 = spnfood.getSelectedItem().toString();//식사량1
                String food2 = spnfood2.getSelectedItem().toString();//식사량2


                Food food = new Food(person, time, food1, food2);

                DatabaseReference foodRef = rootRef.child("food");
                foodRef.push().setValue(food);
            }
        });


    }
}