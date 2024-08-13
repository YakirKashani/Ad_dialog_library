package com.example.myads;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.adlibrary.AdAnimation;
import com.example.adlibrary.AdDialog;
import com.google.android.material.button.MaterialButton;

public class SecondActivity extends AppCompatActivity {
    private MaterialButton SecondActivity_MB_switchActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        findViews();
        initViews();
    }

    private void findViews(){
        SecondActivity_MB_switchActivity = findViewById(R.id.SecondActivity_MB_switchActivity);
    }

    private void initViews(){
        SecondActivity_MB_switchActivity.setOnClickListener(v -> {
            Intent intent = new Intent(SecondActivity.this,MainActivity.class);
            AdDialog.showDialog(SecondActivity.this,intent,5,R.drawable.golf_ad, AdAnimation.RESIZE_TO_FULL,"https://www.golfco.co.il/");
        });
    }

}