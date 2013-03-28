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
	static private String TABELA = "achivments";

	static private Context context = null; 
	static private DatabaseHelper DBHelper;
	static private SQLiteDatabase db;

	static private String COLUNAID = "id";
	static private String COLUNANVISITAS = "nvisitas";
	static private String COLUNAESTATE = "estado";
	static private String COLUNANOME = "nome";

	public DBAdapter(Context context)
	{
		if (context == null)
		{
			this.context = context;
			DBHelper = new DatabaseHelper(context);
		}
	}

	public DBAdapter()
	{
		if (context == null)
		{
			//deu merda
		}
	}

	private DBAdapter connect()
	{
		db = DBHelper.getWritableDatabase();
		return this;
	}

	private void desconnect()
	{
		DBHelper.close();
	}

	private boolean insert(Predio predio)
	{
		ContentValues initialValues = new ContentValues();

		//initialValues.put(COLUNAID, predio.getId());
		initialValues.put(COLUNANVISITAS, predio.getVisitNumber());
		initialValues.put(COLUNAESTATE, predio.getEstate());
		initialValues.put(COLUNANOME, predio.getNome());

		return db.insert(TABELA, null, initialValues) > 0;
	}

	private boolean remove(Predio predio)
	{
		return db.delete(TABELA, COLUNAID + "=" + predio.getId(), null) > 0;
	}

	private boolean update(Predio predio)
	{
		ContentValues values = new ContentValues();

		values.put(COLUNANVISITAS, predio.getVisitNumber());
		values.put(COLUNAESTATE, predio.getEstate());
		values.put(COLUNANOME, predio.getNome());

		return db.update(TABELA, values, COLUNAID + "=" + predio.getId(), null) > 0;
	}

	private Predio findById(Predio predio) throws SQLException 
	{
		Predio novo = new Predio();
		String[] todos = new String[] {COLUNAID,COLUNANVISITAS, COLUNANOME, COLUNAESTATE};
		Cursor mCursor = db.query(true, TABELA , todos , COLUNAID + "=" + predio.getId(),	null, null, null, null, null);
		if (mCursor != null) {
			mCursor.moveToFirst();
		}else
		{
			return null;
		}
		int coluna = mCursor.getColumnIndex(COLUNAID);
		novo.setId(mCursor.getInt(coluna));

		coluna = mCursor.getColumnIndex(COLUNANVISITAS);
		novo.setVisitNumber(mCursor.getInt(coluna));

		coluna = mCursor.getColumnIndex(COLUNAESTATE);
		novo.setEstate(mCursor.getInt(coluna));	


		coluna = mCursor.getColumnIndex(COLUNANOME);
		novo.setNome(mCursor.getString(coluna));

		return novo;
	}

	private Predio findByNome(Predio predio) throws SQLException 
	{
		Predio novo = new Predio();
		String[] todos = new String[] {COLUNAID,COLUNANVISITAS, COLUNANOME};
		Cursor mCursor = db.query(true, TABELA , todos , COLUNANOME + "=" + predio.getNome(),	null, null, null, null, null);
		if (mCursor != null) {
			mCursor.moveToFirst();
		}else
		{
			return null;
		}
		int coluna = mCursor.getColumnIndex(COLUNAID);
		novo.setId(mCursor.getInt(coluna));

		coluna = mCursor.getColumnIndex(COLUNANVISITAS);
		novo.setVisitNumber(mCursor.getInt(coluna));

		coluna = mCursor.getColumnIndex(COLUNAESTATE);
		novo.setEstate(mCursor.getInt(coluna));

		coluna = mCursor.getColumnIndex(COLUNANOME);
		novo.setNome(mCursor.getString(coluna));

		return novo;
	}

	private Predio[] findVisits() throws SQLException
	{
		Predio novo = new Predio();
		String[] todos = new String[] {COLUNAID,COLUNANVISITAS, COLUNANOME};
		Cursor mCursor = db.query(true, TABELA , todos , COLUNANOME + "!= 0",	null, null, null, null, null);
		Predio[] array = null;
		Predio[] time = null;
		int i = 1;

		if (mCursor != null) {
			mCursor.moveToFirst();
		}else{
			return null;
		}

		do
		{
			time  = array;

			array = new Predio[i];
			for(int p = 0; p < time.length; p++)
			{
				array[p] = time[p];
			}

			int coluna = mCursor.getColumnIndex(COLUNAID);
			novo.setId(mCursor.getInt(coluna));

			coluna = mCursor.getColumnIndex(COLUNANVISITAS);
			novo.setVisitNumber(mCursor.getInt(coluna));

			coluna = mCursor.getColumnIndex(COLUNANOME);
			novo.setNome(mCursor.getString(coluna));
			array[i] = novo;
			i++;

		}while(!mCursor.isLast());

		return array;
	}

	public boolean visit(int id)
	{
		Predio novo = new Predio();
		novo.setId(id);
		connect();
		try
		{
			novo = findById(novo);
			int n = novo.getVisitNumber()+1;
			novo.setVisitNumber(n);
			desconnect();
			update(novo);
			if (n > 1){
				return false;
			}else{
				return true;
			}
		}catch (SQLException e){
			desconnect();
			return false;
		}
	}

	public int getNumberOfVisits()
	{
		connect();
		try
		{
			Predio[] novo = findVisits();
			desconnect();
			return novo.length;
		}catch (SQLException e){
			desconnect();
			return -1;
		}	
	}

	public Predio[] getNewConquists()
	{
		int j = 0;
		connect();

		try
		{
			Predio[] novo = findVisits();
			Predio[] time = null;
			Predio[] timeI = null;
			Predio doUp;

			for(int i = 0; i < novo.length; i++)
			{
				if(novo[i].getEstate() == -1)
				{
					timeI = time;
					time = new Predio[j+1];

					for(int p = 0; p < time.length; p++)
					{
						timeI[p] = time[p];
					}

					time[j] =  novo[i];
					doUp = novo[i];
					doUp.setEstate(1);
					if(!update(doUp))
					{
						return null;
					}
					j++;
				}
			}

			desconnect();
			return time;
		}catch (SQLException e){
			desconnect();
			return null;
		}
	}

	public boolean start()
	{
		String[] todos = new String[] {COLUNAID,COLUNANVISITAS, COLUNANOME, COLUNAESTATE};
		Cursor mCursor = db.query(true, TABELA , todos , COLUNAID + "= 5",	null, null, null, null, null);
		if(mCursor != null)
		{
			return true;
		}
		else
		{
			insert(new Predio(0, 0, 0, "ICCSUL")); 		//1
			insert(new Predio(0, 0, 0, "ICCCENTRO"));	//2
			insert(new Predio(0, 0, 0, "ICCNORTE"));	//3
			insert(new Predio(0, 0, 0, "PJC"));			//4
			insert(new Predio(0, 0, 0, "PAT"));			//5
			insert(new Predio(0, 0, 0, "IB"));			//6
			insert(new Predio(0, 0, 0, "FMS"));			//7
			insert(new Predio(0, 0, 0, "PMU1"));			//8
			insert(new Predio(0, 0, 0, "IQ"));			//9
			insert(new Predio(0, 0, 0, "FA"));			//10
			insert(new Predio(0, 0, 0, "FT"));			//11
			insert(new Predio(0, 0, 0, "FE"));	//12
			insert(new Predio(0, 0, 0, "PMU2"));	//13
			insert(new Predio(0, 0, 0, "BCE"));	//14
			insert(new Predio(0, 0, 0, "REITORIA"));	//14
			return true;
		}    	
	}


}

