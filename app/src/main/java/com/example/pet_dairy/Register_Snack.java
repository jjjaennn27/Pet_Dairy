package com.example.pet_dairy;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register_Snack extends AppCompatActivity {

    ImageButton register;
    Spinner spnGive, spnType;
    TextView txtmsg;
    EditText txttime ,txtmany;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register__snack);

        txtmany = findViewById(R.id.txtMany);
        txttime = findViewById(R.id.txtTime);
        txtmsg = findViewById(R.id.textView6);
        register = findViewById(R.id.btn_finish);
        spnGive = findViewById(R.id.spnGive);
        spnType = findViewById(R.id.spnType);

        ArrayAdapter GiveAdapter = ArrayAdapter.createFromResource(this,
                R.array.name, android.R.layout.simple_spinner_item);
        GiveAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnGive.setAdapter(GiveAdapter);

        ArrayAdapter TypeAdapter = ArrayAdapter.createFromResource(this,
                R.array.종류, android.R.layout.simple_spinner_item);
        TypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnType.setAdapter(TypeAdapter);

        findViewById(R.id.btn_finish).setOnClickListener(
                new Button.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        txtmsg.setText("오늘의 간식정보 등록 완료!");

                        FirebaseDatabase firebaseDatabase= FirebaseDatabase.getInstance();
                        DatabaseReference rootRef= firebaseDatabase.getReference();
                        String Give = spnGive.getSelectedItem().toString();
                        String Type = spnType.getSelectedItem().toString();
                        String Time = txttime.getText().toString();
                        String Many = txtmany.getText().toString();

                        Snack snack = new Snack(Give, Type, Time, Many);

                        DatabaseReference SnackRef = rootRef.child("snack");
                        SnackRef.push().setValue(snack);
                    }
                }
        );
    }
}
