package com.example.sdist.fragmentoslistas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by sdist on 04/05/2017.
 */
public class ConexionBD extends SQLiteOpenHelper{

    private String cadenaCreate = "create table if not exists tablaprueba(id integer primary key autoincrement, datos text not null)";
    private String cadenaUpdate = "drop table if exists tablaprueba";

    public ConexionBD(Context context) {
        super(context, "prueba.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(cadenaCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(cadenaUpdate);
        onCreate(db);
    }

}
