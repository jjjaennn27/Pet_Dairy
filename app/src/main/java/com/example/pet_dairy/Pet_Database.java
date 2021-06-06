package com.example.pet_dairy;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Pet_Database {

    public static void getPersons(OnSuccessListener<DataSnapshot> onSuccessListener) {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference rootRef = firebaseDatabase.getReference("Family Pet");
        DatabaseReference personRef = rootRef.child("persons");

        personRef.get().addOnSuccessListener(onSuccessListener);
    }
}
