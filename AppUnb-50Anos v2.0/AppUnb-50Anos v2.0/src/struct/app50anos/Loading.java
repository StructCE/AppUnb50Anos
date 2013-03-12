package struct.app50anos;

import DataBase.BDAdapterAchivments;
import DataBase.BDAdapterBuilds;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Loading extends Activity implements Runnable 
{

	boolean existBdBuilds;
	boolean existBdAchivments;
	//boolean existDbFavorites;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
        //Abrindo o Banco de Dados
		final BDAdapterBuilds dbBuilds = new BDAdapterBuilds(this);
		final BDAdapterAchivments dbAchivments = new BDAdapterAchivments(this);
        dbBuilds.open();
        dbAchivments.open();
        
		//verificando se os banco de dados exitem
		existBdBuilds = dbBuilds.verify();
		existBdAchivments = dbAchivments.verify();

		//se sim segura por 3 segundos
		if(existBdBuilds && existBdAchivments)
		{
			//Segurar por 3 segundos
			Handler h = new Handler();
			h.postDelayed(this, 2000);
		}

		//se nao inicia e penche o banco de dados
		else
		{
			//criando o 
			if(!existBdBuilds)
			{
				this.createBD(dbBuilds);
			}
			if(!existBdAchivments)
			{
				this.createBD(dbAchivments);
			}
		}
		dbBuilds.close();
        dbAchivments.close();
        
	}

	public void run()
	{
		//finalizando a atividade
		finish();
		onDestroy();

		//Iniciando a proxima atividade
		startActivity(new Intent(this, MainMenu.class));

		//gerando o efeito de transiçao
		overridePendingTransition(R.anim.fade_out, R.anim.fade_in);

	}

	public void createBD(BDAdapterBuilds bd)
	{
		bd.add(getResources().getStringArray(R.array.ICC_SUL));
		bd.add(getResources().getStringArray(R.array.ICC_CENTRO));
		bd.add(getResources().getStringArray(R.array.ICC_NORTE));
		bd.add(getResources().getStringArray(R.array.FA));
		bd.add(getResources().getStringArray(R.array.FE));	
		bd.add(getResources().getStringArray(R.array.FMFS));			
		bd.add(getResources().getStringArray(R.array.IB));			
		bd.add(getResources().getStringArray(R.array.IQ));	
		bd.add(getResources().getStringArray(R.array.PAT));			
		bd.add(getResources().getStringArray(R.array.PJC));			
		bd.add(getResources().getStringArray(R.array.PMU1));				
		bd.add(getResources().getStringArray(R.array.PMU2));
		bd.add(getResources().getStringArray(R.array.BCE));	
		bd.add(getResources().getStringArray(R.array.FT));			
		bd.add(getResources().getStringArray(R.array.REITORIA));	
		bd.add(getResources().getStringArray(R.array.RU));	
	}

	public void createBD(BDAdapterAchivments bd)
	{

	}
}
