package com.example.weav;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText inputName;
    private EditText inputPsw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }

    public void onClickButtonStart(View view) {

        inputName =(EditText) findViewById(R.id.editTextTextPersonName);
        inputPsw = (EditText) findViewById(R.id.Password);
        String userName = inputName.getText().toString();
        String psw = inputPsw.getText().toString();


        if (userName.isEmpty()) {
            Toast.makeText(this, "Please input your name", Toast.LENGTH_LONG).show();
            return;
        } else if (psw.isEmpty()){
            Toast.makeText(this, "Please input your password", Toast.LENGTH_LONG).show();
            return;
        }
        inputName.setText("");
        inputPsw.setText("");

        Intent intent = new Intent(this, WelcomeActivity.class);
        intent.putExtra("userName", userName);
        startActivity(intent);
    }

}