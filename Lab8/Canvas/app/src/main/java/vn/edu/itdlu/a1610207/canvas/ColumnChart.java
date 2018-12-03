package vn.edu.itdlu.a1610207.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

public class ColumnChart extends View {

    Paint paint = new Paint();
    float[] data = {450, 1230, 200, 400, 520};

    public ColumnChart(Context context) {
        super(context);
    }

    public ColumnChart(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.parseColor("#d3e2d7"));
        canvas.drawPaint(paint);
        int length = data.length;
        for (int i = 0; i < length; i++) {
            float width = getWidth() / length * i;
            DrawColumn(canvas, width, GetHeightBaseValue(data[i]), getRandomColor());
        }
    }

    void DrawColumn(Canvas canvas, float x, float height, int color) {
        float y = getHeight() - height;
        float w = getWidth() / 6;
        paint.setColor(color);
        canvas.drawRect(x, y, x + w, getBottom(), paint);
    }

    float GetHeightBaseValue(float value) {
        float max = 0;
        int length = data.length;
        for (int i = 0; i < length; i++)
            if (max < data[i])
                max = data[i];
        return value / max * 80 / 100 * getHeight();
    }

    int getRandomColor() {
        Random random = new Random();
        return Color.argb(random.nextInt(255), random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }

}
