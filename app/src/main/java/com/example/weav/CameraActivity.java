package com.example.weav;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class CameraActivity extends AppCompatActivity {

    Boolean isFront = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

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

        Intent intentGallery = new Intent(this, GalleryActivity.class);
        intentGallery.putExtra("userName", userName);

        startActivity(intentGallery);
    }

    public void onClickChangeView(View view) {

        ConstraintLayout img = findViewById(R.id.takePhotoView);

//        ConstraintLayout img = findViewById(R.id.bg);

        if(img.getTag().equals("back")){
            isFront = true;
            img.setTag("front");
            img.setBackgroundResource(R.drawable.selfimage2);
        }else{
            isFront = false;
            img.setTag("back");
            img.setBackgroundResource(R.drawable.camerabg);
        }
    }

}