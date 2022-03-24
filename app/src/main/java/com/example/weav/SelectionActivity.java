package com.example.weav;

import androidx.appcompat.app.AppCompatActivity;

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
            img.setAlpha(0.6f);
        }
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
            img.setAlpha(0.6f);
        }
    }

}