package struct.app50anos;

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
                
    }
	public void run()
	{
        //Botão Creditos
        ImageButton btcred = (ImageButton) findViewById(R.id.bt_cred);
        //Botão Conquistas
        ImageButton btconq = (ImageButton) findViewById(R.id.bt_conq);
        //Botão Mapas
        ImageButton btmapa = (ImageButton) findViewById(R.id.bt_mapa);
        
        btcred.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View cred) {
	        	//finalizando atividade 
	        	finish();
	        	
	        	//startando a nova atividade
	        	startActivity(new Intent(MainMenu.this, Credits.class));
				
	        	//Efeito de Transição
				overridePendingTransition(R.anim.move_up, 0);
	        }
        });
        
        btconq.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View conq) {
	        	finish();
		        startActivity(new Intent(MainMenu.this, Achivments.class));
				
				//Efeito de Transição
				overridePendingTransition(R.anim.move_down, 0);
	        }
        });
        
        
        btmapa.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View mapa) {
	        	finish();
	        	startActivity(new Intent(MainMenu.this, AppBody.class));
				
				//Efeito de Transição
				overridePendingTransition(R.anim.move_left, 0);
	        }
        });

	}
}