package com.example.sdist.ejemplobasesdedatos;

import android.content.ContentValues;
import android.content.ContextWrapper;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText nom, car, uni, cu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nom = (EditText) findViewById(R.id.etNom);
        car = (EditText) findViewById(R.id.etCarrera);
        uni = (EditText) findViewById(R.id.etUni);
        cu = (EditText) findViewById(R.id.etCu);
    }

    public void limpiar(View v){
        cu.setText("");
        nom.setText("");
        uni.setText("");
        car.setText("");
    }

    public void alta(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Administracion", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase(); //permisos de escritura a la base da datos

        String clave = cu.getText().toString();
        String nombre = nom.getText().toString();
        String universidad = uni.getText().toString();
        String carrera = car.getText().toString();

        ContentValues registro = new ContentValues();
        registro.put("cu", clave);
        registro.put("nombre", nombre);
        registro.put("carrera", carrera);
        registro.put("universidad", universidad);

        db.insert("alumnos", null, registro);
        db.close();
        limpiar(v);
        Toast.makeText(this, "Se agregaron los datos a la base.", Toast.LENGTH_LONG).show();
    }

    public void consultar(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Administracion", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase(); //permisos de escritura a la base da datos

        String clave = cu.getText().toString();
        Cursor fila = db.rawQuery("select nombre, carrera, universidad from alumnos where cu=" + clave, null);
        if (fila.moveToFirst()) {
            nom.setText(fila.getString(0));
            car.setText(fila.getString(1));
            uni.setText(fila.getString(2));
        } else {
            Toast.makeText(this, "no existe la clave unica", Toast.LENGTH_LONG).show();
        }
    }

    public void baja(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Administracion", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase(); //permisos de escritura a la base da datos

        String clave = cu.getText().toString();

        int cant = db.delete("alumnos", "cu=" + clave, null);
        if(cant == 1)
            Toast.makeText(this, "Se borró al alumno de la base", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this, "No se pudo borrar al alumno de la base", Toast.LENGTH_LONG).show();

        db.close();
        limpiar(v);
    }

    public void modificar(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Administracion", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase(); //permisos de escritura a la base da datos
        String clave, nombre, carrera, univ;

        clave = cu.getText().toString();
        nombre = nom.getText().toString();
        carrera = car.getText().toString();
        univ = uni.getText().toString();

        ContentValues registro = new ContentValues();
        registro.put("nombre", nombre);
        registro.put("carrera", carrera);
        registro.put("universidad", univ);

        int cant = db.update("alumnos",registro, "cu=" + clave, null);
        if(cant == 1)
            Toast.makeText(this, "Se modificaron los datos", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this, "No se pudo hacer la modificación", Toast.LENGTH_LONG).show();

        db.close();
        limpiar(v);
    }


}
