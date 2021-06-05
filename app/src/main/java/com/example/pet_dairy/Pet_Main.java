package com.example.pet_dairy;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.google.android.gms.auth.api.signin.internal.Storage;


public class Pet_Main extends AppCompatActivity implements View.OnClickListener {
    ImageButton btnFood, btnSnack, btnWalk, btnHealth;
    ImageView petImage;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pet__main);

        btnFood = findViewById(R.id.imgBtn1);
        btnFood.setOnClickListener(this);
        btnSnack = findViewById(R.id.imgBtn2);
        btnSnack.setOnClickListener(this);
        btnWalk = findViewById(R.id.imgBtn3);
        btnWalk.setOnClickListener(this);
        btnHealth = findViewById(R.id.imgBtn4);
        btnHealth.setOnClickListener(this);
        petImage = findViewById(R.id.imgView1);
        progressBar = findViewById(R.id.progress_bar);

        postPetImage();
    }

    private void postPetImage() {
        PetStorage.getPetImageUrl(uri -> {
            // 외부 라이브러리 Glide를 사용해서 Firebase PetStorage의 이미지 로딩
            Glide.with(this)
                    .load(uri)
                    .addListener(getRequestListener())
                    .into(petImage);
        }, exception -> {
            petImage.setImageDrawable(ResourcesCompat.getDrawable(this.getResources(), R.drawable.dog, this.getTheme()));
            progressBar.setVisibility(View.GONE);
        });
    }

    private RequestListener<Drawable> getRequestListener() {
        return new RequestListener<Drawable>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target,
                                        boolean isFirstResource) {
                return false;
            }

            @Override
            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target,
                                           DataSource dataSource, boolean isFirstResource) {
                progressBar.setVisibility(View.GONE);
                return false;
            }
        };
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgBtn1:
                Intent intent1 = new Intent(Pet_Main.this, Register_Food.class);
                startActivity(intent1);
                break;
            case R.id.imgBtn2:
                Intent intent2 = new Intent(Pet_Main.this, Register_Snack.class);
                startActivity(intent2);
                break;
            case R.id.imgBtn3:
                Intent intent3 = new Intent(Pet_Main.this, Register_Run.class);
                startActivity(intent3);
                break;
            case R.id.imgBtn4:
                Intent intent4 = new Intent(Pet_Main.this, Register_Health.class);
                startActivity(intent4);
                break;
            default: break;
        }

    }
}