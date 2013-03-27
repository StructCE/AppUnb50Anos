package gm.unb;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ViewFlipper;


@SuppressLint("Registered")
public class Saiba_Mais extends Activity {

	Button botao1,botao2,botao3; 
	ViewFlipper flipper;
	int posicao_atual=0;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{		
		//
		super.onCreate(savedInstanceState);
		setContentView(R.layout.texto); 
        
        //Pega o endereço passado do EspecificMap
        final int info_predio = getIntent().getIntExtra("info_predio",1);
        //Resgata Array
        String[] predio = ResgataTexto(info_predio);
        //Altera dados
       
        AlteraDados(predio);
}
	
	//Pega o array do strings.xml para substituir nas informações, param. vem da Indice;
	
	private String[] ResgataTexto(int predio){
		switch (predio) {
		case 1:	
			return getResources().getStringArray(R.array.ICC_SUL);
		case 2:
			return getResources().getStringArray(R.array.ICC_CENTRO);
		case 3:
			return getResources().getStringArray(R.array.ICC_NORTE);
		case 4:	
			return getResources().getStringArray(R.array.FA);
		case 5:
			return getResources().getStringArray(R.array.FE);	
		case 6:
			return getResources().getStringArray(R.array.FMFS);			
		case 7:
			return getResources().getStringArray(R.array.IB);			
		case 8:
			return getResources().getStringArray(R.array.IQ);	
		case 9:
			return getResources().getStringArray(R.array.PAT);			
		case 10:
			return getResources().getStringArray(R.array.PJC);			
		case 11:
			return getResources().getStringArray(R.array.PMU1);				
		case 12:
			return getResources().getStringArray(R.array.PMU2);
		case 13:
			return getResources().getStringArray(R.array.BCE);	
		case 14:
			return getResources().getStringArray(R.array.FT);			
		case 15:
			return getResources().getStringArray(R.array.REITORIA);	
		case 16:
			return getResources().getStringArray(R.array.RU);	
		}	
			return null;
		
	}
	
	//Usa uma array de prédio para substituir os valores da informação
	private void AlteraDados(String[] info){
		TextView predio = (TextView) findViewById(R.id.predio);
		predio.setText(info[0]);
		predio.setTextColor(Color.WHITE);
		predio.setTextSize(25.0f);
		TextView historico = (TextView) findViewById(R.id.historico);
		historico.setText(info[1]);
		historico.setTextColor(Color.LTGRAY);
		historico.setTextSize(20.0f);
		TextView reitor = (TextView) findViewById(R.id.reitor);
		reitor.setText(info[2]);
		reitor.setTextColor(Color.LTGRAY);
		reitor.setTextSize(20.0f);
		TextView departamentos = (TextView) findViewById(R.id.departamentos);
		departamentos.setText(info[3]);
		departamentos.setTextColor(Color.LTGRAY);
		departamentos.setTextSize(20.0f);
	}
}