package com.example.sdist.navfrag20;

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

    FragmentManager fm;
    FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        f1=new Fragmento1();

        fm=this.getFragmentManager();
        ft=fm.beginTransaction();
        ft.add(R.id.espacioFragmento,f1);
        ft.commit();

        boton1=(Button)this.findViewById(R.id.buttonF1);
        boton2=(Button)this.findViewById(R.id.buttonF2);
        boton3=(Button)this.findViewById(R.id.buttonF3);

        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(fm.findFragmentById(R.id.espacioFragmento)!=f1){
                    ft=fm.beginTransaction();
                    ft.replace(R.id.espacioFragmento,f1);
                    ft.commit();
                }

            }
        });

        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                f2=new Fragmento2();
                ft=fm.beginTransaction();
                ft.replace(R.id.espacioFragmento,f2);
                ft.commit();
            }
        });

        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                f3=new Fragmento3();
                ft=fm.beginTransaction();
                ft.replace(R.id.espacioFragmento,f3);
                ft.commit();
            }
        });
    }
}
