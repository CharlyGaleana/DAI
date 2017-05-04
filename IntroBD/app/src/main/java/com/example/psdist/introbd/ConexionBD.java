package com.example.psdist.introbd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ConexionBD extends SQLiteOpenHelper {

	String cadenaCreate="create table if not exists tablaprueba (_id integer primary key autoincrement,datos text not null);";
	
	public ConexionBD(Context context) {
		super(context,"prueba.db", null, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {//puedo tener un drop table antes para que cada vex que se cree la tabla salga limpia
		// TODO Auto-generated method stub
		db.execSQL(cadenaCreate);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		String cadenaUpdate="drop table if exists tablaprueba;";
		db.execSQL(cadenaUpdate);
		onCreate(db);
	}

}
