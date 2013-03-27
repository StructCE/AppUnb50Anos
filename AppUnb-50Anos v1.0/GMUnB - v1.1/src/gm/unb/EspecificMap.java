package gm.unb;



import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.app.Activity;


//Menu Principal
public class EspecificMap extends Activity {

@Override
public void onCreate(Bundle savedInstanceState) {
   super.onCreate(savedInstanceState);
   setContentView(R.layout.mapa_especifico);
   //Abre o local onde será colocada a imagem
   WebView view = (WebView) findViewById(R.id.planta);
   //Pega a planta passada do Indice 
   final String imageId = getIntent().getStringExtra("planta");
   final StringBuilder s = new StringBuilder();    
   s.append("<html>");                             
   s.append("<body>");
   s.append(imageId);
   s.append("</body>");                            
   s.append("</html>");
   view.loadDataWithBaseURL(null, s.toString(), "text/html", "UTF-8", null);
   view.setInitialScale(100);
   WebSettings webSettings = view.getSettings();
   webSettings.setUseWideViewPort(true);
   view.getSettings().setBuiltInZoomControls(true);
}

}