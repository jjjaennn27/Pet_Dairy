package com.example.pet_dairy;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import androidx.annotation.Nullable;

public class PetStorage {
    private static final String TAG = "PetStorage";

    public static void uploadPetImage(byte[] data,
                                      OnProgressListener<UploadTask.TaskSnapshot> onProgressListener,
                                      OnSuccessListener<UploadTask.TaskSnapshot> onSuccessListener,
                                      OnFailureListener onFailureListener) {
        String uid = getCurrentUserUid();
        if (uid == null) {
            return;
        }

        StorageReference petImage = getStorageReference(uid);

        // async 비동기적으로
        UploadTask uploadTask = petImage.putBytes(data);
        uploadTask.addOnProgressListener(onProgressListener)
                .addOnSuccessListener(onSuccessListener)
                .addOnFailureListener(onFailureListener);
    }

    public static void getPetImageUrl(OnSuccessListener<Uri> onSuccessListener, OnFailureListener onFailureListener) {
        String uid = getCurrentUserUid();
        if (uid == null) {
            return;
        }

        StorageReference petImage = getStorageReference(uid);
        // async 비동기
        petImage.getDownloadUrl()
                .addOnSuccessListener(onSuccessListener)
                .addOnFailureListener(onFailureListener);
    }

    private static StorageReference getStorageReference(String uid) {
        final FirebaseStorage storage = FirebaseStorage.getInstance();
        //storageRef -> gs://project-pet-ba709.appspot.com/
        final StorageReference storageRef = storage.getReference();

        // userFolder -> gs://project-pet-ba709.appspot.com/uid/
        StorageReference userFolder = storageRef.child(uid);

        // return -> gs://project-pet-ba709.appspot.com/uid/petImage
        return userFolder.child("petImage");
    }

    @Nullable
    private static String getCurrentUserUid() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user == null) {
            return null;
        }

        return user.getUid();
    }
}