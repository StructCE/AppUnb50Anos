package gm.unb;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;

public class RU extends Activity{

	@Override
    public void onCreate(Bundle savedInstanceState)
    {
			//Doing he Instance
            super.onCreate(savedInstanceState);
            setContentView(R.layout.ru); 
            //Pega a informação do prédio
            final int info_predio = getIntent().getIntExtra("info_predio",1);
            final Button info = (Button) findViewById(R.id.info);
            final Button cardapio = (Button) findViewById(R.id.BotaoCardapio);
            final Button title = (Button) findViewById (R.id.title);
            final Button title2 = (Button) findViewById (R.id.title2);
            final String nome = getIntent().getStringExtra("nome");
            final RelativeLayout pavimentos = (RelativeLayout) findViewById (R.id.cardapio);
            //Animações do XML
            final Animation animDecelerate = AnimationUtils.loadAnimation(this, R.anim.decelerate);
            title.setBackgroundResource(R.drawable.bt_botoes2_anim);
            info.setBackgroundResource(R.drawable.bt_botoes_anim);
            title.setOnClickListener(new View.OnClickListener() {
    	        public void onClick(View conq) {   
    	        	pavimentos.setVisibility(View.VISIBLE);
    	        	pavimentos.startAnimation(animDecelerate);
    	        	info.setVisibility(View.VISIBLE);
    	        	info.startAnimation(animDecelerate);
    	        	title2.setText(nome);
    	        	title.setVisibility(View.GONE);
    	        	title2.setVisibility(View.VISIBLE);
    	        	}
           });
            info.setOnClickListener(new View.OnClickListener() {
    	        public void onClick(View conq) {   
    	        	startActivity(new Intent(RU.this, Saiba_Mais.class)
    	        	.putExtra("info_predio", info_predio));
    	        }
           });
            cardapio.setOnClickListener(new View.OnClickListener() {
    	        public void onClick(View conq) {   
    		        Intent browserFace = new Intent("android.intent.action.VIEW", Uri.parse("http://www.ru.unb.br/index.php?option=com_content&view=category&id=35&Itemid=53"));
    		        startActivity(browserFace);
    	        }
           });           
           
    }
    @Override  
    public boolean onKeyDown(int keyCode, KeyEvent event)  
    {  
        //replaces the default 'Back' button action  
        if(keyCode==KeyEvent.KEYCODE_BACK)  
        {  
            //do whatever you want the 'Back' button to do  
            //as an example the 'Back' button is set to start a new Activity named 'NewActivity'  
            finish();
        	this.startActivity(new Intent(RU.this,Conquistas.class));
        	overridePendingTransition(R.anim.move_up, 0);
        }  
        return true;  
    }
}
