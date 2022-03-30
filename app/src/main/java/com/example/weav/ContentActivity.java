package com.example.weav;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ContentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        getWindow().getDecorView().setSystemUiVisibility(uiOptions);
    }

    public void cleanChosen(View view) {
        ImageView img1 = findViewById(R.id.bt1);
        ImageView img2 = findViewById(R.id.bt2);
        ImageView img3 = findViewById(R.id.bt3);
        ImageView bt1 = findViewById(R.id.symmetric1);
        ImageView bt2 = findViewById(R.id.symmetric2);

        if (img1.getTag() == "chosen"){
            img1.setImageResource(R.drawable.crop);
            img1.setTag("unChosen");
        }

        if (img2.getTag() == "chosen"){
            img2.setImageResource(R.drawable.eraser);
            img2.setTag("unChosen");
        }

        if (img3.getTag() == "chosen"){
            img3.setImageResource(R.drawable.draw);
            img3.setTag("unChosen");
        }

        bt1.setVisibility(View.VISIBLE);
        bt2.setVisibility(View.VISIBLE);
    }

    public void choseCrop(View view){
        ImageView img = findViewById(R.id.bt1);
        ImageView imgMain = findViewById(R.id.imageMain);
        ImageView bt1 = findViewById(R.id.symmetric1);
        ImageView bt2 = findViewById(R.id.symmetric2);

        cleanChosen(view);
        img.setImageResource(R.drawable.crop_chosen);
        img.setTag("chosen");

        imgMain.setImageResource(R.drawable.degree);
        bt1.setImageResource(R.drawable.symmetric1);
        bt2.setImageResource(R.drawable.symmetric2);
    }

    public void choseEraser(View view){
        ImageView img = findViewById(R.id.bt2);
        ImageView imgMain = findViewById(R.id.imageMain);
        ImageView bt1 = findViewById(R.id.symmetric1);
        ImageView bt2 = findViewById(R.id.symmetric2);

        cleanChosen(view);
        img.setImageResource(R.drawable.eraser_chosen);
        img.setTag("chosen");

        imgMain.setImageResource(R.drawable.penbold);
        bt1.setImageResource(R.drawable.pen);
        bt2.setVisibility(View.INVISIBLE);
    }

    public void choseWrite(View view){
        ImageView img = findViewById(R.id.bt3);
        ImageView imgMain = findViewById(R.id.imageMain);
        ImageView bt1 = findViewById(R.id.symmetric1);
        ImageView bt2 = findViewById(R.id.symmetric2);

        cleanChosen(view);
        img.setImageResource(R.drawable.draw_chosen);
        img.setTag("chosen");

        imgMain.setImageResource(R.drawable.penbold);
        bt1.setImageResource(R.drawable.pen);
        bt2.setVisibility(View.INVISIBLE);
    }

    public void onClickButtonDeal(View view) {

        Intent getIntent = getIntent();
        String userName = getIntent.getStringExtra("userName");

        Intent intent = new Intent(this, DealActivity.class);
        intent.putExtra("userName", userName);

        startActivity(intent);
    }

}