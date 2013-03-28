package gm.unb;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

public class Busca_Dep extends Activity  implements TextWatcher{
	AutoCompleteTextView myAutoComplete;
	String departamentos[]={
					  /*ICC*/"(DAN) Departamento de Antropologia", "(CIC) Departamento de Ci�ncia da Computa��o", "(CIS) Departamento de Ci�ncias Sociais", "(EST) Departamento de Estat�stica",
					  "(FIL) Departamento de Filosofia", "(GEA) Departamento de Geografia", "(HIS) Departamento de Hist�ria", "(LET) Departamento de L�nguas Estrangeiras e Tradu��o",
					  "(LIP) Departamento de Ling��stica, Portugu�s", "(MAT) Departamento de Matem�tica", "(PPB) Departamento de Processos Psicologicos B�sicos", "(PRO) Departamento de Projetos Express�o e Representa��o",
					  "(PED) Departamento de Psic.Escolar e do Desenvolvimento", "(PCL) Departamento de Psicologia Cl�nica", "(PST) Departamento de Psicologia Social e do Trabalho",
					  "(SER) Departamento de Servi�o Social", "(SOL) Departamento de Sociologia", "(TEC) Departamento de Tecnologia em Arquit. e Urbanismo", "(TEL) Departamento de Teoria Liter�ria e Literatura",
					  "(THAU) Depto.de Teoria e Hist.em Arquitetura e Urbanismo", "(FACE) Faculd. de Economia, Administra��o e Contabilidade", "FAV) Faculdade de Agronomia e Medicina Veterin�ria",
					  "(DAP) Departamento de Audiovisuais e Publicidade", "(JOR) Departamento de Jornalismo", "(IFD) Instituto de F�sica" , "(IGD) Instituto de Geoci�ncias", "(ECO) Departamento de Economia",
					  /*FA*/	
					  "(CCA) Depto de Ci�ncias Cont�beis e Atuariais", "(FDD) Faculdade de Direito", "(IPOL) Instituto de Ci�ncia Pol�tica", "(IREL) Instituto de Rela��es Internacionais",
					  "(FACE) Faculd. de Economia, Administra��o e Contabilidade"
			
	};


	  
@Override
   public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.departamentos);

       myAutoComplete = (AutoCompleteTextView)findViewById(R.id.myautocomplete);
       Toast.makeText(Busca_Dep.this, "Hello Toast",Toast.LENGTH_SHORT).show();
       myAutoComplete.addTextChangedListener(this);
       myAutoComplete.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, departamentos));
       myAutoComplete.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           /**
            * Called when a new item is selected (in the Spinner)
            */
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                   // An spinnerItem was selected. You can retrieve the selected item using
                    int i = myAutoComplete.getListSelection();
                    startActivity(new Intent(Busca_Dep.this, Conquistas.class));
                   Toast.makeText(Busca_Dep.this, i,Toast.LENGTH_LONG).show();

               }

               public void onNothingSelected(AdapterView<?> parent) {
                   // Do nothing, just another required interface callback
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
    	this.startActivity(new Intent(Busca_Dep.this,Conquistas.class));
    	overridePendingTransition(R.anim.move_up, 0);
    }  
    return true;  
}

	public void afterTextChanged(Editable s) {
		// TODO Auto-generated method stub
		
	}

	public void beforeTextChanged(CharSequence s, int start, int count,
			int after) {
		// TODO Auto-generated method stub
		
	}

	public void onTextChanged(CharSequence s, int start, int before, int count) {
		// TODO Auto-generated method stub
		
	}
}
