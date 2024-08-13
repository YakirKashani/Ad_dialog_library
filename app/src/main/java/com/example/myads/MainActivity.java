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
import com.google.android.material.textview.MaterialTextView;

public class MainActivity extends AppCompatActivity {

    private MaterialButton MainActivity_MB_switchIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        initViews();
    }

    private void findViews(){
        MainActivity_MB_switchIntent = findViewById(R.id.MainActivity_MB_switchIntent);
    }

    private void initViews(){
        MainActivity_MB_switchIntent.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,SecondActivity.class);
            AdDialog.showDialog(MainActivity.this,intent,5,R.drawable.isrotel_ad, AdAnimation.RESIZE_TO_FULL,"https://www.isrotel.co.il");
        });
    }
}