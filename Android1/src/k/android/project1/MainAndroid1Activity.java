package k.android.project1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainAndroid1Activity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        init();
    }
    
    public void init(){
    	Button startButton = (Button) findViewById(R.id.startButton_id);
    	startButton.setOnClickListener(new OnClickListener(){;
    		public void onClick(View v){
    			Intent inten = new Intent(v.getContext(), CoreAndroid1Activity.class);
    			startActivityForResult(inten, 0);
    		}
    	});
    }
}