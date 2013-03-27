package gm.unb;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;

//Menu Principal
public class MainMenu extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
    	//Mostrar tela
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        
        
        //Botão Creditos
        ImageButton btcred = (ImageButton) findViewById(R.id.main_bt_cred);
        btcred.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View cred) {
	        	finish();
	        	startActivity(new Intent(MainMenu.this, Creditos.class));
				
				//Efeito de Transição
				overridePendingTransition(R.anim.move_up, 0);
	        }
        });
        
        
        //Botão Conquistas
        ImageButton btconq = (ImageButton) findViewById(R.id.main_bt_conq);
        btconq.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View conq) {
	        	finish();
		        startActivity(new Intent(MainMenu.this, Conquistas.class));
				
				//Efeito de Transição
				overridePendingTransition(R.anim.move_down, 0);
	        }
        });
        
        //Botão Mapas
        ImageButton btmapa = (ImageButton) findViewById(R.id.main_bt_mapa);
        btmapa.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View mapa) {
	        	finish();
	        	startActivity(new Intent(MainMenu.this, MainMap.class));
				
				//Efeito de Transição
				overridePendingTransition(R.anim.move_left, 0);
	        }
        });
        
    }
}