package gm.unb;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Indice extends Activity {
	ImageView planta;
	DBAdapter db = new DBAdapter(this);
	
	@Override
    public void onCreate(Bundle savedInstanceState)
    {
			//Doing he Instance
            super.onCreate(savedInstanceState);
            setContentView(R.layout.indice_predios);            
            
            //Pega o ID da planta
            
            planta = (ImageView) findViewById(R.id.planta);
            
            /*São passadas a informações:
             * 1. foto do predio
             * 2. planta principal do predio
             * 3. nome do predio
             * 4. n. predio
             * 5. n. de pavimentos
             */
            
            //ICC - SUL
            Button icc_sul = (Button) findViewById(R.id.ICC_SUL); 
            icc_sul.setBackgroundResource(R.drawable.bt_botoes_anim);
            icc_sul.setOnClickListener(new View.OnClickListener() {
    	        public void onClick(View conq) {   

    	        	//Banco de Dados
    	        	boolean verificador;
    	        	verificador = db.visit(1);
    	        	verifica(verificador);
    	        	
    	        	//terminado essa atividade
    	        	finish();
    	   
    	        	//passando argumentos e chamando a nova atividade
    	        	startActivity(new Intent(Indice.this, Build_Options.class)
    	        	.putExtra("foto_predio", R.drawable.foto_icc)
    	        	.putExtra("nome","ICC - SUL")
    	        	.putExtra("info_predio", 1)
					.putExtra("num_pavimentos", 3));
    	        }
           });    
            
            //ICC - CENTRO
            Button icc_centro = (Button) findViewById(R.id.ICC_CENTRO); 
            icc_centro.setBackgroundResource(R.drawable.bt_botoes_anim);
            icc_centro.setOnClickListener(new View.OnClickListener() {
    	        public void onClick(View conq) {   
    	        	
    	        	//Banco de Dados
    	        	boolean verificador;
    	        	verificador = db.visit(2);
    	        	verifica(verificador);
    	        	
    	        	//finalizando esta atividade
    	        	finish();
    	        	
    	        	//passando argumentos para a proxima
    	        	startActivity(new Intent(Indice.this, Build_Options.class)
    	        	.putExtra("foto_predio", R.drawable.foto_icc)
    	        	.putExtra("nome","ICC - CENTRO")
    	        	.putExtra("info_predio", 2)
					.putExtra("num_pavimentos", 3));
    	        }
           });
            
            //ICC - NORTE
            Button icc_norte = (Button) findViewById(R.id.ICC_NORTE); 
            icc_norte.setBackgroundResource(R.drawable.bt_botoes_anim);
            icc_norte.setOnClickListener(new View.OnClickListener() {
    	        public void onClick(View conq) {   
    	        	
    	        	//Banco de Dados
    	        	boolean verificador;
    	        	verificador = db.visit(3);
    	        	verifica(verificador);
    	        	
    	        	//finalizando esta atividade
    	        	finish();
    	        	
    	        	//passando argumentos para a procima atividade
    	        	startActivity(new Intent(Indice.this, Build_Options.class)
    	        	.putExtra("foto_predio", R.drawable.foto_icc)
    	        	.putExtra("nome","ICC - NORTE")
    	        	.putExtra("info_predio", 3)
					.putExtra("num_pavimentos", 3));
    	        }
           });  
            
            //FA
            Button fa = (Button) findViewById(R.id.FA);  
            fa.setBackgroundResource(R.drawable.bt_botoes_anim);
            fa.setOnClickListener(new View.OnClickListener() {
    	        public void onClick(View conq) {   
    	        	
    	        	//Banco de Dados
    	        	boolean verificador;
    	        	verificador = db.visit(10);
    	        	verifica(verificador);

    	        	//finalizando esta atividade
    	        	finish();
    	        	
    	        	//passando para a proxima atividade
    	        	startActivity(new Intent(Indice.this, Build_Options.class)
    	        	.putExtra("foto_predio", R.drawable.foto_fa)
    	        	.putExtra("nome","FA")
    	        	.putExtra("info_predio", 4)
					.putExtra("num_pavimentos", 2));
    	        }
           });  
            
            //FE
            Button fe = (Button) findViewById(R.id.FE);
            fe.setBackgroundResource(R.drawable.bt_botoes_anim);
            fe.setOnClickListener(new View.OnClickListener() {
    	        public void onClick(View conq) {

    	        	//Banco de Dados
    	        	boolean verificador;
    	        	verificador = db.visit(12);
    	        	verifica(verificador);
    	        	
    	        	//finalizando esta atividade
    	        	finish();
    	        	
    	        	//passando argumentos para a proxima
    	        	startActivity(new Intent(Indice.this, Build_Options.class)
    	        	.putExtra("foto_predio", R.drawable.foto_fe)
    	        	.putExtra("nome","FE")
    	        	.putExtra("info_predio", 5)
					.putExtra("num_pavimentos", 4));
    	        }
           });              
            //FMFS
            
            Button fmfs = (Button) findViewById(R.id.FMFS);
            fmfs.setBackgroundResource(R.drawable.bt_botoes_anim);
            fmfs.setOnClickListener(new View.OnClickListener() {  
        	        public void onClick(View conq) {   
        	 
        	        	//Banco de Dados
        	        	boolean verificador;
        	        	verificador = db.visit(7);
        	        	verifica(verificador);

        	        	//finalizando atividade
        	        	finish();
        	        	
        	        	//passando argumetos para a proxima
        	        	startActivity(new Intent(Indice.this, Build_Options.class)
        	        	.putExtra("foto_predio", R.drawable.foto_fmfs)
        	        	//.putExtra("predio", R.drawable.planta_fe1)
        	        	.putExtra("nome","FMFS")
        	        	.putExtra("info_predio", 6)
    					.putExtra("num_pavimentos", 4));
        	        }
               });                          
            
            
            //IB
            
            Button ib = (Button) findViewById(R.id.IB);
            ib.setBackgroundResource(R.drawable.bt_botoes_anim);
            ib.setOnClickListener(new View.OnClickListener() {  
    	        public void onClick(View conq) {   
    	        	
    	        	//Banco de Dados
    	        	boolean verificador;
    	        	verificador = db.visit(6);
    	        	verifica(verificador);

    	        	//finalizando atividade
    	        	finish();
    	        	
    	        	//passando argumetos para a proxima
    	        	startActivity(new Intent(Indice.this, Build_Options.class)
    	        	.putExtra("foto_predio", R.drawable.foto_ib)
    	        	//.putExtra("predio", R.drawable.planta_fe1)
    	        	.putExtra("nome","IB")
    	        	.putExtra("info_predio", 7)
					.putExtra("num_pavimentos", 3));
    	        }
           });            

            //IQ
            
            Button iq = (Button) findViewById(R.id.IQ);
            iq.setBackgroundResource(R.drawable.bt_botoes_anim);
            iq.setOnClickListener(new View.OnClickListener() {  
    	        public void onClick(View conq) {   
    	        	
    	        	//Banco de Dados
    	        	boolean verificador;
    	        	verificador = db.visit(9);
    	        	verifica(verificador);

    	        	//finalizando atividade
    	        	finish();
    	        	
    	        	//passando argumetos para a proxima
    	        	startActivity(new Intent(Indice.this, Build_Options.class)
    	        	.putExtra("foto_predio", R.drawable.foto_iq)
    	        	//.putExtra("predio", R.drawable.planta_fe1)
    	        	.putExtra("nome","IQ")
    	        	.putExtra("info_predio", 8)
					.putExtra("num_pavimentos", 2));
    	        }
           });              
            //PAT
            
            Button pat = (Button) findViewById(R.id.PAT);
            pat.setBackgroundResource(R.drawable.bt_botoes_anim);
            pat.setOnClickListener(new View.OnClickListener() {
    	        public void onClick(View conq) {   
    	        	
    	        	//Banco de Dados
    	        	boolean verificador;
    	        	verificador = db.visit(5);
    	        	verifica(verificador);

    	        	//finalizando atividade
    	        	finish();
    	        	
    	        	//passando argumetos para a proxima
    	        	startActivity(new Intent(Indice.this, Build_Options.class)
    	        	.putExtra("foto_predio", R.drawable.foto_pat)
    	        	//.putExtra("predio", R.drawable.planta_fe1)
    	        	.putExtra("nome","PAT")
    	        	.putExtra("info_predio", 9)
					.putExtra("num_pavimentos", 1));
    	        }
           });                          
            //PJC
            
            Button pjc = (Button) findViewById(R.id.PJC);
            pjc.setBackgroundResource(R.drawable.bt_botoes_anim);
            pjc.setOnClickListener(new View.OnClickListener() {
    	        public void onClick(View conq) {   
    	        	
    	        	//Banco de Dados
    	        	boolean verificador;
    	        	verificador = db.visit(4);
    	        	verifica(verificador);

    	        	//finalizando atividade
    	        	finish();
    	        	
    	        	//passando argumetos para a proxima
    	        	startActivity(new Intent(Indice.this, Build_Options.class)
    	        	.putExtra("foto_predio", R.drawable.foto_pjc)
    	        	//.putExtra("predio", R.drawable.planta_fe1)
    	        	.putExtra("nome","PJC")
    	        	.putExtra("info_predio", 10)
					.putExtra("num_pavimentos", 1));
    	        }
           });              
            //PMU 1
            
            Button pmu1 = (Button) findViewById(R.id.PMU1);
            pmu1.setBackgroundResource(R.drawable.bt_botoes_anim);
            pmu1.setOnClickListener(new View.OnClickListener() {
    	        public void onClick(View conq) {   
    	        	
    	        	//Banco de Dados
    	        	boolean verificador;
    	        	verificador = db.visit(8);
    	        	verifica(verificador);

    	        	//finalizando atividade
    	        	finish();
    	        	
    	        	//passando argumetos para a proxima
    	        	startActivity(new Intent(Indice.this, Build_Options.class)
    	        	.putExtra("foto_predio", R.drawable.foto_pmu1)
    	        	//.putExtra("predio", R.drawable.planta_fe1)
    	        	.putExtra("nome","PMU I")
    	        	.putExtra("info_predio", 11)
					.putExtra("num_pavimentos", 2));
    	        }
           });  			
            //PMU 2
            
            Button pmu2 = (Button) findViewById(R.id.PMU2);            
            pmu2.setBackgroundResource(R.drawable.bt_botoes_anim);
            pmu2.setOnClickListener(new View.OnClickListener() {
    	        public void onClick(View conq) {   
    	        	
    	        	//Banco de Dados
    	        	boolean verificador;
    	        	verificador = db.visit(13);
    	        	verifica(verificador);

    	        	//finalizando atividade
    	        	finish();
    	        	
    	        	//passando argumetos para a proxima
    	        	startActivity(new Intent(Indice.this, Build_Options.class)
    	        	.putExtra("foto_predio", R.drawable.foto_pmu2)
    	        	//.putExtra("predio", R.drawable.planta_fe1)
    	        	.putExtra("nome","PMU II")
    	        	.putExtra("info_predio", 12)
					.putExtra("num_pavimentos", 2));
    	        }
           }); 
            //BCE
            
            Button bce = (Button) findViewById(R.id.BCE);
            bce.setBackgroundResource(R.drawable.bt_botoes_anim);
            bce.setOnClickListener(new View.OnClickListener() {
    	        public void onClick(View conq) {   
    	        	
    	        	//Banco de Dados
    	        	boolean verificador;
    	        	verificador = db.visit(14);
    	        	verifica(verificador);

    	        	//finalizando atividade
    	        	finish();
    	        	
    	        	//passando argumetos para a proxima
    	        	startActivity(new Intent(Indice.this, Build_Options.class)
    	        	.putExtra("foto_predio", R.drawable.foto_bce)
    	        	//.putExtra("predio", R.drawable.planta_fe1)
    	        	.putExtra("nome","BCE")
    	        	.putExtra("info_predio", 13)
					.putExtra("num_pavimentos", 3));
    	        }
           }); 
			//FT
			  
			Button ft = (Button) findViewById(R.id.FT);
            ft.setBackgroundResource(R.drawable.bt_botoes_anim);
			ft.setOnClickListener(new View.OnClickListener() {
    	        public void onClick(View conq) {   
    	        	
    	        	//Banco de Dados
    	        	boolean verificador;
    	        	verificador = db.visit(11);
    	        	verifica(verificador);
    	        	//finalizando atividade
    	        	finish();
    	        	
    	        	//passando argumetos para a proxima
    	        	startActivity(new Intent(Indice.this, Build_Options.class)
    	        	.putExtra("foto_predio", R.drawable.foto_ft)
    	        	//.putExtra("predio", R.drawable.planta_fe1)
    	        	.putExtra("nome","FT")
    	        	.putExtra("info_predio", 14)
					.putExtra("num_pavimentos", 2));
    	        }
           });  	
           //Reitoria
			Button reitoria = (Button) findViewById(R.id.REITORIA);
            reitoria.setBackgroundResource(R.drawable.bt_botoes_anim);
			reitoria.setOnClickListener(new View.OnClickListener() {
    	        public void onClick(View conq) {   
    	        	
    	        	//Banco de Dados
    	        	boolean verificador;
    	        	verificador = db.visit(15);
    	        	verifica(verificador);

    	        	//finalizando atividade
    	        	finish();
    	        	
    	        	//passando argumetos para a proxima
    	        	startActivity(new Intent(Indice.this, Build_Options.class)
    	        	.putExtra("foto_predio", R.drawable.foto_reitoria)
    	        	.putExtra("nome","REITORIA")
    	        	.putExtra("info_predio", 15)
					.putExtra("num_pavimentos", 5));
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
        	this.startActivity(new Intent(Indice.this,MainMap.class));  
        }  
        return true;  
    }
    
    void verifica(boolean verificador)
    {
    	
    }
}
