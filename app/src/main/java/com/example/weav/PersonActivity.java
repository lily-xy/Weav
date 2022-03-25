package com.example.weav;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class PersonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);
    }

    public void onClickButtonWelcome(View view) {

        Intent getIntent = getIntent();
        String userName = getIntent.getStringExtra("userName");

        Intent intent = new Intent(this, WelcomeActivity.class);
        intent.putExtra("userName", userName);

        startActivity(intent);
    }

    public void onClickButtonMain(View view) {

        Intent getIntent = getIntent();
        String userName = getIntent.getStringExtra("userName");

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("userName", userName);

        startActivity(intent);
    }

    public void onClickButtonQuit(View view) {

        ConstraintLayout root = findViewById(R.id.personView);

        new AlertDialog.Builder(
                PersonActivity.this)
                .setMessage("Are you sure to sign out?")
                .setPositiveButton("Sure", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        onClickButtonMain(root);
                    }
                })
                .setNegativeButton("Cancel", null)
                .show();
    }
}