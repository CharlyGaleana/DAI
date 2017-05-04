package com.example.sdist.navfrag20;


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
public class Fragmento1 extends Fragment {


    public Fragmento1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_fragmento1, container, false);
        //Aqui va mi codigo del fragmento
        boton=(Button)v.findViewById(R.id.buttonDolares);
        res=(TextView)v.findViewById(R.id.resultadoDolares);
        dato=(EditText)v.findViewById(R.id.datoDolares);

        boton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                double dolares=0;
                dolares= Double.parseDouble(dato.getTexy().toString())/19.05;
                res.setText(""+dolares);
            }        });
        return v;
    }

}
