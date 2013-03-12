package struct.guia.mochileiro;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

//Conquistas
public class Conquistas extends Activity {
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
		
    	//Mostrar tela
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conq);
        Button achiviment1 = (Button) findViewById (R.id.achiviment1);
        achiviment1.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View conq) {   
	        	finish();
	        	startActivity(new Intent(Conquistas.this, RU.class)
	        	.putExtra("nome","RU")
	        	.putExtra("info_predio", 16));
	        }
       });
        Button achiviment2 = (Button) findViewById (R.id.achiviment2);
        achiviment2.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View conq) {   
	        	finish();
	        	startActivity(new Intent(Conquistas.this, Busca_Dep.class));
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
        	this.startActivity(new Intent(Conquistas.this,MainMenu.class));
        	overridePendingTransition(R.anim.move_up, 0);
        }  
        return true;  
    }
}
