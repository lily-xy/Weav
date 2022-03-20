package com.example.weav;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText inputName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }

    public void onClickButtonStart(View view) {

        inputName =(EditText) findViewById(R.id.editTextTextPersonName);
        String userName = inputName.getText().toString();

        if (userName.isEmpty()) {
            Toast.makeText(this, "Please input your name first", Toast.LENGTH_LONG).show();
            return;
        }
        inputName.setText("");

        Intent intent = new Intent(this, WelcomeActivity.class);
        intent.putExtra("userName", userName);
        startActivity(intent);
    }

}