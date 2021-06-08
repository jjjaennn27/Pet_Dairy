package com.example.pet_dairy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
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


public class Pet_Register extends AppCompatActivity {
    private Button btnCamera, btnGallery, btnSave;
    private ImageView animalImg;
    private ProgressBar progressBar;
    private EditText Name , Kind, birthday;
    private Spinner spinnergender;


    final  int CAMERA_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.pet__register);
        Name = findViewById(R.id.editTextTextPersonName);
        Kind = findViewById(R.id.editTextTextPersonName5);
        birthday = findViewById(R.id.editTextTextPersonName2);
        spinnergender = findViewById(R.id.spinnergender);


        // 성별 스피너
        ArrayAdapter time = ArrayAdapter.createFromResource(Pet_Register.this, R.array.gender, android.R.layout.simple_spinner_dropdown_item);
        time.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnergender.setAdapter(time);

        spinnergender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });


        btnCamera = (Button)findViewById(R.id.btnCamera);
        btnGallery = (Button)findViewById(R.id.btnGallery);
        animalImg = (ImageView)findViewById(R.id.Animal_img);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        btnSave = (Button) findViewById(R.id.btn_save);
        btnCamera.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(IsCameraAvailable()){
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                    startActivityForResult(intent, CAMERA_REQUEST_CODE);
                }
            }
        });

        btnGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, 2);
            }
        });

        btnSave.setOnClickListener(view -> {

            FirebaseDatabase firebaseDatabase= FirebaseDatabase.getInstance();
            DatabaseReference rootRef= firebaseDatabase.getReference("Family Pet");
            String name = Name.getText().toString();
            String kind = Kind.getText().toString();
            String Birthday = birthday.getText().toString();
            String Spinnergender = spinnergender.getSelectedItem().toString();

            Pet pet = new Pet(name, kind, Birthday, Spinnergender);

            DatabaseReference PetRef = rootRef.child("pet");
            PetRef.push().setValue(pet);

            BitmapDrawable bitmapDrawable = (BitmapDrawable) animalImg.getDrawable();
            if (bitmapDrawable == null) {
                return;
            }

            Bitmap bitmap = bitmapDrawable.getBitmap();
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bos) ;
            uploadImage(bos.toByteArray());

        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST_CODE) {
            Bundle bundle = data.getExtras();
            Bitmap bitmap = (Bitmap) bundle.get("data");
            animalImg.setImageBitmap(bitmap);
        } else if (requestCode == 2) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                try {
                    // 선택한 이미지에서 비트맵 생성
                    InputStream in = getContentResolver().openInputStream(data.getData());
                    Bitmap img = BitmapFactory.decodeStream(in);
                    in.close();
                    // 이미지 표시
                    animalImg.setImageBitmap(img);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void uploadImage(byte[] bytes) {
        progressBar.setVisibility(View.VISIBLE);
        PetStorage.uploadPetImage(bytes, onProgress -> {
            double value = (100.0 * onProgress.getBytesTransferred()) / onProgress.getTotalByteCount();
            int progress = (int) Math.round(value);
            progressBar.setProgress(progress);
        }, onSuccess -> {
            Toast.makeText(this, "이미지 등록 성공", Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.GONE);
        }, onFailure -> {
            Toast.makeText(this, "이미지 등록 실패", Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.GONE);
        });
    }

    public boolean IsCameraAvailable(){
        PackageManager packageManager = getPackageManager();
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        List<ResolveInfo> list = packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
        return list.size() > 0;
    }
    public static class PetStorage {
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


}