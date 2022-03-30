package com.example.weav;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PersonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);

        Intent getIntent = getIntent();
        if(!getIntent.getStringExtra("message").isEmpty()){
            String message = getIntent.getStringExtra("message");

            if(message.equals("succeed")){
                ImageView img = findViewById(R.id.f2_2_Img);
                TextView t = findViewById(R.id.f2_2_Name);

                img.setImageResource(R.drawable.bird_paint);

                if(!getIntent.getStringExtra("fileName").isEmpty())
                t.setText(getIntent.getStringExtra("fileName"));
            }
        }

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