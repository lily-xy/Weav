package com.example.weav;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private EditText inputName;
    private EditText inputPsw;
    sTriangle[] sTriangles;
    hTriangle[] hTriangles;
    Random random = new Random();

    public class sTriangle {
        public float speedX = 0;
        public float speedY = 0;
        private double locX;
        private double locY;
        private int radius;
        private double randomX;
        private double randomY;

        Paint paint;
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.triangle1);

        public sTriangle() {
            this.paint = new Paint();
            this.randomX = (double)(random.nextInt(10));
            this.randomY = (double)(random.nextInt(30));
            this.radius = random.nextInt(10) + 5;
        }

        public double getlocX() {
            return locX;
        }

        public void setlocX(double locX) {
            this.locX = locX;
        }

        public double getlocY() {
            return locY;
        }

        public void setlocY(double locY) {
            this.locY = locY;
        }

    }

    public class hTriangle {
        public float speedX = 0;
        public float speedY = 0;
        private double locX;
        private double locY;
        private int radius;
        private double randomX;
        private double randomY;

        Paint paint;
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.triangle2);

        public hTriangle() {
            this.paint = new Paint();
            this.randomX = (double)(random.nextInt(10));
            this.randomY = (double)(random.nextInt(30));
            this.radius = random.nextInt(40) + 20;
        }

        public double getlocX() {
            return locX;
        }

        public void setlocX(double locX) {
            this.locX = locX;
        }

        public double getlocY() {
            return locY;
        }

        public void setlocY(double locY) {
            this.locY = locY;
        }

    }

    public class GraphicsView extends View {

        public GraphicsView(Context context) {
            super(context);
            sTriangles = new sTriangle[5];
            hTriangles = new hTriangle[2];
        }

        public void onDraw(Canvas canvas) {

            super.onDraw(canvas);

           for(int i = 0; i < sTriangles.length; i++){
                Bitmap bitmapST = sTriangles[i].bitmap;
                sTriangles[i].locX = getWidth() / 10 * sTriangles[i].randomX;
                sTriangles[i].locY = getHeight() / 30 *  sTriangles[i].randomY;

                Rect sTDstRect = new Rect((int)( sTriangles[i].locX -  sTriangles[i].radius), (int)( sTriangles[i].locY -  sTriangles[i].radius), (int)( sTriangles[i].locX +  sTriangles[i].radius), (int)( sTriangles[i].locY +  sTriangles[i].radius));
                canvas.drawBitmap(bitmapST, null, sTDstRect,  sTriangles[i].paint);
            }

            for(int j = 0; j < hTriangles.length; j++){
                Bitmap bitmapHT = hTriangles[j].bitmap;
                hTriangles[j].locX = getWidth() / 10 * hTriangles[j].randomX;
                hTriangles[j].locY = getHeight() / 30 *  hTriangles[j].randomY;

                Rect hTDstRect = new Rect((int)( hTriangles[j].locX -  hTriangles[j].radius), (int)( hTriangles[j].locY -  hTriangles[j].radius), (int)( hTriangles[j].locX +  hTriangles[j].radius), (int)( hTriangles[j].locY +  hTriangles[j].radius));
                canvas.drawBitmap(bitmapHT, null, hTDstRect,  hTriangles[j].paint);
            }

            invalidate();
        }

    }


        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConstraintLayout root = findViewById(R.id.SignInView);
        GraphicsView trianglesView = new GraphicsView(this);
        root.addView(trianglesView);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        getWindow().getDecorView().setSystemUiVisibility(uiOptions);

        for (int i = 0; i < sTriangles.length; i++) {
            sTriangles[i] = new sTriangle();
        }
        for (int j = 0; j < hTriangles.length; j++) {
            hTriangles[j] = new hTriangle();
        }
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