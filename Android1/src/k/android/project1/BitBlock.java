package k.android.project1;

import java.util.Random;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BitBlock{
	public Bitmap bitmap;
	public float x, y;
	public float dx, dy;
	public float w, h;
	public float minX, maxX, minY, maxY;
	public Random gen;
	
	public BitBlock(){
		bitmap = null;
		x = y = dx = dy = w = h = minX = minY = maxX = maxY = 0;
		gen = new Random();
	}
	
	public void load(Resources R, int id){
		bitmap = BitmapFactory.decodeResource(R, id);
		w = bitmap.getWidth();
		h = bitmap.getHeight();
	}
	
	public void advance(){
		if(x > maxX || x < minX || y > maxY || y < minY){
			x = 50;
			y = 50;
			return;
		}
		
		x += dx;
		y += dy;
		
		// For the case of too far in X
		if(x > maxX - w){
			float devX = x - (maxX - w);
			x = (maxX - w) - devX;
			if(gen.nextBoolean())
				dx += gen.nextFloat();
			else
				dx += -1 * gen.nextFloat();
			dx = -1 * Math.abs(dx);
		}
		
		// For the case of too little in X
		if(x < minX){
			float devX = minX - x;
			x = minX + devX;
			if(gen.nextBoolean())
				dx += gen.nextFloat();
			else
				dx += -1 * gen.nextFloat();
			dx = Math.abs(dx);
		}
		
		// For the case of too far in Y
		if(y > maxY - h){
			float devY = y - (maxY - h);
			y = (maxY - h) - devY;
			if(gen.nextBoolean())
				dy += gen.nextFloat();
			else
				dy += -1 * gen.nextFloat();
			dy = -1 * Math.abs(dy);
		}
		
		// For the case of too little in Y
		if(y < minY){
			float devY = minY - y;
			y = minY + devY;
			if(gen.nextBoolean())
				dy += gen.nextFloat();
			else
				dy += -1 * gen.nextFloat();
			dy = Math.abs(dy);
		}
	}
}
