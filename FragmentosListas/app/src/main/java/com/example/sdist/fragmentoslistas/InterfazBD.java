package com.example.sdist.fragmentoslistas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

/**
 * Created by sdist on 04/05/2017.
 */
public class InterfazBD {

    private ConexionBD cnn;
    private SQLiteDatabase db;

    public InterfazBD(Context context){
        cnn = new ConexionBD(context);
    }

    public void open() throws SQLiteException{
        db = cnn.getWritableDatabase();
    }

    public void close() throws SQLiteException{
        cnn.close();
    }

    public long insertarDatos(String dato){
        ContentValues valores = new ContentValues();
        open();
        valores.put("datos", dato);
        long clave = db.insert("tablaprueba", null, valores);
        close();
        return clave;
    }

    public void insertarDatosPrueba(){
        ContentValues valores = new ContentValues();
        open();
        valores.put("datos","hola");
        valores.put("datos","como");
        valores.put("datos","estas");
        db.insert("taablaprueba", null, valores);
    }

    public String traerDato(long clave){
        open();
        String claveString = Long.toString(clave);
        String query = "select * from tablaprueba where id =" + claveString + ";";

        Cursor c = db.rawQuery(query, null);
        c.moveToNext();
        String res = c.getString(1);
        c.close();
        close();
        return res;
    }

    public Cursor trearDatos(){
        open();
        String query = "select * from tablaprueba";
        Cursor ret = db.rawQuery(query, null);
        if(ret.getCount() == 0){
            insertarDatosPrueba();
            ret = db.rawQuery(query, null);
        }

        return ret;
    }

}
