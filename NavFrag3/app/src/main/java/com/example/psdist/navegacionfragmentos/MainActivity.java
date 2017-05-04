package com.example.psdist.navegacionfragmentos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
//Clases para la administracion de fragmentos
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
//Clases para la administracion de fragmentos

public class MainActivity extends AppCompatActivity {

    Button boton1;
    Button boton2;
    Button boton3;

    Fragmento1 f1;
    Fragmento2 f2;
    Fragmento3 f3;

    //Declarar el espacio compartido para pasar variables entre fragmentos
    Bundle itacate;

    FragmentManager fm;
    FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Crear todos los fragmentos que voy a utilizar
        f1=new Fragmento1();
        f2=new Fragmento2();
        f3=new Fragmento3();

        //crear itacate
        itacate= new Bundle();
        itacate.putString("convertir", "0");// es la forma de ponerle datos al bundle

        //Asignar el bundle antes de cargar los fragmentos!!! si no, no lo puede leer
        //en este caso todos usan la misma variable para poder compartir datos
        f1.setArguments(itacate);
        f2.setArguments(itacate);
        f3.setArguments(itacate);

        //Clases para administrar el fragmento
        fm=this.getFragmentManager();
        //La transaccion me permite hacer operaciones con los fragmentos
        ft=fm.beginTransaction();
        //Cargar el fragmento1 en el espacioFragmento de la Actividad
        ft.add(R.id.espacioFragmento,f1);
        //Si no hago commit, la transaccion no se ejecuta!!!
        ft.commit();

        //Buscar los botones en la interfaz
        boton1=(Button)this.findViewById(R.id.buttonF1);
        boton2=(Button)this.findViewById(R.id.buttonF2);
        boton3=(Button)this.findViewById(R.id.buttonF3);

        //Asignar el escuchador al boton 1
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Verifico que el fragmento 1 no este cargado
                if(fm.findFragmentById(R.id.espacioFragmento)!=f1){
                    ft=fm.beginTransaction();
                    //Esta transaccion reemplaza en vez de agregar
                    ft.replace(R.id.espacioFragmento,f1);
                    //Siempre hago commit, si no no se ejecuta la transaccion
                    ft.commit();
                }
            }
        });

        //Asignar el escuchador al boton 2
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(fm.findFragmentById(R.id.espacioFragmento)!=f2) {
                    ft = fm.beginTransaction();
                    ft.replace(R.id.espacioFragmento, f2);
                    ft.commit();
                }
            }
        });

        //Asignar el escuchador al boton 3
        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(fm.findFragmentById(R.id.espacioFragmento)!=f3) {
                    ft = fm.beginTransaction();
                    ft.replace(R.id.espacioFragmento, f3);
                    ft.commit();
                }
            }
        });
    }

}
