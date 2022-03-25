package com.example.weav;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class HueActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hue);
    }

    public void onClickButtonDeal(View view) {

        Intent getIntent = getIntent();
        String userName = getIntent.getStringExtra("userName");

        Intent intent = new Intent(this, DealActivity.class);
        intent.putExtra("userName", userName);

        startActivity(intent);
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

    public void hideBar(View view) {

        LinearLayout l1 = findViewById(R.id.layout_levelBg);
        LinearLayout l2 = findViewById(R.id.layout_levelBt);

        l1.setTag("inVisible");
        l2.setTag("inVisible");

        l1.setVisibility(View.VISIBLE);
        l2.setVisibility(View.VISIBLE);
    }
}