package com.example.weav;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class GalleryActivity extends AppCompatActivity {

    Boolean isChoseImg = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        getWindow().getDecorView().setSystemUiVisibility(uiOptions);

    }

    public void onClickButtonTakePhoto(View view) {

        Intent getIntent = getIntent();
        String userName = getIntent.getStringExtra("userName");

        Intent intentCamera = new Intent(this, CameraActivity.class);
        intentCamera.putExtra("userName", userName);

        startActivity(intentCamera);
    }

    public void onClickButtonWelcomePage(View view) {

        Intent getIntent = getIntent();
        String userName = getIntent.getStringExtra("userName");

        Intent intent = new Intent(this, WelcomeActivity.class);
        intent.putExtra("userName", userName);

        startActivity(intent);
    }

    public void changeImageState(View view) {

        ImageView img = findViewById(R.id.bird_Img);

        if(img.getTag().equals("unChosen")){
            isChoseImg = true;
            img.setTag("chosen");
            img.setImageResource(R.drawable.chosenbird);
        }else{
            isChoseImg = false;
            img.setTag("unChosen");
            img.setImageResource(R.drawable.first_2);
        }

    }

}