package me.sudar.anime;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by sudar on 20/2/16.
 */
public class CarAnimation extends View {

    int x = 50;
    private int xVelocity = 5;

    private Paint carPaint;
    private Paint carWheelPaint;


    public CarAnimation(Context context, AttributeSet attributeSet) {
        super(context);

        TypedArray a = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.CarAnimationAttrs,0, 0);
        int carColor = a.getInt(R.styleable.CarAnimationAttrs_carColor, 0);
        int carWheelColor = a.getInt(R.styleable.CarAnimationAttrs_carWheelColor, 0);

        carPaint = new Paint();
        carPaint.setAntiAlias(true);
        carPaint.setStyle(Paint.Style.FILL);
        carPaint.setColor(carColor);

        carWheelPaint = new Paint();
        carWheelPaint.setAntiAlias(true);
        carWheelPaint.setStyle(Paint.Style.FILL);
        carWheelPaint.setColor(carWheelColor);

        a.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (x<0) {
            x = 50;
        } else {
            x += xVelocity;
            if ((x > this.getWidth() - 300 )|| (x < 0)) {
                xVelocity = xVelocity*-1;
            }
        }

        canvas.drawRect(x,75,x+300,200,carPaint);
        canvas.drawCircle(x+75, 200, 25, carWheelPaint);
        canvas.drawCircle(x+225, 200, 25, carWheelPaint);

        invalidate();

    }


}
