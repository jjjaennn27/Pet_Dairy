package com.example.pet_dairy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Register_Snack extends AppCompatActivity implements View.OnClickListener {

    long mNow;
    Date mDate;
    SimpleDateFormat mFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    ImageButton btnregister;
    Spinner spnGive, spnType;
    TextView txtmsg, date;
    Button btndate;
    EditText txttime, txtmany;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register__snack);

        txtmany = findViewById(R.id.txtMany);
        txtmsg = findViewById(R.id.textView6);
        btnregister = findViewById(R.id.btnregister);
        btnregister.setOnClickListener(this);
        spnGive = findViewById(R.id.spnGive);
        spnType = findViewById(R.id.spnType);
        date = findViewById(R.id.txtdate);
        btndate = findViewById(R.id.btndate);
        btndate.setOnClickListener(this);

        ArrayAdapter GiveAdapter = ArrayAdapter.createFromResource(this,
                R.array.name, android.R.layout.simple_spinner_item);
        GiveAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnGive.setAdapter(GiveAdapter);

        ArrayAdapter TypeAdapter = ArrayAdapter.createFromResource(this,
                R.array.종류, android.R.layout.simple_spinner_item);
        TypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnType.setAdapter(TypeAdapter);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnregister:
                txtmsg.setText("오늘의 간식정보 등록 완료!");

                FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                DatabaseReference rootRef = firebaseDatabase.getReference();
                String Give = spnGive.getSelectedItem().toString();
                String Type = spnType.getSelectedItem().toString();
                String Many = txtmany.getText().toString();
                String Date = date.getText().toString();

                Snack snack = new Snack(Give, Type, Many, Date);

                DatabaseReference SnackRef = rootRef.child("snack");
                SnackRef.push().setValue(snack);
                break;

            case R.id.btndate:
                date.setText(getTime());
                break;

            default:
                break;
        }
    }

    private String getTime () {
        mNow = System.currentTimeMillis();
        mDate = new Date(mNow);
        return mFormat.format(mDate);
    }

}