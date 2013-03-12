package struct.guia.mochileiro;

import struct.guia.mochileiro.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

public class Build_Predio extends Activity {
	FrameLayout imagem;
	@Override
    public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.build_predio);
        //Pega o numero de pavimentos
        final int pavimento = getIntent().getIntExtra("pavimento",1);
        //Pega a informa��o do pr�dio
        final int info_predio = getIntent().getIntExtra("info_predio",1);
        final Button blocos = (Button) findViewById (R.id.blocos);
        final Button blocos2 = (Button) findViewById (R.id.blocos2);
        final RelativeLayout grupo_blocos = (RelativeLayout) findViewById (R.id.grupo_blocos);
        //Anima��es do XML
        final Animation animDecelerate = AnimationUtils.loadAnimation(this, R.anim.decelerate);
        blocos.setBackgroundResource(R.drawable.bt_botoes2_anim);
        blocos.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View conq) {   
	        	grupo_blocos.setVisibility(View.VISIBLE);
	        	grupo_blocos.startAnimation(animDecelerate);
	        	blocos.setVisibility(View.GONE);
	        	blocos2.setVisibility(View.VISIBLE);
	        }
       });       
        PreparaXML(info_predio,pavimento);
        }
	
	private void PreparaXML (int info_predio, int pavimento){
        imagem = (FrameLayout) findViewById(R.id.build_predio);
		Button botaoA = (Button) findViewById(R.id.BotaoA);
		Button botaoB = (Button) findViewById(R.id.BotaoB);
		Button botaoC = (Button) findViewById(R.id.BotaoC);
		Button botaoD = (Button) findViewById(R.id.BotaoD);
		Button botaoE = (Button) findViewById(R.id.BotaoE);
		//Anima��es do XML
		botaoA.setBackgroundResource(R.drawable.bt_botoes_anim);
		botaoB.setBackgroundResource(R.drawable.bt_botoes_anim);
		botaoC.setBackgroundResource(R.drawable.bt_botoes_anim);
		botaoD.setBackgroundResource(R.drawable.bt_botoes_anim);
		botaoE.setBackgroundResource(R.drawable.bt_botoes_anim);
		
		//Escolhe a op��o correspondente ao pr�dio
		switch(info_predio){
		//ICC - Sul
				case 1:
					switch(pavimento){
					//Subsolo
					case 1:
						//Imagem de fundo
						imagem = (FrameLayout) findViewById(R.id.build_predio);
						imagem.setBackgroundResource(R.drawable.planta_fe1);
			            //Cria bot�es planta
						botaoA.setOnClickListener(new View.OnClickListener() {
			    	        public void onClick(View conq) {   
			    	        	startActivity(new Intent(Build_Predio.this, EspecificMap.class)
			    	        	.putExtra("planta", R.drawable.planta_fe1));
			    	        }
			           });
			            botaoB.setOnClickListener(new View.OnClickListener() {
			    	        public void onClick(View conq) {   
			    	        	startActivity(new Intent(Build_Predio.this, EspecificMap.class)
			    	        	.putExtra("planta", R.drawable.teste4));
			    	        }
			           });
			            botaoC.setOnClickListener(new View.OnClickListener() {
			    	        public void onClick(View conq) {   
			    	        	startActivity(new Intent(Build_Predio.this, EspecificMap.class)
			    	        	.putExtra("planta", R.drawable.planta_fe1));
			    	        }
			           });
			            botaoD.setOnClickListener(new View.OnClickListener() {
			    	        public void onClick(View conq) {   
			    	        	startActivity(new Intent(Build_Predio.this, EspecificMap.class)
			    	        	.putExtra("planta", R.drawable.planta_fe1));
			    	        }
			           });
			            botaoE.setOnClickListener(new View.OnClickListener() {
			    	        public void onClick(View conq) {   
			    	        	startActivity(new Intent(Build_Predio.this, EspecificMap.class)
			    	        	.putExtra("planta", R.drawable.planta_fe1));
			    	        }
			           });	            
						break;	
					//T�rreo	
					case 2:
						//Imagem de fundo
						imagem = (FrameLayout) findViewById(R.id.build_predio);
						imagem.setBackgroundResource(R.drawable.planta_fe1);
			            //Cria bot�es planta
			            botaoA.setOnClickListener(new View.OnClickListener() {
			    	        public void onClick(View conq) {   
			    	        	startActivity(new Intent(Build_Predio.this, EspecificMap.class)
			    	        	.putExtra("planta", R.drawable.planta_fe1));
			    	        }
			           });
			            botaoB.setOnClickListener(new View.OnClickListener() {
			    	        public void onClick(View conq) {   
			    	        	startActivity(new Intent(Build_Predio.this, EspecificMap.class)
			    	        	.putExtra("planta", R.drawable.planta_fe1));
			    	        }
			           });
			            botaoC.setOnClickListener(new View.OnClickListener() {
			    	        public void onClick(View conq) {   
			    	        	startActivity(new Intent(Build_Predio.this, EspecificMap.class)
			    	        	.putExtra("planta", R.drawable.planta_fe1));
			    	        }
			           });
			            botaoD.setOnClickListener(new View.OnClickListener() {
			    	        public void onClick(View conq) {   
			    	        	startActivity(new Intent(Build_Predio.this, EspecificMap.class)
			    	        	.putExtra("planta", R.drawable.planta_fe1));
			    	        }
			           });
			            botaoE.setOnClickListener(new View.OnClickListener() {
			    	        public void onClick(View conq) {   
			    	        	startActivity(new Intent(Build_Predio.this, EspecificMap.class)
			    	        	.putExtra("planta", R.drawable.planta_fe1));
			    	        }
			           });	            
						break;
						//1� Andar	
					case 3:
						//Imagem de fundo
						imagem = (FrameLayout) findViewById(R.id.build_predio);
						imagem.setBackgroundResource(R.drawable.planta_fe1);
			            //Cria bot�es planta
						botaoA.setOnClickListener(new View.OnClickListener() {
			    	        public void onClick(View conq) {   
			    	        	startActivity(new Intent(Build_Predio.this, EspecificMap.class)
			    	        	.putExtra("planta", R.drawable.planta_fe1));
			    	        }
			           });
			            botaoB.setOnClickListener(new View.OnClickListener() {
			    	        public void onClick(View conq) {   
			    	        	startActivity(new Intent(Build_Predio.this, EspecificMap.class)
			    	        	.putExtra("planta", R.drawable.planta_fe1));
			    	        }
			           });
			            botaoC.setOnClickListener(new View.OnClickListener() {
			    	        public void onClick(View conq) {   
			    	        	startActivity(new Intent(Build_Predio.this, EspecificMap.class)
			    	        	.putExtra("planta", R.drawable.planta_fe1));
			    	        }
			           });
			            botaoD.setOnClickListener(new View.OnClickListener() {
			    	        public void onClick(View conq) {   
			    	        	startActivity(new Intent(Build_Predio.this, EspecificMap.class)
			    	        	.putExtra("planta", R.drawable.planta_fe1));
			    	        }
			           });
			            botaoE.setOnClickListener(new View.OnClickListener() {
			    	        public void onClick(View conq) {   
			    	        	startActivity(new Intent(Build_Predio.this, EspecificMap.class)
			    	        	.putExtra("planta", R.drawable.planta_fe1));
			    	        }
			           });	            
						break;	
					}
					break;
		//ICC - Centro
				case 2:
					switch(pavimento){
					//Subsolo
					case 1:
						//Imagem de fundo
						imagem = (FrameLayout) findViewById(R.id.build_predio);
						imagem.setBackgroundResource(R.drawable.planta_fe1);
			            //Cria bot�es planta
						botaoA.setOnClickListener(new View.OnClickListener() {
			    	        public void onClick(View conq) {   
			    	        	startActivity(new Intent(Build_Predio.this, EspecificMap.class)
			    	        	.putExtra("planta", R.drawable.planta_fe1));
			    	        }
			           });
			            botaoB.setOnClickListener(new View.OnClickListener() {
			    	        public void onClick(View conq) {   
			    	        	startActivity(new Intent(Build_Predio.this, EspecificMap.class)
			    	        	.putExtra("planta", R.drawable.teste4));
			    	        }
			           });
			            botaoC.setOnClickListener(new View.OnClickListener() {
			    	        public void onClick(View conq) {   
			    	        	startActivity(new Intent(Build_Predio.this, EspecificMap.class)
			    	        	.putExtra("planta", R.drawable.planta_fe1));
			    	        }
			           });
			            botaoD.setOnClickListener(new View.OnClickListener() {
			    	        public void onClick(View conq) {   
			    	        	startActivity(new Intent(Build_Predio.this, EspecificMap.class)
			    	        	.putExtra("planta", R.drawable.planta_fe1));
			    	        }
			           });
			            botaoE.setOnClickListener(new View.OnClickListener() {
			    	        public void onClick(View conq) {   
			    	        	startActivity(new Intent(Build_Predio.this, EspecificMap.class)
			    	        	.putExtra("planta", R.drawable.planta_fe1));
			    	        }
			           });	            
						break;	
					//T�rreo	
					case 2:
						//Imagem de fundo
						imagem = (FrameLayout) findViewById(R.id.build_predio);
						imagem.setBackgroundResource(R.drawable.planta_fe1);
			            //Cria bot�es planta
			            botaoA.setOnClickListener(new View.OnClickListener() {
			    	        public void onClick(View conq) {   
			    	        	startActivity(new Intent(Build_Predio.this, EspecificMap.class)
			    	        	.putExtra("planta", R.drawable.planta_fe1));
			    	        }
			           });
			            botaoB.setOnClickListener(new View.OnClickListener() {
			    	        public void onClick(View conq) {   
			    	        	startActivity(new Intent(Build_Predio.this, EspecificMap.class)
			    	        	.putExtra("planta", R.drawable.planta_fe1));
			    	        }
			           });
			            botaoC.setOnClickListener(new View.OnClickListener() {
			    	        public void onClick(View conq) {   
			    	        	startActivity(new Intent(Build_Predio.this, EspecificMap.class)
			    	        	.putExtra("planta", R.drawable.planta_fe1));
			    	        }
			           });
			            botaoD.setOnClickListener(new View.OnClickListener() {
			    	        public void onClick(View conq) {   
			    	        	startActivity(new Intent(Build_Predio.this, EspecificMap.class)
			    	        	.putExtra("planta", R.drawable.planta_fe1));
			    	        }
			           });
			            botaoE.setOnClickListener(new View.OnClickListener() {
			    	        public void onClick(View conq) {   
			    	        	startActivity(new Intent(Build_Predio.this, EspecificMap.class)
			    	        	.putExtra("planta", R.drawable.planta_fe1));
			    	        }
			           });	            
						break;
						//1� Andar	
					case 3:
						//Imagem de fundo
						imagem = (FrameLayout) findViewById(R.id.build_predio);
						imagem.setBackgroundResource(R.drawable.planta_fe1);
			            //Cria bot�es planta
						botaoA.setOnClickListener(new View.OnClickListener() {
			    	        public void onClick(View conq) {   
			    	        	startActivity(new Intent(Build_Predio.this, EspecificMap.class)
			    	        	.putExtra("planta", R.drawable.planta_fe1));
			    	        }
			           });
			            botaoB.setOnClickListener(new View.OnClickListener() {
			    	        public void onClick(View conq) {   
			    	        	startActivity(new Intent(Build_Predio.this, EspecificMap.class)
			    	        	.putExtra("planta", R.drawable.planta_fe1));
			    	        }
			           });
			            botaoC.setOnClickListener(new View.OnClickListener() {
			    	        public void onClick(View conq) {   
			    	        	startActivity(new Intent(Build_Predio.this, EspecificMap.class)
			    	        	.putExtra("planta", R.drawable.planta_fe1));
			    	        }
			           });
			            botaoD.setOnClickListener(new View.OnClickListener() {
			    	        public void onClick(View conq) {   
			    	        	startActivity(new Intent(Build_Predio.this, EspecificMap.class)
			    	        	.putExtra("planta", R.drawable.planta_fe1));
			    	        }
			           });
			            botaoE.setOnClickListener(new View.OnClickListener() {
			    	        public void onClick(View conq) {   
			    	        	startActivity(new Intent(Build_Predio.this, EspecificMap.class)
			    	        	.putExtra("planta", R.drawable.planta_fe1));
			    	        }
			           });	            
						break;	
					}
					break;
		//ICC - Norte
		case 3:
			switch(pavimento){
			//Subsolo
			case 1:
				//Imagem de fundo
				imagem = (FrameLayout) findViewById(R.id.build_predio);
				imagem.setBackgroundResource(R.drawable.planta_fe1);
	            //Cria bot�es planta
				botaoA.setOnClickListener(new View.OnClickListener() {
	    	        public void onClick(View conq) {   
	    	        	startActivity(new Intent(Build_Predio.this, EspecificMap.class)
	    	        	.putExtra("planta", R.drawable.planta_fe1));
	    	        }
	           });
	            botaoB.setOnClickListener(new View.OnClickListener() {
	    	        public void onClick(View conq) {   
	    	        	startActivity(new Intent(Build_Predio.this, EspecificMap.class)
	    	        	.putExtra("planta", R.drawable.teste4));
	    	        }
	           });
	            botaoC.setOnClickListener(new View.OnClickListener() {
	    	        public void onClick(View conq) {   
	    	        	startActivity(new Intent(Build_Predio.this, EspecificMap.class)
	    	        	.putExtra("planta", R.drawable.planta_fe1));
	    	        }
	           });
	            botaoD.setOnClickListener(new View.OnClickListener() {
	    	        public void onClick(View conq) {   
	    	        	startActivity(new Intent(Build_Predio.this, EspecificMap.class)
	    	        	.putExtra("planta", R.drawable.planta_fe1));
	    	        }
	           });
	            botaoE.setOnClickListener(new View.OnClickListener() {
	    	        public void onClick(View conq) {   
	    	        	startActivity(new Intent(Build_Predio.this, EspecificMap.class)
	    	        	.putExtra("planta", R.drawable.planta_fe1));
	    	        }
	           });	            
				break;	
			//T�rreo	
			case 2:
				//Imagem de fundo
				imagem = (FrameLayout) findViewById(R.id.build_predio);
				imagem.setBackgroundResource(R.drawable.planta_fe1);
	            //Cria bot�es planta
	            botaoA.setOnClickListener(new View.OnClickListener() {
	    	        public void onClick(View conq) {   
	    	        	startActivity(new Intent(Build_Predio.this, EspecificMap.class)
	    	        	.putExtra("planta", R.drawable.planta_fe1));
	    	        }
	           });
	            botaoB.setOnClickListener(new View.OnClickListener() {
	    	        public void onClick(View conq) {   
	    	        	startActivity(new Intent(Build_Predio.this, EspecificMap.class)
	    	        	.putExtra("planta", R.drawable.planta_fe1));
	    	        }
	           });
	            botaoC.setOnClickListener(new View.OnClickListener() {
	    	        public void onClick(View conq) {   
	    	        	startActivity(new Intent(Build_Predio.this, EspecificMap.class)
	    	        	.putExtra("planta", R.drawable.planta_fe1));
	    	        }
	           });
	            botaoD.setOnClickListener(new View.OnClickListener() {
	    	        public void onClick(View conq) {   
	    	        	startActivity(new Intent(Build_Predio.this, EspecificMap.class)
	    	        	.putExtra("planta", R.drawable.planta_fe1));
	    	        }
	           });
	            botaoE.setOnClickListener(new View.OnClickListener() {
	    	        public void onClick(View conq) {   
	    	        	startActivity(new Intent(Build_Predio.this, EspecificMap.class)
	    	        	.putExtra("planta", R.drawable.planta_fe1));
	    	        }
	           });	            
				break;
				//1� Andar	
			case 3:
				//Imagem de fundo
				imagem = (FrameLayout) findViewById(R.id.build_predio);
				imagem.setBackgroundResource(R.drawable.planta_fe1);
	            //Cria bot�es planta
				botaoA.setOnClickListener(new View.OnClickListener() {
	    	        public void onClick(View conq) {   
	    	        	startActivity(new Intent(Build_Predio.this, EspecificMap.class)
	    	        	.putExtra("planta", R.drawable.planta_fe1));
	    	        }
	           });
	            botaoB.setOnClickListener(new View.OnClickListener() {
	    	        public void onClick(View conq) {   
	    	        	startActivity(new Intent(Build_Predio.this, EspecificMap.class)
	    	        	.putExtra("planta", R.drawable.planta_fe1));
	    	        }
	           });
	            botaoC.setOnClickListener(new View.OnClickListener() {
	    	        public void onClick(View conq) {   
	    	        	startActivity(new Intent(Build_Predio.this, EspecificMap.class)
	    	        	.putExtra("planta", R.drawable.planta_fe1));
	    	        }
	           });
	            botaoD.setOnClickListener(new View.OnClickListener() {
	    	        public void onClick(View conq) {   
	    	        	startActivity(new Intent(Build_Predio.this, EspecificMap.class)
	    	        	.putExtra("planta", R.drawable.planta_fe1));
	    	        }
	           });
	            botaoE.setOnClickListener(new View.OnClickListener() {
	    	        public void onClick(View conq) {   
	    	        	startActivity(new Intent(Build_Predio.this, EspecificMap.class)
	    	        	.putExtra("planta", R.drawable.planta_fe1));
	    	        }
	           });	            
				break;	
			}
			break;
		//FA	
		case 4:
			switch(pavimento){
			//T�rreo
			case 1:
				break;
			//1� Andar	
			case 2:
				break;	
			}
			break;
		//FE	
		case 5:
			switch(pavimento){
			//T�rreo
			case 1:
				break;
			//1� Andar	
			case 2:
				break;
			}		
			break;
		//FMFS
		case 6:
			switch(pavimento){
			//Subsolo
			case 1:
				break;
			//T�rreo	
			case 2:
				break;
			//1� Andar	
			case 3:
				break;
			//2� Andar
			case 4:
				break;
			}			
			break;
		//IB
		case 7:
			switch(pavimento){
			//T�rreo
			case 1:
				break;
			
			//1� Andar	
			case 2:
				break;
			}			
			break;
		//IQ
		case 8:
			switch(pavimento){
			//T�rreo
			case 1:
				break;
			//1� Andar	
			case 2:
				break;
			}			
			break;
		//PAT
		case 9:
			switch(pavimento){
			//T�rreo
			case 1:
				break;
			}			
			break;
		//PJC
		case 10:
			switch(pavimento){
			//T�rreo
			case 1:
				break;
			}			
			break;
		//PMU I
		case 11:
			switch(pavimento){
			//T�rreo
			case 1:
				break;
			//1� Andar	
			case 2:
				break;
			}			
			break;
		//PMU II
		case 12:
			switch(pavimento){
			//T�rreo
			case 1:
				break;
			//1� Andar	
			case 2:
				break;
			}			
			break;
		//BCE
		case 13:
			switch(pavimento){
			//Subsolo
			case 1:
				break;
			//T�rreo	
			case 2:
				break;
			//1� Andar	
			case 3:
				break;
			}			
			break;
		//FT
		case 14:
			switch(pavimento){
			//T�rreo
			case 1:
				break;
			//1� Andar	
			case 2:
				break;
			}			
			break;
		//Reitoria
		case 15:
			botaoC.setVisibility(View.GONE);
			botaoD.setVisibility(View.GONE);
			botaoE.setVisibility(View.GONE);
			switch(pavimento){
			//Subsolo
			case 1:
				//Imagem de fundo
				imagem = (FrameLayout) findViewById(R.id.build_predio);
				imagem.setBackgroundResource(R.drawable.pg_reitoria_ss);
	            //Cria bot�es planta
				botaoA.setOnClickListener(new View.OnClickListener() {
	    	        public void onClick(View conq) {   
	    	        	startActivity(new Intent(Build_Predio.this, EspecificMap.class)
	    	        	.putExtra("planta", R.drawable.b_reitoria_ss_a));
	    	        }
	           });
	            botaoB.setOnClickListener(new View.OnClickListener() {
	    	        public void onClick(View conq) {   
	    	        	startActivity(new Intent(Build_Predio.this, EspecificMap.class)
	    	        	.putExtra("planta", R.drawable.b_reitoria_ss_b));
	    	        }
	           });            
				break;
			//T�rreo	
			case 2:
				imagem = (FrameLayout) findViewById(R.id.build_predio);
				imagem.setBackgroundResource(R.drawable.pg_reitoria_ter);
	            //Cria bot�es planta
				botaoA.setOnClickListener(new View.OnClickListener() {
	    	        public void onClick(View conq) {   
	    	        	startActivity(new Intent(Build_Predio.this, EspecificMap.class)
	    	        	.putExtra("planta", R.drawable.b_reitoria_ter_a));
	    	        }
	           });
	            botaoB.setOnClickListener(new View.OnClickListener() {
	    	        public void onClick(View conq) {   
	    	        	startActivity(new Intent(Build_Predio.this, EspecificMap.class)
	    	        	.putExtra("planta", R.drawable.b_reitoria_ter_b));
	    	        }
	           });    
				break;
			//1� Andar	
			case 3:
				imagem = (FrameLayout) findViewById(R.id.build_predio);
				imagem.setBackgroundResource(R.drawable.pg_reitoria_pav1);
	            //Cria bot�es planta
				botaoA.setOnClickListener(new View.OnClickListener() {
	    	        public void onClick(View conq) {   
	    	        	startActivity(new Intent(Build_Predio.this, EspecificMap.class)
	    	        	.putExtra("planta", R.drawable.b_reitoria_pav1_a));
	    	        }
	           });
	            botaoB.setOnClickListener(new View.OnClickListener() {
	    	        public void onClick(View conq) {   
	    	        	startActivity(new Intent(Build_Predio.this, EspecificMap.class)
	    	        	.putExtra("planta", R.drawable.b_reitoria_pav1_b));
	    	        }
	           });    
				break;
			//2� Andar
			case 4:
				imagem = (FrameLayout) findViewById(R.id.build_predio);
				imagem.setBackgroundResource(R.drawable.pg_reitoria_pav2);
	            //Cria bot�es planta
				botaoA.setOnClickListener(new View.OnClickListener() {
	    	        public void onClick(View conq) {   
	    	        	startActivity(new Intent(Build_Predio.this, EspecificMap.class)
	    	        	.putExtra("planta", R.drawable.b_reitoria_pav2_a));
	    	        }
	           });
	            botaoB.setOnClickListener(new View.OnClickListener() {
	    	        public void onClick(View conq) {   
	    	        	startActivity(new Intent(Build_Predio.this, EspecificMap.class)
	    	        	.putExtra("planta", R.drawable.b_reitoria_pav2_b));
	    	        }
	           });    
				break;
			//3� Andar
			case 5:	
				imagem = (FrameLayout) findViewById(R.id.build_predio);
				imagem.setBackgroundResource(R.drawable.pg_reitoria_pav3);
	            //Cria bot�es planta
				botaoA.setOnClickListener(new View.OnClickListener() {
	    	        public void onClick(View conq) {   
	    	        	startActivity(new Intent(Build_Predio.this, EspecificMap.class)
	    	        	.putExtra("planta", R.drawable.b_reitoria_pav3_a));
	    	        }
	           });
	            botaoB.setOnClickListener(new View.OnClickListener() {
	    	        public void onClick(View conq) {   
	    	        	startActivity(new Intent(Build_Predio.this, EspecificMap.class)
	    	        	.putExtra("planta", R.drawable.b_reitoria_pav3_b));
	    	        }
	           });    
				break;
			}			
			break;
		}
	}

}
