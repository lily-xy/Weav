package com.example.weav;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

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

    public void onClickColorTypeChanged(View view) {

        LinearLayout l1 = findViewById(R.id.layout_levelBg);
        LinearLayout l2 = findViewById(R.id.layout_levelBt);

        if(l1.getTag().equals("visible") && l2.getTag().equals("visible")){
            ImageView bt = findViewById(R.id.bibt);
            ImageView state1 = findViewById(R.id.state1_white);
            LinearLayout state2 = findViewById(R.id.state2);
            TextView t1 = findViewById(R.id.colorBlock1);
            TextView t2 = findViewById(R.id.colorBlock2);

            t2.setVisibility(View.VISIBLE);

            if(bt.getTag().equals("B")){
                bt.setImageResource(R.drawable.monobt);
                bt.setTag("M");

                state2.setVisibility(View.INVISIBLE);
                state1.setVisibility(View.VISIBLE);

                t1.setText("#FFFFFF");
                t2.setVisibility(View.INVISIBLE);
            } else {
                bt.setImageResource(R.drawable.bibt);
                bt.setTag("B");

                state2.setVisibility(View.VISIBLE);
                state1.setVisibility(View.INVISIBLE);

                t1.setText("#FFFFFF");
                t2.setText("#C73B22");
            }

            LinearLayout state3 = findViewById(R.id.state3);
            state3.setVisibility(View.INVISIBLE);
        }
    }
}