package struct.guia.mochileiro;


import struct.guia.mochileiro.R;
import android.os.Bundle;
import android.util.FloatMath;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageView;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Matrix;
import android.graphics.PointF;


//Menu Principal
public class MainMap extends Activity implements OnTouchListener {
                
        //variables     
                //Valores para passar para o EspecificMap
				Bundle predio = new Bundle();
				int local = -1;
				
				//Tag String
                private static final String TAG = "Touch";
                
                // These matrices will be used to move and zoom image
                Matrix matrix = new Matrix();
                Matrix savedMatrix = new Matrix();
                
                // We can be in one of these 3 states
                static final int NONE = 0;
                static final int DRAG = 1;
                static final int ZOOM = 2;
                int mode = NONE;
                
                // Remember some things for zooming
                PointF start = new PointF();
                PointF mid = new PointF();
                
                //start distance
                float oldDist = 1f;
                ImageView viewB; 
        //finish the variables declaration
                
        @Override
        public void onCreate(Bundle savedInstanceState)
        {

                //Doing he Instance
                super.onCreate(savedInstanceState);
           
                //Set image 1(Foto)
                setContentView(R.layout.mapa_principal);
                viewB = (ImageView) findViewById(R.id.campus);
        
                //Set image Click.Mask(just colors)
                //ImageView mask = (ImageView) findViewById(R.id.campusmap)
                ImageView view = (ImageView) findViewById(R.id.campus);
                Button indice = (Button) findViewById(R.id.indice);
                indice.setBackgroundResource(R.drawable.bt_botoes2_anim);
                indice.setOnClickListener(new View.OnClickListener() {
        	        public void onClick(View mapa) {
        		        finish();
        	        	startActivity(new Intent(MainMap.this, Indice.class));
        				//Efeito de Transição
        				overridePendingTransition(R.anim.move_left, 0);
        	        }
                });
                
                
                //Zoom on Images
                //view.setLayoutParams(new GridView.LayoutParams(85, 85));
                view.setScaleType(ImageView.ScaleType.FIT_CENTER);
                view.setOnTouchListener(this);
                
                //Listener The Clicks and Call the next Screen
                
                
                
                //Depuration tools

        }

        public boolean onTouch(View v, MotionEvent event) {
            
                //variaveis de click
                boolean handledHere = false; 
            //final int action = event.getAction();
            //final int evX = (int) event.getX();
            //final int evY = (int) event.getY();
            
            //variaveis de escala
            float scale;
  
            //variavies universais
                ImageView view = (ImageView) v;
                view.setScaleType(ImageView.ScaleType.MATRIX);
                
        
                // Dump touch event to log
                // Handle touch events here...
                switch (event.getAction() & MotionEvent.ACTION_MASK)
                {
                        //first finger down only
                        case MotionEvent.ACTION_DOWN: 
                                savedMatrix.set(matrix);
                                start.set(event.getX(), event.getY());
                                Log.d(TAG, "mode=DRAG" );
                                mode = DRAG;
                                break;
                        //first finger lifted
                        case MotionEvent.ACTION_UP:
                        
                        //second finger lifted
                        case MotionEvent.ACTION_POINTER_UP: 
                                mode = NONE;
                                Log.d(TAG, "mode=NONE" );
                                break;
                    
                        //second finger down
                        case MotionEvent.ACTION_POINTER_DOWN: 
                        oldDist = spacing(event);
                        Log.d(TAG, "oldDist=" + oldDist);
                        if (oldDist > 5f) {
                                savedMatrix.set(matrix);
                                midPoint(mid, event);
                                mode = ZOOM;
                                Log.d(TAG, "mode=ZOOM" );
                        }
                        break;
                
                   case MotionEvent.ACTION_MOVE: 
                      //movement of first finger
                      if (mode == DRAG) 
                      {
                         matrix.set(savedMatrix);
                         if (view.getLeft() >= -392)
                         {
                                 //find the limits
                                 
                                 //if under the limits, move
                                 matrix.postTranslate(event.getX() - start.x, event.getY() - start.y);
                         }
                      }
                      //pinch zooming
                      else if (mode == ZOOM)
                      { 
                    	  float newDist = spacing(event);
                         Log.d(TAG, "newDist=" + newDist);
                         if (newDist > 5f)
                         {
                            matrix.set(savedMatrix);
                            //thinking i need to play around with this value to limit it**
                            scale = newDist / oldDist;
                            matrix.postScale(scale, scale, mid.x, mid.y);
                         }
                      }
                      break;
                }
        
                // Perform the transformation
                view.setImageMatrix(matrix);
                viewB.setImageMatrix(matrix);
                //if is a click
            if (handledHere) {
                //doing the call of the functions here
            }
                
                //indicate event was handled
                return true;
        }
        
        private float spacing(MotionEvent event)
        {
                float x = event.getX(0) - event.getX(1);
                float y = event.getY(0) - event.getY(1);
                return FloatMath.sqrt(x * x + y * y);
        }
        
        private void midPoint(PointF point, MotionEvent event)
        {
                float x = event.getX(0) + event.getX(1);
                float y = event.getY(0) + event.getY(1);
                point.set(x / 2, y / 2);
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
            	this.startActivity(new Intent(MainMap.this,MainMenu.class));  
            }  
            return true;  
        }
}