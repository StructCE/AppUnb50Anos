package gm.unb;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;


public class Build_Predio extends Activity {
	FrameLayout imagem;
	@Override
   public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mapa_especifico);
      //Pega o numero de pavimentos
      final int pavimento = getIntent().getIntExtra("pavimento",1);
      //Pega a informação do prédio
      final int info_predio = getIntent().getIntExtra("info_predio",1);
 /*     final Button blocos = (Button) findViewById (R.id.blocos);
      final Button blocos2 = (Button) findViewById (R.id.blocos2);
      final RelativeLayout grupo_blocos = (RelativeLayout) findViewById (R.id.grupo_blocos);
      //Animações do XML
      final Animation animDecelerate = AnimationUtils.loadAnimation(this, R.anim.decelerate);
      blocos.setBackgroundResource(R.drawable.bt_botoes2_anim);
      blocos.setOnClickListener(new View.OnClickListener() {
	      public void onClick(View conq) {   
	        	grupo_blocos.setVisibility(View.VISIBLE);
	        	grupo_blocos.startAnimation(animDecelerate);
	        	blocos.setVisibility(View.GONE);
	        	blocos2.setVisibility(View.VISIBLE);
	        }
      	});       */
      PreparaXML(info_predio,pavimento);
   	}
	
	private void PreparaXML (int info_predio, int pavimento){
     imagem = (FrameLayout) findViewById(R.id.build_predio);
/*		Button botaoA = (Button) findViewById(R.id.BotaoA);
		Button botaoB = (Button) findViewById(R.id.BotaoB);
		Button botaoC = (Button) findViewById(R.id.BotaoC);
		Button botaoD = (Button) findViewById(R.id.BotaoD);
		Button botaoE = (Button) findViewById(R.id.BotaoE);
		//Animações do XML
		botaoA.setBackgroundResource(R.drawable.bt_botoes_anim);
		botaoB.setBackgroundResource(R.drawable.bt_botoes_anim);
		botaoC.setBackgroundResource(R.drawable.bt_botoes_anim);
		botaoD.setBackgroundResource(R.drawable.bt_botoes_anim);
		botaoE.setBackgroundResource(R.drawable.bt_botoes_anim);
*/		
		   //Abre o local onde será colocada a imagem
		   WebView view = (WebView) findViewById(R.id.planta);
		   final StringBuilder s = new StringBuilder();    
		   s.append("<html>");                             
		   s.append("<body>");
		   WebSettings webSettings = view.getSettings();
		   webSettings.setUseWideViewPort(true);
		   view.getSettings().setBuiltInZoomControls(true);
		   
		//Escolhe a opção correspondente ao prédio
		switch(info_predio){
 		//ICC - Sul
			case 1:
					switch(pavimento){
					//Subsolo
					case 1:
						   s.append("<img src=\"file:///android_asset/icc_sul_ss.png\" />");
						   s.append("</body>");                            
						   s.append("</html>");
						   view.loadDataWithBaseURL(null, s.toString(), "text/html", "UTF-8", null);
						   view.setInitialScale(100);		            
						break;	
					//Térreo	
					case 2:
						   s.append("<img src=\"file:///android_asset/icc_sul_ter.png\" />");
						   s.append("</body>");                            
						   s.append("</html>");
						   view.loadDataWithBaseURL(null, s.toString(), "text/html", "UTF-8", null);
						   view.setInitialScale(100);	
						break;
						//1º Andar	
					case 3:
						   s.append("<img src=\"file:///android_asset/icc_sul_pav1.png\" />");
						   s.append("</body>");                            
						   s.append("</html>");
						   view.loadDataWithBaseURL(null, s.toString(), "text/html", "UTF-8", null);
						   view.setInitialScale(100);	     
						break;	
					}
					break;
			//ICC - Centro
			case 2:
					switch(pavimento){
					//Subsolo
					case 1:
						   s.append("<img src=\"file:///android_asset/icc_centro_ss.png\" />");
						   //s.append("<img src=\"file:///android_asset/icc_centro_ss.png\" />");
						   s.append("</body>");                            
						   s.append("</html>");
						   view.loadDataWithBaseURL(null, s.toString(), "text/html", "UTF-8", null);
						   view.setInitialScale(100);
						   break;
					//Térreo	
					case 2:
						   s.append("<img src=\"file:///android_asset/icc_centro_ter.png\" />");
						   //s.append("<img src=\"file:///android_asset/icc_centro_ss.png\" />");
						   s.append("</body>");                            
						   s.append("</html>");
						   view.loadDataWithBaseURL(null, s.toString(), "text/html", "UTF-8", null);
						   view.setInitialScale(100);	            
						break;
						//1º Andar	
					case 3:
						   s.append("<img src=\"file:///android_asset/icc_centro_pav1.png\" />");
						   //s.append("<img src=\"file:///android_asset/icc_centro_ss.png\" />");
						   s.append("</body>");                            
						   s.append("</html>");
						   view.loadDataWithBaseURL(null, s.toString(), "text/html", "UTF-8", null);
						   view.setInitialScale(100);	 
						break;	
					}
					break;
			//ICC - Norte
			case 3:
				switch(pavimento){
					//Subsolo
				case 1:
					   s.append("<img src=\"file:///android_asset/icc_norte_ss.png\" />");
					   //s.append("<img src=\"file:///android_asset/icc_centro_ss.png\" />");
					   s.append("</body>");                            
					   s.append("</html>");
					   view.loadDataWithBaseURL(null, s.toString(), "text/html", "UTF-8", null);
					   view.setInitialScale(100);      
				break;	
				//Térreo	
				case 2:
					   s.append("<img src=\"file:///android_asset/icc_norte_ter.png\" />");
					   //s.append("<img src=\"file:///android_asset/icc_centro_ss.png\" />");
					   s.append("</body>");                            
					   s.append("</html>");
					   view.loadDataWithBaseURL(null, s.toString(), "text/html", "UTF-8", null);
					   view.setInitialScale(100);	            
				break;
				//1º Andar	
				case 3:
					   s.append("<img src=\"file:///android_asset/icc_norte_pav1.png\" />");
					   //s.append("<img src=\"file:///android_asset/icc_centro_ss.png\" />");
					   s.append("</body>");                            
					   s.append("</html>");
					   view.loadDataWithBaseURL(null, s.toString(), "text/html", "UTF-8", null);
					   view.setInitialScale(100);	            
				break;	
				}
				break;
			//FA	
			case 4:
				switch(pavimento){
				//Térreo
				case 1:
					   s.append("<img src=\"file:///android_asset/fa_ter.png\" />");
					   s.append("</body>");                            
					   s.append("</html>");
					   view.loadDataWithBaseURL(null, s.toString(), "text/html", "UTF-8", null);
					   view.setInitialScale(100);
					break;
				//1º Andar	
				case 2:
					   s.append("<img src=\"file:///android_asset/fa_pav1.png\" />");
					   s.append("</body>");                            
					   s.append("</html>");
					   view.loadDataWithBaseURL(null, s.toString(), "text/html", "UTF-8", null);
					   view.setInitialScale(100);
					break;	
				}
				break;
			//FE	
			case 5:
				switch(pavimento){
				//Prédio 1
				case 1:
					   s.append("<img src=\"file:///android_asset/planta_fe1_ter.png\" />");
					   s.append("</body>");                            
					   s.append("</html>");
					   view.loadDataWithBaseURL(null, s.toString(), "text/html", "UTF-8", null);
					   view.setInitialScale(100);					
					break;
				//Prédio 2 SS
				case 2:
					   s.append("<img src=\"file:///android_asset/planta_fe3_0\" />");
					   s.append("</body>");                            
					   s.append("</html>");
					   view.loadDataWithBaseURL(null, s.toString(), "text/html", "UTF-8", null);
					   view.setInitialScale(100);					
					break;
				//Prédio 2 TER	
				case 3:
					   s.append("<img src=\"file:///android_asset/planta_fe3_1.png\" />");
					   s.append("</body>");                            
					   s.append("</html>");
					   view.loadDataWithBaseURL(null, s.toString(), "text/html", "UTF-8", null);
					   view.setInitialScale(100);					
					break;
				//Prédio 3	
				case 4:
					   s.append("<img src=\"file:///android_asset/planta_fe5_ter.png\" />");
					   s.append("</body>");                            
					   s.append("</html>");
					   view.loadDataWithBaseURL(null, s.toString(), "text/html", "UTF-8", null);
					   view.setInitialScale(100);					
					break;						
				}		
				break;
			//FMFS
			case 6:
				switch(pavimento){
					//Subsolo
					case 1:
						   s.append("<img src=\"file:///android_asset/fs_ss.png\" />");
						   s.append("</body>");                            
						   s.append("</html>");
						   view.loadDataWithBaseURL(null, s.toString(), "text/html", "UTF-8", null);
						   view.setInitialScale(100);
						break;
					//Térreo	
					case 2:
						   s.append("<img src=\"file:///android_asset/fs_ter.png\" />");
						   s.append("</body>");                            
						   s.append("</html>");
						   view.loadDataWithBaseURL(null, s.toString(), "text/html", "UTF-8", null);
						   view.setInitialScale(100);
						break;
					//1º Andar	
					case 3:
						   s.append("<img src=\"file:///android_asset/fs_pav1.png\" />");
						   s.append("</body>");                            
						   s.append("</html>");
						   view.loadDataWithBaseURL(null, s.toString(), "text/html", "UTF-8", null);
						   view.setInitialScale(100);
						break;
					//2º Andar
					case 4:
						   s.append("<img src=\"file:///android_asset/fs_pav2.png\" />");
						   s.append("</body>");                            
						   s.append("</html>");
						   view.loadDataWithBaseURL(null, s.toString(), "text/html", "UTF-8", null);
						   view.setInitialScale(100);
						break;
				}			
				break;
			//IB
			case 7:
				switch(pavimento){
					//Subsolo
					case 1:
						   s.append("<img src=\"file:///android_asset/ib_ss.png\" />");
						   s.append("</body>");                            
						   s.append("</html>");
						   view.loadDataWithBaseURL(null, s.toString(), "text/html", "UTF-8", null);
						   view.setInitialScale(100);						
						break;
					//Térreo	
					case 2:
						   s.append("<img src=\"file:///android_asset/ib_ter.png\" />");
						   s.append("</body>");                            
						   s.append("</html>");
						   view.loadDataWithBaseURL(null, s.toString(), "text/html", "UTF-8", null);
						   view.setInitialScale(100);	
						break;
					//1º Andar
					case 3:
						   s.append("<img src=\"file:///android_asset/ib_pav1.png\" />");
						   s.append("</body>");                            
						   s.append("</html>");
						   view.loadDataWithBaseURL(null, s.toString(), "text/html", "UTF-8", null);
						   view.setInitialScale(100);	
						break;						
				}			
				break;
			//IQ
			case 8:
				switch(pavimento){
				//Térreo
				case 1:
					   s.append("<img src=\"file:///android_asset/iq_ter.png\" />");
					   s.append("</body>");                            
					   s.append("</html>");
					   view.loadDataWithBaseURL(null, s.toString(), "text/html", "UTF-8", null);
					   view.setInitialScale(100);						
					break;
				//1º Andar	
				case 2:
					   s.append("<img src=\"file:///android_asset/iq_pav1.png\" />");
					   s.append("</body>");                            
					   s.append("</html>");
					   view.loadDataWithBaseURL(null, s.toString(), "text/html", "UTF-8", null);
					   view.setInitialScale(100);					
					break;
				}			
				break;
			//PAT
			case 9:
				switch(pavimento){
				//Térreo
				case 1:
					   s.append("<img src=\"file:///android_asset/pat_ter.png\" />");
					   s.append("</body>");                            
					   s.append("</html>");
					   view.loadDataWithBaseURL(null, s.toString(), "text/html", "UTF-8", null);
					   view.setInitialScale(100);						
					break;
				}			
				break;
			//PJC
			case 10:
				switch(pavimento){
					//Térreo
					case 1:
						   s.append("<img src=\"file:///android_asset/pjc.png\" />");
						   s.append("</body>");                            
						   s.append("</html>");
						   view.loadDataWithBaseURL(null, s.toString(), "text/html", "UTF-8", null);
						   view.setInitialScale(100);
						break;
				}			
				break;
			//PMU I
			case 11:
				switch(pavimento){
					//Térreo
					case 1:
						   s.append("<img src=\"file:///android_asset/pmu1_ter.png\" />");
						   s.append("</body>");                            
						   s.append("</html>");
						   view.loadDataWithBaseURL(null, s.toString(), "text/html", "UTF-8", null);
						   view.setInitialScale(100);
						break;
					//1º Andar	
					case 2:
						   s.append("<img src=\"file:///android_asset/pmu1_pav1.png\" />");
						   s.append("</body>");                            
						   s.append("</html>");
						   view.loadDataWithBaseURL(null, s.toString(), "text/html", "UTF-8", null);
						   view.setInitialScale(100);						
						break;
				}			
				break;
			//PMU II
			case 12:
				switch(pavimento){
					//Térreo
					case 1:
						   s.append("<img src=\"file:///android_asset/pmu2_ter.png\" />");
						   s.append("</body>");                            
						   s.append("</html>");
						   view.loadDataWithBaseURL(null, s.toString(), "text/html", "UTF-8", null);
						   view.setInitialScale(100);
						break;
					//1º Andar	
					case 2:
						   s.append("<img src=\"file:///android_asset/pmu2_pav1.png\" />");
						   s.append("</body>");                            
						   s.append("</html>");
						   view.loadDataWithBaseURL(null, s.toString(), "text/html", "UTF-8", null);
						   view.setInitialScale(100);				
						break;
				}			
				break;
			//BCE
			case 13:
				switch(pavimento){
					//Subsolo
					case 1:
						   s.append("<img src=\"file:///android_asset/bce-ss1.png\" />");
						   s.append("</body>");                            
						   s.append("</html>");
						   view.loadDataWithBaseURL(null, s.toString(), "text/html", "UTF-8", null);
						   view.setInitialScale(100);
						break;
					//Térreo	
					case 2:
						   s.append("<img src=\"file:///android_asset/bce-ter.png\" />");
						   s.append("</body>");                            
						   s.append("</html>");
						   view.loadDataWithBaseURL(null, s.toString(), "text/html", "UTF-8", null);
						   view.setInitialScale(100);
						break;
					//1º Andar	
					case 3:
						   s.append("<img src=\"file:///android_asset/bce-pav1.png\" />");
						   s.append("</body>");                            
						   s.append("</html>");
						   view.loadDataWithBaseURL(null, s.toString(), "text/html", "UTF-8", null);
						   view.setInitialScale(100);
						break;
				}			
				break;
			//FT
			case 14:
				switch(pavimento){
					//Térreo
					case 1:
						   s.append("<img src=\"file:///android_asset/ft_ter.png\" />");
						   s.append("</body>");                            
						   s.append("</html>");
						   view.loadDataWithBaseURL(null, s.toString(), "text/html", "UTF-8", null);
						   view.setInitialScale(100);
						break;
					//1º Andar	
					case 2:
						   s.append("<img src=\"file:///android_asset/ft_pav1.png\" />");
						   s.append("</body>");                            
						   s.append("</html>");
						   view.loadDataWithBaseURL(null, s.toString(), "text/html", "UTF-8", null);
						   view.setInitialScale(100);
						break;
				}			
				break;
			//Reitoria
			case 15:
				switch(pavimento){
					//Subsolo
					case 1:
						   s.append("<img src=\"file:///android_asset/rt_ss.png\" />");
						   s.append("</body>");                            
						   s.append("</html>");
						   view.loadDataWithBaseURL(null, s.toString(), "text/html", "UTF-8", null);
						   view.setInitialScale(100);           
						break;
					//Térreo	
					case 2:
						   s.append("<img src=\"file:///android_asset/rt_ter.png\" />");
						   s.append("</body>");                            
						   s.append("</html>");
						   view.loadDataWithBaseURL(null, s.toString(), "text/html", "UTF-8", null);
						   view.setInitialScale(100);
						break;
					//1º Andar	
					case 3:
						   s.append("<img src=\"file:///android_asset/rt_pav1.png\" />");
						   s.append("</body>");                            
						   s.append("</html>");
						   view.loadDataWithBaseURL(null, s.toString(), "text/html", "UTF-8", null);
						   view.setInitialScale(100);   
							break;
					//2º Andar
					case 4:
						   s.append("<img src=\"file:///android_asset/rt_pav2.png\" />");
						   s.append("</body>");                            
						   s.append("</html>");
						   view.loadDataWithBaseURL(null, s.toString(), "text/html", "UTF-8", null);
						   view.setInitialScale(100);  
						break;
					//3º Andar
					case 5:	
						   s.append("<img src=\"file:///android_asset/rt_pav3.png\" />");
						   s.append("</body>");                            
						   s.append("</html>");
						   view.loadDataWithBaseURL(null, s.toString(), "text/html", "UTF-8", null);
						   view.setInitialScale(100);
						break;
				}			
				break;
		}
		}
}
