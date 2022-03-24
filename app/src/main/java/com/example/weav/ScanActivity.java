package com.example.weav;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.View;

public class ScanActivity extends AppCompatActivity {

    scanLine line;

    public class scanLine {
        int vX = 0;
        int vY = 20;
        private float locX;
        private float locY;

        Paint paint;
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.line);

        public scanLine() {
            this.paint = new Paint();
            locX = 85;
            locY = 200;
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

    public class GraphicsView extends View {

        public GraphicsView(Context context) {
            super(context);
            line = new scanLine();
        }


        public void isReach(){
            float reachHeight = getHeight()/6*5;

            if(line.getlocY() >= reachHeight)
                line.vY = -line.vY;

            if (line.getlocY() < 100)
                jumpNext(this);
            }

        public void onDraw(Canvas canvas) {

            super.onDraw(canvas);

            isReach();
            line.locY += line.vY;
            canvas.drawLine(line.getlocX(), line.getlocY(), getWidth() - line.getlocX(), line.getlocY()+10, line.paint);

            invalidate();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        ConstraintLayout root = findViewById(R.id.scanView);
        GraphicsView lineView = new GraphicsView(this);
        root.addView(lineView);

        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        getWindow().getDecorView().setSystemUiVisibility(uiOptions);

        line = new scanLine();
    }

    public void jumpNext(View view) {

        Intent getIntent = getIntent();
        String userName = getIntent.getStringExtra("userName");

        Intent intent = new Intent(this, DealActivity.class);
        intent.putExtra("userName", userName);

        startActivity(intent);
    }
}