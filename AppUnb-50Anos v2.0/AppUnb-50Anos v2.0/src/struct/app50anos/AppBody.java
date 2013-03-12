package struct.app50anos;

import struct.app50anos.R;
import BasicTypes.Andar;
import BasicTypes.Foto;
import DataBase.BDAdapterBuilds;
import Entities.Predio;
import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class AppBody extends Activity {
	int i = 0;
	String[] nomePartes = new String[] {"a", "b", "c", "d", "f", "g", "h"};
	String[] nomeAndares = new String[] {"subsolo", "terreo", "andar_1", "andar_2", "andar_3", "andar_4", "andar_5"};
	int numeroMaximoAndares = 7;
	int numeroMaximoPartes = 7;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {

		// Mostrar tela
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_appbody);
	}

	public void run() {
		// fazendo um vetor com todos os predios
		ImageButton[] button = new ImageButton[] { (ImageButton) findViewById(R.id.bt_cred) };
		//fazendo um vetor com o nome dos predios que estao no bd
		final String[] nomePredios = new String[]{"icc_sul", "icc_centro", "icc_norte"};
		
		//setando como o primeiro predio o xml
			// contruindo uma nova entidade predio
			Predio predio = buildPredioWithBD(nomePredios[i]);		
			//passando para o xml atividade
			passClass2Xml(predio);

		//fazendo o linstener de todos os predios	
		for (i = 0; i < 13; i++) {
			button[i].setOnClickListener(new View.OnClickListener() {
				public void onClick(View cred) {
					// contruindo uma nova entidade predio
					Predio predio = buildPredioWithBD(nomePredios[i]);
					
					//passando para o xml atividade
					passClass2Xml(predio);

				}
			});
		}
	}
	
	public void passClass2Xml(Predio predio){
		
		LinearLayout principal = (LinearLayout) findViewById(R.id.appbody);
		principal.setBackgroundResource(predio.capa.id);
		
		
		//setar o texto
		
		//passar o argumetno para a pluxima classe
		//fazer os listeners padroes
		
		//fazer os botoes para os andares
		//setar os listeners destes
		
	}
	
	public Predio buildPredioWithBD(String nome)
	{
		//trabalhando no banco de dados
		final BDAdapterBuilds bd = new BDAdapterBuilds(this);
		bd.open();
		String[] valores = bd.get(nome);
		bd.close();
		
		//contruindo a classe e setando os valores de nome
		Predio predio = new Predio();
		predio.nomeNoBD = valores[0];
		
		//valores principais da classe
		predio.titulo = valores[1];
		predio.reitorVigente = valores[4];
		predio.departamentos = valores[3];
		predio.descricao = valores[2];
		
		//pegando os andares
		Andar[] andares = new Andar[numeroMaximoAndares];
		
		for(int i= 0; i < numeroMaximoAndares;i++)
		{
			//nome andar
			String recurso;
			andares[i].nome =  valores[0] + nomeAndares[i];
			
			//foto
			int resourceId = Resources.getSystem().getIdentifier(andares[i].nome, "drawable", "android");
			
			//se a foto nao geral nao existe nao existe andar
			if(resourceId == 0)
			{
				andares[i]= null;
			}
			else
			{
				//setando o id da foto geral
				andares[i].id = resourceId;
				
				//pegando o id das partes qual nao existirem seram setadas como 0;
				int[] partes = new int[numeroMaximoPartes];
				for (int j = 0; j < numeroMaximoPartes; i++)
				{
					recurso =  andares[i].nome + "_parte_" + nomePartes[j];
					partes[j] = Resources.getSystem().getIdentifier(recurso, "drawable", "android");
				}
				andares[i].partes = partes;
			}
			
		}
		//pegando as fotos do predio
		//fundo
		Foto fundo = new Foto();
		fundo.nome = valores[0] + "_background";
		fundo.id = Resources.getSystem().getIdentifier(fundo.nome, "drawable", "android");
		predio.capa = fundo;
		
		//outras fotos
		int numeroDeFotos = Integer.parseInt(valores[5]);
		Foto[] fotos = new Foto[numeroDeFotos]; 
		for (int j =0; j < numeroDeFotos; j++)
		{
		  fotos[j].nome = valores[0] + "_foto_" + j;
		  fotos[j].id = Resources.getSystem().getIdentifier(fotos[j].nome, "drawable", "android");
		}
		predio.fotos = fotos;
		
		return predio;
	}
}