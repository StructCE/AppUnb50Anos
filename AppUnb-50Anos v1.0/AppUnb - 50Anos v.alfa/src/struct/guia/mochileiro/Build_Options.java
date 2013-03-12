package struct.guia.mochileiro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.Button;
import android.widget.RelativeLayout;

public class Build_Options extends Activity {
	FrameLayout foto,planta;
	@Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //Pega o numero de pavimentos
        final int num_pavimentos = getIntent().getIntExtra("num_pavimentos",-1);
        //Pega a informação do prédio
        final int info_predio = getIntent().getIntExtra("info_predio",1);
        setContentView(R.layout.build_options);
        final Button info = (Button) findViewById(R.id.info);
        final Button title = (Button) findViewById (R.id.title);
        final Button title2 = (Button) findViewById (R.id.title2);
        final String nome = getIntent().getStringExtra("nome");
        final RelativeLayout pavimentos = (RelativeLayout) findViewById (R.id.pavimentos);
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
	        	startActivity(new Intent(Build_Options.this, Saiba_Mais.class)
	        	.putExtra("info_predio", info_predio));
	        }
       });
        
        PreparaXML(num_pavimentos);
        AcessaPredio (num_pavimentos,info_predio);
	}

	private void PreparaXML (int num_pavimentos){
	    foto = (FrameLayout) findViewById (R.id.build_options);
		//Pega a foto passada do Indice 
        final int imageId = getIntent().getIntExtra("foto_predio",1);
        foto.setBackgroundResource(imageId);
		String[] pavimentos;
        Button pav1 = (Button) findViewById(R.id.Botao1);
        Button pav2 = (Button) findViewById(R.id.Botao2);
        Button pav3 = (Button) findViewById(R.id.Botao3);
        Button pav4 = (Button) findViewById(R.id.Botao4);
        Button pav5 = (Button) findViewById(R.id.Botao5);
        //Animações dos botões 
        pav1.setBackgroundResource(R.drawable.bt_botoes_anim);
        pav2.setBackgroundResource(R.drawable.bt_botoes_anim);
        pav3.setBackgroundResource(R.drawable.bt_botoes_anim);
        pav4.setBackgroundResource(R.drawable.bt_botoes_anim);
        pav5.setBackgroundResource(R.drawable.bt_botoes_anim);
        switch (num_pavimentos){
        case 1:
        	pavimentos = getResources().getStringArray(R.array.PAV1);
        	pav1.setText(pavimentos[0]);
        	pav2.setVisibility(View.GONE);
        	pav3.setVisibility(View.GONE);
        	pav4.setVisibility(View.GONE);
        	pav5.setVisibility(View.GONE);
        	break;
        case 2:
        	pavimentos = getResources().getStringArray(R.array.PAV2);
        	pav1.setText(pavimentos[0]);
        	pav2.setText(pavimentos[1]);
        	pav3.setVisibility(View.GONE);
        	pav4.setVisibility(View.GONE);
        	pav5.setVisibility(View.GONE);
        	break;
        case 3:
        	pavimentos = getResources().getStringArray(R.array.PAV3);
        	pav1.setText(pavimentos[0]);
        	pav2.setText(pavimentos[1]);
        	pav3.setText(pavimentos[2]);
        	pav4.setVisibility(View.GONE);
        	pav5.setVisibility(View.GONE);
        	break;
        case 4:
        	pavimentos = getResources().getStringArray(R.array.PAV4);
        	pav1.setText(pavimentos[0]);
        	pav2.setText(pavimentos[1]);
        	pav3.setText(pavimentos[2]);
        	pav4.setText(pavimentos[3]);
        	pav5.setVisibility(View.GONE);
        	break;
        case 5:
        	pavimentos = getResources().getStringArray(R.array.PAV5);
        	pav1.setText(pavimentos[0]);
        	pav2.setText(pavimentos[1]);
        	pav3.setText(pavimentos[2]);
        	pav4.setText(pavimentos[3]);
        	pav5.setText(pavimentos[4]);
        	break;
        }
	}
	
	public void AcessaPredio (int num_pavimentos, final int info_predio){
        Button pav1 = (Button) findViewById(R.id.Botao1);
        Button pav2 = (Button) findViewById(R.id.Botao2);
        Button pav3 = (Button) findViewById(R.id.Botao3);
        Button pav4 = (Button) findViewById(R.id.Botao4);
        Button pav5 = (Button) findViewById(R.id.Botao5);
        
        pav1.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View conq) {   
	        	startActivity(new Intent(Build_Options.this, Build_Predio.class)
	        	.putExtra("info_predio", info_predio)
				.putExtra("pavimento", 1));
	        }
       });
        pav2.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View conq) {   
	        	startActivity(new Intent(Build_Options.this, Build_Predio.class)
	        	.putExtra("info_predio", info_predio)
				.putExtra("pavimento", 2));
	        }
       });  
        pav3.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View conq) {   
	        	startActivity(new Intent(Build_Options.this, Build_Predio.class)
	        	.putExtra("info_predio", info_predio)
				.putExtra("pavimento", 3));
	        }
       });  
        pav4.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View conq) {   
	        	startActivity(new Intent(Build_Options.this, Build_Predio.class)
	        	.putExtra("info_predio", info_predio)
				.putExtra("pavimento", 4));
	        }
       });  
        pav5.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View conq) {   
	        	startActivity(new Intent(Build_Options.this, Build_Predio.class)
	        	.putExtra("info_predio", info_predio)
				.putExtra("pavimento", 5));
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
        	this.startActivity(new Intent(Build_Options.this,Indice.class));  
        }  
        return true;  
    }
}
