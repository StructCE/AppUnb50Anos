package struct.app50anos;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

public class StartActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        
    }
    
    public void run()
    {
    	//Finish
    	finish();
    	onDestroy();
    	
    	startActivity(new Intent(this, Loading.class));
    }

}
