package com.example.psdist.introbd;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

public class InterfazBD {
	ConexionBD con;
	SQLiteDatabase db;
	
	public InterfazBD(Context context){
		con=new ConexionBD(context);
	}
	
	public void open() throws SQLiteException {
		db=con.getWritableDatabase();
	}
	
	public void close() throws SQLiteException {
		con.close();
	}
	
	public long insertarDatos(String dato){
		ContentValues valores;
		open();
		valores=new ContentValues();
		valores.put("datos",dato);
		long clave=db.insert("tablaprueba", null, valores);
		close();
		return clave;
	}
	
	public void insertarDatosPrueba(){
		ContentValues valores;
		open();
		
		valores=new ContentValues();
		valores.put("datos","hola");
		db.insert("tablaprueba", null, valores);
		valores=new ContentValues();
		valores.put("datos","como");
		db.insert("tablaprueba", null, valores);
		valores=new ContentValues();
		valores.put("datos","estas");
		db.insert("tablaprueba", null, valores);
		valores=new ContentValues();
		valores.put("datos","espero");
		db.insert("tablaprueba", null, valores);
		valores=new ContentValues();
		valores.put("datos","que");
		db.insert("tablaprueba", null, valores);
		valores=new ContentValues();
		valores.put("datos","bien");
		db.insert("tablaprueba", null, valores);
		valores=new ContentValues();
		valores.put("datos","adios");
		db.insert("tablaprueba", null, valores);
	}
	
	public String traerDato(long clave){
		open();
		String claveString=Long.toString(clave);
		String query="select * from tablaprueba where _id="+claveString+";";
		Cursor c=db.rawQuery(query,null);
		c.moveToNext();
		String res=c.getString(1);
		c.close();
		close();
		return res;
	}
	
	public Cursor traerTodosDatos(){
		Cursor res=null;
		open();
		String query="select * from tablaprueba;";
		res=db.rawQuery(query,null);
		if(res.getCount()==0){
			insertarDatosPrueba();
			res=db.rawQuery(query,null);
		}
		//cerrar bd?
		return res;
	}
}
