package vn.edu.itdlu.a1610207.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class SimpleExample extends View {
    public SimpleExample(final Context context) {
        super(context);
    }

    public SimpleExample(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int x = getWidth();
        int y = getHeight();
        int radius = 100;
        Paint paint = new Paint();
        //Tạo nền cho view
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.RED);
        canvas.drawPaint(paint);
        //Vẽ ngôi sao trên view
        int midX = x / 2;
        int midY = y / 2;
        paint.setColor(Color.YELLOW);
        canvas.drawLine(midX + 190, midY + 300, midX, midY + 210, paint);
        canvas.drawLine(midX, midY + 210, midX - 190, midY + 300, paint);
        canvas.drawLine(midX - 190, midY + 300, midX - 160, midY + 90, paint);
        canvas.drawLine(midX - 160, midY + 90, midX - 300, midY - 70, paint);
        canvas.drawLine(midX - 300, midY - 70, midX - 100, midY - 110, paint);
        canvas.drawLine(midX - 100, midY - 110, midX, midY - 300, paint);
        canvas.drawLine(midX, midY - 300, midX + 100, midY - 110, paint);
        canvas.drawLine(midX + 100, midY - 110, midX + 300, midY - 70, paint);
        canvas.drawLine(midX + 300, midY - 70, midX + 160, midY + 90, paint);
        canvas.drawLine(midX + 160, midY + 90, midX + 190, midY + 300, paint);
    }
}
