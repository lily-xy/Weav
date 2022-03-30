package com.example.weav;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class succeedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_succeed);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        getWindow().getDecorView().setSystemUiVisibility(uiOptions);
    }

    public void onClickButtonGallery(View view) {

            Intent getIntent = getIntent();
            String userName = getIntent.getStringExtra("userName");

            Intent intent = new Intent(this, GalleryActivity.class);
            intent.putExtra("userName", userName);

            startActivity(intent);
    }

    public void onClickButtonPerson(View view) {

        Intent getIntent = getIntent();
        String userName = getIntent.getStringExtra("userName");
        String fileName = getIntent.getStringExtra("fileName");
        String message = "succeed";

        Intent intent = new Intent(this, PersonActivity.class);
        intent.putExtra("userName", userName);
        intent.putExtra("fileName", fileName);
        intent.putExtra("succeed", message);

        startActivity(intent);
    }
}