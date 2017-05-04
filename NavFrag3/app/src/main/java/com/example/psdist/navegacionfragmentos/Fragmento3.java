package com.example.psdist.navegacionfragmentos;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragmento3 extends Fragment {

    Button boton;
    TextView res;
    EditText dato;
    Bundle itacate;
    public Fragmento3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Inflar la interfaz grafica del fragmento, si no la inflo, no puedo ver
        //los elementos de la interfaz por que no existen
        View v=inflater.inflate(R.layout.fragment_fragmento3, container, false);
        //Buscar los elementos en la vista. La vista es la interfaz grafica del fragmento
        boton=(Button)v.findViewById(R.id.buttonLibras);
        res=(TextView)v.findViewById(R.id.resultadoLibras);
        dato=(EditText)v.findViewById(R.id.datoLibras);

        dato.setText(this.getArguments().getString("convertir"));

        //Definir el escuchador del boton para realizar la operacion
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double libras=0;
                libras=Double.parseDouble(dato.getText().toString())/24.15;
                res.setText(""+libras);
                String valor=dato.getText().toString();
                itacate.putString("convertir",valor);
            }
        });
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
