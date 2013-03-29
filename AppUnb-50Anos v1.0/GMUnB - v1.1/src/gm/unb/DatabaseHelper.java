package gm.unb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{
	
	private static String SCHEMA_NAME = "GUIAMOCHILEIRO";
	private static int SCHEMA_VERSION = 1;
	
	private static String TABLE1 = "ACHIVMENTS";
	
	private static String CREATESCHEMASCRIPT = "CREATE SCHEMA";
	
	
	private static String CREATETABLESCRIPT = "CREATE TABLE Pais" +
	"(	id INTEGER UNSIGNED PRIMARY KEY AUTO_INCREMENT," +
	"		nvisitas INTEGER,"+
	"		estado INTEGER,"+
	"		nome varchar(45),"+
	");";
	
	DatabaseHelper(Context context) {
		super(context, SCHEMA_NAME, null, SCHEMA_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATESCHEMASCRIPT + "IF NOT EXISTS " + SCHEMA_NAME);
		db.execSQL(CREATETABLESCRIPT + "IF NOT EXISTS " + TABLE1);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		//Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
		///		+ newVersion + ", which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS " + TABLE1);
		onCreate(db);
	}
}
