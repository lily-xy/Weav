package com.example.weav;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class CameraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
    }

    public void onClickButtonGallery(View view) {

        Intent getIntent = getIntent();
        String userName = getIntent.getStringExtra("userName");

        Intent intentGallery = new Intent(this, GalleryActivity.class);
        intentGallery.putExtra("userName", userName);

        startActivity(intentGallery);
    }

    public void onClickChangeView(View view) {

        ConstraintLayout root = findViewById(R.id.takePhotoView);

        if(root.getBackground() == getDrawable(R.drawable.camerabg)){
            root.setBackgroundResource(R.drawable.selfimage2);
        }
        else {
            root.setBackgroundResource(R.drawable.camerabg);
        }
    }

}