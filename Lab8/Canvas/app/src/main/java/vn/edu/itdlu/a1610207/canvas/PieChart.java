package vn.edu.itdlu.a1610207.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

public class PieChart extends View {
    static final int STROKE_WIDTH = 20;
    float[] data = {450, 1230, 200, 400};
    Paint paint;
    RectF mRect;
    int centerX, centerY, radius;

    public PieChart(final Context context) {
        super(context);
    }

    public PieChart(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mRect == null) {
            centerX = getMeasuredWidth() / 2;
            centerY = getMeasuredHeight() / 2;
            radius = Math.min(centerX, centerY);
            int startTop = STROKE_WIDTH / 2;
            int startLeft = startTop;
            int endBottom = 2 * radius - startTop;
            int endRight = endBottom;
            mRect = new RectF(startTop, startLeft, endRight, endBottom);
        }
        float startingPoint = 0;
        for (int i = 0; i < data.length; i++) {
            changeColor(getRandomColor());
            canvas.drawArc(mRect, startingPoint, getScaleValue(i), true, paint);
            startingPoint += getScaleValue(i);
        }
    }

    float getScaleValue(int index) {
        float sum = 0;
        for (int i = 0; i < data.length; i++) {
            sum += data[i];
        }
        return data[index] / sum * 360;
    }

    void changeColor(int color) {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(color);
        paint.setStyle(Paint.Style.FILL);
    }

    int getRandomColor() {
        Random random = new Random();
        return Color.argb(random.nextInt(255), random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }
}