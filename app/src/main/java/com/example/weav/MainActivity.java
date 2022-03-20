package com.example.weav;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText inputName;
    private EditText inputPsw;

    public class sTriangle {
        public float speedX = 0;
        public float speedY = 0;
        private float locX;
        private float locY;

        Paint paint;
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.triangle1);

        public sTriangle() {
            this.paint = new Paint();
        }

        public float getlocX() {
            return locX;
        }

        public void setlocX(float locX) {
            this.locX = locX;
        }

        public float getlocY() {
            return locY;
        }

        public void setlocY(float locY) {
            this.locY = locY;
        }

    }

    public class hTriangle {
        public float speedX = 0;
        public float speedY = 0;
        private float locX;
        private float locY;

        Paint paint;
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.triangle2);

        public hTriangle() {
            this.paint = new Paint();
        }

        public float getlocX() {
            return locX;
        }

        public void setlocX(float locX) {
            this.locX = locX;
        }

        public float getlocY() {
            return locY;
        }

        public void setlocY(float locY) {
            this.locY = locY;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        getWindow().getDecorView().setSystemUiVisibility(uiOptions);
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