package com.example.weav;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

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
import android.widget.LinearLayout;
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
            this.randomX = (double)(random.nextInt(5));
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
            this.randomX = (double)(random.nextInt(5));
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
                Bitmap bitmapsT = sTriangles[i].bitmap;
                sTriangles[i].locX = getWidth() / 10 * (sTriangles[i].randomX + 1);
                sTriangles[i].locY = getHeight() / 5 *  sTriangles[i].randomY / 10;

                Rect stoneDstRect = new Rect((int)( sTriangles[i].locX -  sTriangles[i].radius), (int)( sTriangles[i].locY -  sTriangles[i].radius), (int)( sTriangles[i].locX +  sTriangles[i].radius), (int)( sTriangles[i].locY +  sTriangles[i].radius));
                canvas.drawBitmap(bitmapsT, null, stoneDstRect,  sTriangles[i].paint);
            }

            for(int i = 0; i < hTriangles.length; i++){
                Bitmap bitmaphT = hTriangles[i].bitmap;
                hTriangles[i].locX = getWidth() / 10 * (hTriangles[i].randomX + 1);
                hTriangles[i].locY = getHeight() / 5 *  hTriangles[i].randomY / 10;

                Rect hTDstRect = new Rect((int)( hTriangles[i].locX -  hTriangles[i].radius), (int)( hTriangles[i].locY -  hTriangles[i].radius), (int)( hTriangles[i].locX +  hTriangles[i].radius), (int)( hTriangles[i].locY +  hTriangles[i].radius));
                canvas.drawBitmap(bitmaphT, null, hTDstRect,  hTriangles[i].paint);
            }

            invalidate();
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