package com.example.weav;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.opengl.Visibility;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class DetailDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_data);
    }

    public void showBar(View view) {

        LinearLayout l1 = findViewById(R.id.layout_levelBg);
        LinearLayout l2 = findViewById(R.id.layout_levelBt);


        if(l1.getTag().equals("inVisible") && l2.getTag().equals("inVisible")){

            l1.setTag("visible");
            l2.setTag("visible");

            l1.setVisibility(View.VISIBLE);
            l2.setVisibility(View.VISIBLE);
        }
    }
}