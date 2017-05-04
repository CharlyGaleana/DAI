package com.example.psdist.introbd;

import android.app.ListFragment;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class FragmentoLista extends ListFragment {

	InterfazBD iBD;
	Cursor res;
	SimpleCursorAdapter sca;
	ListView lv;
	
	/* (non-Javadoc)
	 * @see android.app.ListFragment#onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
	 */
	@SuppressWarnings("deprecation")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v=super.onCreateView(inflater, container, savedInstanceState);

		String []arregloColumnas={"_id","datos"};
		//Textviews del renglon donde se van a guardar los datos
		int []to={R.id.texto1,R.id.texto2};
		//crear conexion con la bd
		iBD=new InterfazBD(this.getActivity());
		//crear cursor de la bd con los resultados de la tabla
		res=iBD.traerTodosDatos();
		//Pasarle el cursor a la actividad
		//startManagingCursor(res);
		//Crear el adaptador para mostrar los datos
		sca=new SimpleCursorAdapter(this.getActivity(),R.layout.formato_renglon,
				res,arregloColumnas,to,0);
		//Pegar el adaptador a la lista
		this.setListAdapter(sca);		
		
		
		return v;
	}

	/* (non-Javadoc)
	 * @see android.app.ListFragment#onListItemClick(android.widget.ListView, android.view.View, int, long)
	 */
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		//super.onListItemClick(l, v, position, id);
		if(iBD==null){
			iBD=new InterfazBD(this.getActivity());
		}
		String s=iBD.traerDato(id);
		Toast t=Toast.makeText(getActivity(),s, 5);
		t.show();
	}

	
	
}
