package corp.juhnjg.appborninhollyscoffee;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.view.View;

public class LinedEditText extends AppCompatEditText {

    private Rect mRect;
    private Paint mPaint;
    private int mHeight;
    private int mLineHeight;

    public LinedEditText(Context context, AttributeSet attrs) {
        super(context, attrs);

        mRect = new Rect();
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(2);
        mPaint.setColor(Color.parseColor("#117A65"));
        mLineHeight = getLineHeight(); //무엇인가? 각 라인 사이의 길이이다.
    }

    @Override
    protected void onDraw(Canvas canvas) {

        mHeight = ((View)this.getParent()).getHeight(); //전체 길이를 구한다.

        int numberOfLines = mHeight / mLineHeight;
        Rect r = mRect;
        Paint paint = mPaint;

        int baseLine = getLineBounds(0,r);

        for (int i = 0; i < numberOfLines; i++) {
            canvas.drawLine(r.left,baseLine+1,r.right, baseLine+1,paint);
            baseLine += mLineHeight;
        }

        super.onDraw(canvas);
    }
}
