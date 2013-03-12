package struct.guia.mochileiro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


public class SplashScreen extends Activity implements Runnable{

    @Override
    public void onCreate(Bundle savedInstanceState) {
    	//Mostrar Splash Screen
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        
        
        //Segurar por 3 segundos
		Handler h = new Handler();
		h.postDelayed(this, 2000);
	}
	
	public void run()
	{
		//Finalizando atividade
		finish();
		onDestroy();
		
		//Iniciando próxima atividade
		startActivity(new Intent(this, MainMenu.class));
		
		//Efeito de Transição
		overridePendingTransition(R.anim.fade_out, R.anim.fade_in);
	}

}
