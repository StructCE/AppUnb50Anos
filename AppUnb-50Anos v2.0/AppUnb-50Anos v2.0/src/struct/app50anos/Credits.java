package struct.app50anos;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;

public class Credits extends Activity {
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
		
    	//Mostrar tela
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cred);
        
        
        //Botão do Face
        ImageButton btface = (ImageButton) findViewById(R.id.bt_face);
        btface.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View v) {
		        Intent browserFace = new Intent("android.intent.action.VIEW", Uri.parse("http://www.facebook.com/structunb"));
		        startActivity(browserFace);
	        }

        });
        
        
        //Botão do Twitter
        ImageButton btunb = (ImageButton) findViewById(R.id.bt_twitter);
        btunb.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View v) {
		        Intent browserUnb = new Intent("android.intent.action.VIEW", Uri.parse("http://www.twitter.com/structunb"));
		        startActivity(browserUnb);
	        }

        });
	}
    //Resolve Memory Leak App
    //Override the onKeyDown method  
    @Override  
    public boolean onKeyDown(int keyCode, KeyEvent event)  
    {  
        //replaces the default 'Back' button action  
        if(keyCode==KeyEvent.KEYCODE_BACK)  
        {  
            //do whatever you want the 'Back' button to do  
            //as an example the 'Back' button is set to start a new Activity named 'NewActivity'  
            finish();
        	this.startActivity(new Intent(Credits.this,MainMenu.class));
        	overridePendingTransition(R.anim.move_down, 0);
        }  
        return true;  
    }
}
