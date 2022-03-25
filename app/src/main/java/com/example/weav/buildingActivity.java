package com.example.weav;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

public class buildingActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_building);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        getWindow().getDecorView().setSystemUiVisibility(uiOptions);

        Handler h = new Handler();

        h.postDelayed(new Runnable() {
            public void run() {
                ConstraintLayout root = findViewById(R.id.previewPage);
                goToSucceedPage(root);
            }
        }, 8000);

    }

    public void goToSucceedPage(View view) {

        Intent getIntent = getIntent();
        String userName = getIntent.getStringExtra("userName");
        String fileName = getIntent.getStringExtra("fileName");

        Intent intent = new Intent(this, succeedActivity.class);
        intent.putExtra("userName", userName);
        intent.putExtra("fileName", fileName);

        startActivity(intent);
    }
}