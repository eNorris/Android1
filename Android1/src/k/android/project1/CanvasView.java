package k.android.project1;

import java.util.Random;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class CanvasView extends View{
	Random gen;
	private BitBlock bitblock;
	
	public CanvasView(Context context){
		super(context);
		setFocusable(true);
		
		bitblock = new BitBlock();
		bitblock.dx = 1;
		bitblock.dy = 2;
		bitblock.load(this.getResources(), R.drawable.testpic);

		gen = new Random();
	}
	
	@Override
	protected void onDraw(Canvas c){
		super.onDraw(c);
		super.invalidate();
		
		bitblock.minX = this.getX();
		bitblock.maxX = this.getX() + this.getWidth();
		bitblock.minY = this.getY();
		bitblock.maxY = this.getY() + this.getHeight();
		
		Paint paint = new Paint();
		paint.setStyle(Paint.Style.FILL);
		paint.setColor(Color.WHITE);
		c.drawPaint(paint);
		
		paint.setAntiAlias(true);
		paint.setColor(Color.RED);
		c.drawCircle(50, 50, 25, paint);
		
		paint.setStyle(Paint.Style.FILL);
		String phrase = new String("Test");
		
		phrase = "bitblock x: " + String.valueOf(bitblock.x);
		c.drawText(phrase, 20, 200, paint);
		
		phrase = "bitblock y: " + String.valueOf(bitblock.y);
		c.drawText(phrase, 20, 220, paint);
		
		phrase = "min x: " + String.valueOf(bitblock.minX);
		c.drawText(phrase, 20, 250, paint);
		
		phrase = "max x: " + String.valueOf(bitblock.maxX);
		c.drawText(phrase, 20, 270, paint);
		
		phrase = "min y: " + String.valueOf(bitblock.minY);
		c.drawText(phrase, 20, 290, paint);
		
		phrase = "max y: " + String.valueOf(bitblock.maxY);
		c.drawText(phrase, 20, 310, paint);
		
		bitblock.advance();

		c.drawBitmap(bitblock.bitmap, bitblock.x, bitblock.y, paint); 
	}
	
	public boolean onTouchEvent(MotionEvent event){
		bitblock.x = 50;
		bitblock.y = 50;
		return false;
	}
	
}



















