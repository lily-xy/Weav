package com.example.weav;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class previewActivity extends AppCompatActivity {

    private TextView fileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        getWindow().getDecorView().setSystemUiVisibility(uiOptions);

        fileName = findViewById(R.id.fileName);
        Intent getIntent = getIntent();
        String name = getIntent.getStringExtra("fileName");
        fileName.setText(name);
    }

    public void onClickCheck(View view) {
        ImageView checkBox = findViewById(R.id.checkbox);

        if(checkBox.getTag().equals("unChecked")){
            checkBox.setTag("checked");
            checkBox.setImageResource(R.drawable.connected);
        }else{
            checkBox.setTag("unChecked");
            checkBox.setImageResource(R.drawable.check);
        }
    }

    public void onClickButtonWelcome(View view) {

        Intent getIntent = getIntent();
        String userName = getIntent.getStringExtra("userName");

        Intent intent = new Intent(this, WelcomeActivity.class);
        intent.putExtra("userName", userName);

        startActivity(intent);
    }

    public void onClickButtonBuild(View view) {

        ImageView checkBox = findViewById(R.id.checkbox);

        if(!checkBox.getTag().equals("checked")){
            Toast.makeText(this, "Please check your 3D printer's connection first", Toast.LENGTH_LONG).show();
        } else{
            Intent getIntent = getIntent();
            String userName = getIntent.getStringExtra("userName");
            String fileName = getIntent.getStringExtra("fileName");

            Intent intent = new Intent(this, buildingActivity.class);
            intent.putExtra("userName", userName);
            intent.putExtra("fileName", fileName);

            startActivity(intent);
        }

    }
}