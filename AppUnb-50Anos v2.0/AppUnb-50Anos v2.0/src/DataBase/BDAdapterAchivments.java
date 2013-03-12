package DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class BDAdapterAchivments {

	// vairiaveis finais do bd
	public static final String[] KEYSA = new String[] { "name",
			"numberofvisits" };
	public static final String[] KEYSB = new String[] { "name", "stats" };
	public final int numberTermsA = KEYSA.length;
	public final int numberTermsB = KEYSB.length;

	public static final String[] STATE = new String[] {};

	private static final String TAG = "DBAdapter";

	private static final String DATABASE_NAME = "STRUCTBASE";
	private static final String DATABASE_TABLEA = "buildsvisits";
	private static final String DATABASE_TABLEB = "achivments";

	private static final int DATABASE_VERSION = 1;

	private static final String DATABASE_CREATEA = "create table"
			+ DATABASE_TABLEA + "(" + "_id integer primary key autoincrement, "
			+ KEYSA[0] + " text not null, " + KEYSA[1] + " text);";

	private static final String DATABASE_CREATEB = "create table"
			+ DATABASE_TABLEB + "(" + "_id integer primary key autoincrement, "
			+ KEYSB[0] + " text not null, " + KEYSB[1] + " text);";

	private final Context context;

	// variaveis
	private DatabaseHelper DBHelper;
	private SQLiteDatabase dbAchivments;
	private int prenchido = 1;

	// Metodos
	public BDAdapterAchivments(Context ctx) {
		this.context = ctx;
		DBHelper = new DatabaseHelper(context);
	}

	private class DatabaseHelper extends SQLiteOpenHelper {
		DatabaseHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL(DATABASE_CREATEA);
			db.execSQL(DATABASE_CREATEB);
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

	public BDAdapterAchivments open() throws SQLException {
		dbAchivments = DBHelper.getWritableDatabase();
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

	public boolean add(String tableName, String[] predios, String[] conquistas) {
		if (tableName.equals(DATABASE_TABLEA)) {
			ContentValues initialValues = new ContentValues();
			for (int i = 0; i < predios.length; i++) {
				initialValues.put(KEYSA[0], predios[i]);
				initialValues.put(KEYSA[1], "0");
			}
			Long state = dbAchivments.insert(DATABASE_TABLEA, null,
					initialValues);

			if (state == -1) {
				return false;
			} else {
				return true;
			}
		} else {
			ContentValues initialValues = new ContentValues();
			for (int i = 0; i < predios.length; i++) {
				initialValues.put(KEYSA[0], conquistas[i]);
				initialValues.put(KEYSA[1], STATE[0]);
			}
			Long state = dbAchivments.insert(DATABASE_TABLEA, null,
					initialValues);

			if (state == -1) {
				return false;
			} else {
				return true;
			}
		}
	}

	public boolean visit(String nome) {
		Cursor c = dbAchivments.query(DATABASE_TABLEA, null, KEYSA[0] + "="
				+ nome, null, null, null, null);
		if (c == null) {
			return false;
		}
		String[] tabela = new String[numberTermsA];
		for (int i = 0; i < numberTermsA; i++) {
			tabela[i] = c.getString(i + 1);
		}
		int numberVisits = Integer.parseInt(tabela[1]);
		tabela[1] = Integer.toString(numberVisits+1);
		
		ContentValues newValues = new ContentValues();
		
		for(int i = 0; i < numberTermsA; i++ )
		{
			newValues.put(KEYSA[i], tabela[i]);
		}
		
		int state = dbAchivments.update(DATABASE_TABLEA, newValues, KEYSA[0] + "=" + tabela[0], null);
		
		if (state == -1) {
			return false;
		}
		
		return true;
	}
	
	// verifdica quais as coquistas ja foram atingidas e retorna um lista com o
	// nome destas
	private String[] doAchivments() {

		return null;
	}
	
	// vai procurar todas com o estado 1 e setar essa como estado 2
	public boolean whatisNew() {
		doAchivments();
		return true;
	}

	// vei pegar todas as conquistas com estado 2
	public boolean whatisSet() {
		doAchivments();
		return true;
	}


}

