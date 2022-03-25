package com.example.weav;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SelectionActivity extends AppCompatActivity {
    Boolean isBirdChosen = true;
    Boolean isBranch1 = true;
    Boolean isBranch2 = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        getWindow().getDecorView().setSystemUiVisibility(uiOptions);
    }

    public void changeBirdState(View view) {

        ImageView img = findViewById(R.id.birdImg1);

        if(img.getTag().equals("unChosen")){
            isBirdChosen = true;
            img.setTag("chosen");
            img.setAlpha(1f);
        }else{
            isBirdChosen = false;
            img.setTag("unChosen");
            img.setAlpha(0.6f);
        }

        ImageView bt = findViewById(R.id.selectBt);
        changeBtState(bt);
    }

    public void changeBranch1State(View view) {

        ImageView img = findViewById(R.id.branch11);

        if (img.getTag().equals("unChosen")) {
            isBranch1 = true;
            img.setTag("chosen");
            img.setAlpha(1f);
        } else {
            isBranch1 = false;
            img.setTag("unChosen");
            img.setAlpha(0.4f);
        }

        ImageView bt = findViewById(R.id.selectBt);
        changeBtState(bt);
    }

    public void changeBranch2State(View view) {

        ImageView img = findViewById(R.id.branch21);

        if (img.getTag().equals("unChosen")) {
            isBranch2 = true;
            img.setTag("chosen");
            img.setAlpha(1f);
        } else {
            isBranch2 = false;
            img.setTag("unChosen");
            img.setAlpha(0.4f);
        }

        ImageView bt = findViewById(R.id.selectBt);
        changeBtState(bt);
    }

    public void changeBtState(View view) {
        ImageView img = findViewById(R.id.selectBt);
        Boolean isChosen;

        if(isBirdChosen || isBranch1 || isBranch2){
            isChosen = true;
        } else
            isChosen = false;

        if (isChosen){
            img.setVisibility(View.VISIBLE);
        }else{
            img.setVisibility(View.INVISIBLE);
        }
    }
}