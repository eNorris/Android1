package k.android.project1;

import android.app.Activity;
import android.os.Bundle;

public class CoreAndroid1Activity extends Activity{
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		CanvasView c = new CanvasView(this);
		setContentView(c);
	}
}
