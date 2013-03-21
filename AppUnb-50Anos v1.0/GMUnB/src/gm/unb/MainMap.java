package gm.unb;



import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;

//Menu Principal
public class MainMap extends Activity{
	
                //Valores para passar para o EspecificMap
				Bundle predio = new Bundle();
				int local = -1;
       
        @Override
        public void onCreate(Bundle savedInstanceState)
        {

                //Doing he Instance
                super.onCreate(savedInstanceState);
                setContentView(R.layout.mapa_principal);

                //ImageView mask = (ImageView) findViewById(R.id.campusmap)
                WebView view = (WebView) findViewById(R.id.campus);
                final StringBuilder s = new StringBuilder();    
                s.append("<html>");                             
                s.append("<body>");
                s.append("<img src=\"file:///android_asset/planta_geral_unb.png\" />");
                s.append("</body>");                            
                s.append("</html>");
        		view.loadDataWithBaseURL(null, s.toString(), "text/html", "UTF-8", null);
        		view.getSettings().setBuiltInZoomControls(true);
                
                
                Button indice = (Button) findViewById(R.id.indice);
                indice.setBackgroundResource(R.drawable.bt_botoes2_anim);
                indice.setOnClickListener(new View.OnClickListener() {
        	        public void onClick(View mapa) {
        		        finish();
        	        	startActivity(new Intent(MainMap.this, Indice.class));
        				//Efeito de Transição
        				overridePendingTransition(R.anim.move_left, 0);
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
            	this.startActivity(new Intent(MainMap.this,MainMenu.class));  
            }  
            return true;  
        }

}