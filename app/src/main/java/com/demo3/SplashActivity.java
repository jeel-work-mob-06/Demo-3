package com.demo3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;

public class SplashActivity extends AppCompatActivity {

    ImageView image;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);

        sp = getSharedPreferences(ConstantSp.PREF,MODE_PRIVATE);

        image = findViewById(R.id.splash_img);
        Glide.with(SplashActivity.this).asGif().load("https://i.pinimg.com/originals/d7/b8/a1/d7b8a1ef2376e41a54c648350418bcd4.gif").placeholder(R.mipmap.ic_launcher).into(image);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (sp.getString(ConstantSp.UserId,"").equals("")){
                    Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Intent intent = new Intent(SplashActivity.this,ProfileActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        },3000);

    }
}