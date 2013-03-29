package gm.unb;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;

//Conquistas
public class Conquistas extends Activity {
	
	private int nVisitados;
	private int nViUlt;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
		
    	//Mostrar tela
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conq);
        
        //estartando o banco de predios visitados
        DBAdapter db = new DBAdapter();
        
        //vendo os predios visitas
        nVisitados = db.getNumberOfVisits();
        
        //vendo os predios visitados desde a ultima conquista
        Predio[] time;
        time =  db.getNewConquists();
        nViUlt = time.length;
        
        //mostrando as novas conaquistas em um dialog
        veNovas(nViUlt, nVisitados);
        
        //mostrando as conquistas
        switch (nVisitados)
        {
        case 15:
        	//conquista 6
        case 14:
        case 13:
        case 12:
        	//conquista 5
        case 11:
        case 10:
        case 9:
        	//conquista 4
        case 8:
        case 7:
        case 6:
        	//conquista 3
        case 5:
        case 4:
        case 3:
        	//conquista 2
        case 2:
        	
        case 1:
        	//ru
        }

        
        
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
        	this.startActivity(new Intent(Conquistas.this,MainMenu.class));
        	overridePendingTransition(R.anim.move_up, 0);
        }  
        return true;  
    }
    
    void veNovas(int novas, int velhos)
    {
    	
    }
}
