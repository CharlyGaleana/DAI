package com.example.psdist.navegacionfragmentos;


import android.os.Bundle;
import android.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragmento1 extends Fragment {

    //Declarar los elementos de la interfaz grafica para poder trabajar con ellos
    Button boton;
    TextView res;
    EditText dato;
    //Declarar fragmento
    Bundle itacate;

    public Fragmento1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Comentar esta linea para que podamos poner acciones entre la creacion
        // de la vista y el regreso del metodo
        //return inflater.inflate(R.layout.fragment_fragmento1, container, false);
        View v =inflater.inflate(R.layout.fragment_fragmento1, container, false);

        //Aquí programo el código del fragmento

        //Buscar los elementos en la vista que acabo de inflar
        boton=(Button)v.findViewById(R.id.buttonDolares);
        res=(TextView)v.findViewById(R.id.resultadoDolares);
        dato=(EditText)v.findViewById(R.id.datoDolares);

        //Sacar el argumeno del itacate
        itacate=this.getArguments();
        dato.setText(this.getArguments().getString("convertir"));

        //Asignar el escuchador al boton
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double dolares=0;
                dolares=Double.parseDouble(dato.getText().toString())/19.05;
                res.setText(""+dolares);
                String valor=dato.getText().toString();
                itacate.putString("convertir",valor);
            }
        });

        //Regresar la vista que inflamos al principio
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();

        itacate = this.getArguments();
        String valor=itacate.getString("convertir");
        dato.setText(valor);
    }
}
