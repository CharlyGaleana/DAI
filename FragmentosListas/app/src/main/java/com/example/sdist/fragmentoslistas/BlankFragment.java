package com.example.sdist.fragmentoslistas;


import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {

    private Button agregar;
    private EditText dato;
    InterfazBD iBD;
    FragmentManager fm;

    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_blank, container, false);

        agregar = (Button) v.findViewById(R.id.btAgregar);
        dato = (EditText) v.findViewById(R.id.datoUsuario);
        fm = this.getActivity().getFragmentManager();

        /*
        agregar.setOnClickListener();

        public void onClick(View v){
            iBD = new InterfazBD(v.getContext());

    }*/

        return v;
    }

}
