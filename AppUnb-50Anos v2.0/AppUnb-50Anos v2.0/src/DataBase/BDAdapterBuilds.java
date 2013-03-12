package DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class BDAdapterBuilds {
	// vairiaveis finais
	
	public static final String KEY_ROWID = "_id";
	
	public static final String[] KEYS =new String[] { "nomepredio", "textonomepredio", "textodopredio",
											"departamentos", "reitor", "numeroDeFotos"};
	final int numberOfterms = KEYS.length;
	
	private static final String TAG = "DBAdapter";

	private static final String DATABASE_NAME = "STRUCTBASE";
	private static final String DATABASE_TABLE = "builds";
	private static final int DATABASE_VERSION = 1;

	private static final String DATABASE_CREATE = "create table" + DATABASE_TABLE + "("
			+ "_id integer primary key autoincrement, "
			+ KEYS[0] +" text not null, " 
			+ KEYS[1] + " text, "
			+ KEYS[2] +" text, " 
			+ KEYS[3] +" text, "
			+ KEYS[4] +" text, " 
			+ KEYS[5] +" text);";
	private final Context context;

	// variaveis
	private DatabaseHelper DBHelper;
	private SQLiteDatabase dbBuild;
	private int prenchido = 1;

	// Metodos
	public BDAdapterBuilds(Context ctx) {
		this.context = ctx;
		DBHelper = new DatabaseHelper(context);
	}

	private class DatabaseHelper extends SQLiteOpenHelper {
		DatabaseHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL(DATABASE_CREATE);
			prenchido = 0;
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			if (oldVersion != newVersion) {
				prenchido = 0;
			}
			Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
					+ newVersion + ", which will destroy all old data");
			db.execSQL("DROP TABLE IF EXISTS titles");
			onCreate(db);
		}
	}

	public BDAdapterBuilds open() throws SQLException {
		dbBuild = DBHelper.getWritableDatabase();
		return this;
	}

	public void close() {
		DBHelper.close();
	}

	public boolean verify() {
		if (prenchido == 0) {
			return false;
		} else {
			// temos que verificar se ja foi realmente prenchida
			return true;
		}
	}

	public boolean add(String[] values) {
		
		ContentValues initialValues = new ContentValues();
		for(int i = 0; i < numberOfterms; i++ )
		{
			initialValues.put(KEYS[i], values[i]);
		}
		Long state = dbBuild.insert(DATABASE_TABLE, null, initialValues);
		
		if (state == -1) {
			return false;
		} else {
			return true;
		}
	}

	public boolean updateValues(String[] values){

		ContentValues newValues = new ContentValues();
		
		for(int i = 0; i < numberOfterms; i++ )
		{
			newValues.put(KEYS[i], values[i]);
		}
		
		int state = dbBuild.update(DATABASE_TABLE, newValues, KEYS[0] + "=" + values[0], null);
		
		if (state == -1) {
			return false;
		} else {
			return true;
		}
		
	}

	public String[] get(String nome) {
		Cursor c = dbBuild.query(DATABASE_TABLE, null, KEYS[0] + "=" + nome,  null, null, null, null); 
		if(c == null){
			return new String[]{"null"};
		}
		String[] tabela = new String[numberOfterms];
		for(int i = 0; i < numberOfterms; i++)
		{
			tabela[i] = c.getString(i+1);
		}
		return tabela;
	}
	
	//retorna todos os predios
}
