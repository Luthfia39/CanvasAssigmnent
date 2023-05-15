package com.example.canvasassigmnent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Canvas mCanvas;
    private Paint mPaint = new Paint();
    private Bitmap mBitmap;
    private ImageView mImageView;
    private int items = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = findViewById(R.id.imageView);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawPizza(v);
            }
        });
    }

    private void drawPizza(View v) {
        int vWidth = v.getWidth();
        int vHeight = v.getHeight();
        int halfWidth = vWidth/2;
        int halfHeight = vHeight/2;
        int radius_pizza = halfWidth-20;
        int radius_sauce = radius_pizza-100;
        int radius_cheese = radius_sauce-70;

        if (items == 0) {
            mBitmap = Bitmap.createBitmap(vWidth, vHeight, Bitmap.Config.ARGB_8888);
            mImageView.setImageBitmap(mBitmap);
            mCanvas = new Canvas(mBitmap);
        }else if(items == 1){
            // shadow
            mPaint.setColor(ResourcesCompat.getColor(getResources(), R.color.pizza_shadow,
                    null));
            mCanvas.drawCircle(halfWidth + 10, halfHeight + 30, radius_pizza, mPaint);

            // outline
            mPaint.setColor(ResourcesCompat.getColor(getResources(), R.color.outline,
                    null));
            mCanvas.drawCircle(halfWidth, halfHeight, radius_pizza, mPaint);

            // dough shadow
            mPaint.setColor(ResourcesCompat.getColor(getResources(), R.color.shadow1,
                    null));
            mCanvas.drawCircle(halfWidth, halfHeight, radius_pizza - 10, mPaint);

            // dough
            mPaint.setColor(ResourcesCompat.getColor(getResources(), R.color.dough,
                    null));
            mCanvas.drawCircle(halfWidth, halfHeight, radius_pizza - 30, mPaint);

            // sauce
            mPaint.setColor(ResourcesCompat.getColor(getResources(), R.color.outline,
                    null));
            mCanvas.drawCircle(halfWidth, halfHeight, radius_sauce, mPaint);
            mPaint.setColor(ResourcesCompat.getColor(getResources(), R.color.sauce,
                    null));
            mCanvas.drawCircle(halfWidth, halfHeight, radius_sauce - 30, mPaint);

            // cheese
            mPaint.setColor(ResourcesCompat.getColor(getResources(), R.color.cheese,
                    null));
            mCanvas.drawCircle(halfWidth, halfHeight, radius_cheese, mPaint);
        }else if(items == 2){
            // pepperoni
            mPaint.setColor(ResourcesCompat.getColor(getResources(), R.color.pepperoni,
                    null));
            mCanvas.drawCircle(halfWidth + 50, halfHeight - 220, 60,
                    mPaint); // center-top
        }else if(items == 3){
            mCanvas.drawCircle(halfWidth + 250, halfHeight - 20, 60,
                    mPaint); // center-right
        }else if(items == 4){
            mCanvas.drawCircle(halfWidth + 110, halfHeight + 90, 60,
                    mPaint); // right-center-bottom
        }else if(items == 5){
            mCanvas.drawCircle(halfWidth - 50, halfHeight + 230, 60,
                    mPaint); // center-bottom
        }else if (items == 6){
            mCanvas.drawCircle(halfWidth - 200, halfHeight + 100, 60,
                    mPaint); // left-center-bottom
        }else if(items == 7) {
            mCanvas.drawCircle(halfWidth - 170, halfHeight - 100, 60,
                    mPaint); // left-center-top
        }else if(items == 8){
            mCanvas.drawCircle(halfWidth, halfHeight - 50, 60,
                    mPaint); // center
        }
        else if(items == 9) {
            // basil
            mPaint.setColor(ResourcesCompat.getColor(getResources(), R.color.basil,
                    null));
            mCanvas.drawOval(halfWidth - 80, halfHeight + 100, halfWidth - 40,
                    halfHeight + 40, mPaint); // center-bottom
        }else if(items == 10) {
            mCanvas.drawOval(halfWidth + 120, halfHeight - 90, halfWidth + 160,
                    halfHeight - 150, mPaint); // right-top
        }else if(items == 11) {
            mCanvas.drawOval(halfWidth + 80, halfHeight + 190, halfWidth + 120,
                    halfHeight + 250, mPaint); // right-bottom
        }else if(items == 12) {
            mCanvas.drawOval(halfWidth - 210, halfHeight + 200, halfWidth - 170,
                    halfHeight + 260, mPaint); // left-bottom
        }else if(items == 13) {
            mCanvas.drawOval(halfWidth - 80, halfHeight - 200, halfWidth - 40,
                    halfHeight - 140, mPaint); // center-top
        }else {
            mCanvas.drawOval(halfWidth - 250, halfHeight - 30, halfWidth - 210,
                    halfHeight + 30, mPaint); // left-top
            items = 0;
        }
        items += 1;
        v.invalidate();
    }
}

// pepperoni pizza : saus tomat, pepperoni, daun basil, mozzarella,