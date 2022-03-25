package com.example.weav;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class getFilenameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_filename);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        getWindow().getDecorView().setSystemUiVisibility(uiOptions);
    }

    public void onClickButtonWelcome(View view) {

        Intent getIntent = getIntent();
        String userName = getIntent.getStringExtra("userName");

        Intent intent = new Intent(this, WelcomeActivity.class);
        intent.putExtra("userName", userName);

        startActivity(intent);
    }

    public void onClickButtonDeal(View view) {

       Intent getIntent = getIntent();
       String userName = getIntent.getStringExtra("userName");

       Intent intent = new Intent(this, DealActivity.class);
       intent.putExtra("userName", userName);

       startActivity(intent);
    }

    public void onClickButtonEdit(View view) {

        EditText inputName = findViewById(R.id.editTextTextFileName);
        ImageView bt = findViewById(R.id.button);
        String name = inputName.toString();

        if(!name.isEmpty()){
            bt.setVisibility(View.VISIBLE);
        }else
            bt.setVisibility(View.INVISIBLE);

    }

    public void onClickButtonPreview(View view) {

        Intent getIntent = getIntent();
        String userName = getIntent.getStringExtra("userName");

        Intent intent = new Intent(this, previewActivity.class);
        intent.putExtra("userName", userName);

        startActivity(intent);
    }
}