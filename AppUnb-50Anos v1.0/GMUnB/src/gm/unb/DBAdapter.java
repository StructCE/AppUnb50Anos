package gm.unb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
 
public class DBAdapter 
{
    public static final String KEY_ROWID = "_id";
    public static final String KEY_ACH = "ach";
    public static final String KEY_STATE = "state";  
    public static final String KEY_COUNT = "count";
    private static final String TAG = "DBAdapter";
 
    private static final String DATABASE_NAME = "achiviments";
    private static final String DATABASE_TABLE = "titles";
    private static final int DATABASE_VERSION = 1;
 
    private static final String DATABASE_CREATE =
        "create table titles (_id integer primary key autoincrement, "
        + "ach text not null, " 
        + "state text not null, count number not null);";
 
    private final Context context; 
 
    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;
 
    public DBAdapter(Context ctx) 
    {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }
 
    private static class DatabaseHelper extends SQLiteOpenHelper 
    {
        DatabaseHelper(Context context) 
        {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }
 
        @Override
        public void onCreate(SQLiteDatabase db) 
        {
            db.execSQL(DATABASE_CREATE);
        }
 
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, 
        int newVersion) 
        {
            Log.w(TAG, "Upgrading database from version " + oldVersion 
                    + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS titles");
            onCreate(db);
        }
    }    
 
    //---opens the database---
    public DBAdapter open() throws SQLException 
    {
        db = DBHelper.getWritableDatabase();
        return this;
    }
 
    //---closes the database---    
    public void close() 
    {
        DBHelper.close();
    }
 
    //---insert a title into the database---
    public long insertTitle(String ach, String state, int count) 
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_ACH, ach);
        initialValues.put(KEY_STATE, state);
        initialValues.put(KEY_COUNT, count);
        return db.insert(DATABASE_TABLE, null, initialValues);
    }
 
    //---deletes a particular title---
    public boolean deleteTitle(long rowId) 
    {
        return db.delete(DATABASE_TABLE, KEY_ROWID + 
        		"=" + rowId, null) > 0;
    }
 
    //---retrieves all the titles---
    public Cursor getAllTitles() 
    {
        return db.query(DATABASE_TABLE, new String[] {
        		KEY_ROWID, 
        		KEY_ACH,
        		KEY_STATE,
        		KEY_COUNT}, 
                null, 
                null, 
                null, 
                null, 
                null);
    }
 
    //---retrieves a particular title---
    public Cursor getTitle(long rowId) throws SQLException 
    {
        Cursor mCursor =
                db.query(true, DATABASE_TABLE, new String[] {
                		KEY_ROWID,
                		KEY_ACH, 
                		KEY_STATE,
                		KEY_COUNT}, 
                		KEY_ROWID + "=" + rowId, 
                		null,
                		null, 
                		null, 
                		null, 
                		null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }
 
    //---updates a title---
    public boolean updateTitle(long rowId, 
    String state) 
    {
        ContentValues args = new ContentValues();
        args.put(KEY_STATE, state);
        return db.update(DATABASE_TABLE, args, 
                         KEY_ROWID + "=" + rowId, null) > 0;
    }
    
    public boolean updateCounter(long rowId, 
    	    int count) 
    	    {
    	        ContentValues args = new ContentValues();
    	        args.put(KEY_COUNT, count);
    	        return db.update(DATABASE_TABLE, args, 
    	                         KEY_ROWID + "=" + rowId, null) > 0;
    	    }
    
	
    
    public String storeTitle (Cursor c){
    	String dado;
    	
    	dado = c.getString(2);
    	
    	return dado;
    	
    }
    
    public int storeCount (Cursor c){
    	int dado;
    	
    	dado = c.getInt(3);
    	
    	return dado;
    	
    }
    
  public void createBd(DBAdapter db){
    	long id;
    	db.open();
    	id = db.insertTitle("ICCS", "HOLD",0); //1
    	id = db.insertTitle("ICCC", "HOLD",0); //2
    	id = db.insertTitle("ICCN", "HOLD",0); //3
    	id = db.insertTitle("FA", "HOLD",0); //4
    	id = db.insertTitle("FE", "HOLD",0); //5
    	id = db.insertTitle("FMFS", "HOLD",0); //6
    	id = db.insertTitle("IB", "HOLD",0); //7
    	id = db.insertTitle("IQ", "HOLD",0); //8
    	id = db.insertTitle("PAT", "HOLD",0); //9
    	id = db.insertTitle("PJC", "HOLD",0); //10
    	id = db.insertTitle("PMU1", "HOLD",0); //11
    	id = db.insertTitle("PMU2", "HOLD",0); //12
    	id = db.insertTitle("BCE", "HOLD",0); //13
    	id = db.insertTitle("FT", "HOLD",0); //14
    	id = db.insertTitle("REIT", "HOLD",0); //15
    	id = db.insertTitle("COUNTER", "HOLD",0); //16
    	db.close();
    }
   
    
  //se o nome no BD for igual a CHECK, retorna 1, se for igual a HOLD, retorna 0
  public void updateBd(long id, DBAdapter db){
  	db.open();
  	updateTitle(id, "CHECK");	
  	
  }   public int checkBD(long id){
  	Cursor c;
  	String nome;
  	
  	c = getTitle(id);
  	nome = storeTitle(c);
  	
  	if(nome == "CHECK"){
  		db.close();
  		return 1;
  	}
  	else if(nome == "HOLD"){
  		db.close();
  		return 0;
  	}
  	else{
  		db.close();
  		return 2;
  	}
  }
  
  //checkUpdateBd -- poe o predio com "id", no estado check, se o retorno da função checkBD for igual a 0 e aumenta +1 no contador
  public int checkUpdateBd(long id,DBAdapter db){
  	db.open();
  	int retorno;
  	int num;
  	int var;
  	
  	retorno = checkBD(id);
  	
  	if(retorno == 0){
  		updateTitle(id, "CHECK");
  		num = editCount(db);
  		var = verificaCount(num);
  		db.close();
  		return var;
  	}
  	else{
  		db.close();
  		return 0;
  	}
  	
  	
  }
  
  //editCount -- adiciona +1 ao contador dos achievements
  public int editCount(DBAdapter db){
  	db.open();
  	Cursor c;
  	int num;
  	
  	c = getTitle(16);
  	num = storeCount(c);
  	
  	num+=1;
  	
  	updateCounter(16,num);
  	db.close();
  	
  	return num;
  }
    
    public int verificaCount(int num){
    	
    	if(num == 1 || num == 3 || num == 6 || num == 9 || num == 13){
    		return 1;
    	}
    	else{
    		return 0;
    	}
    	
    	
    	
    }
    
    
}

