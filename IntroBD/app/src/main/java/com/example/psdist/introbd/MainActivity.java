package com.example.psdist.introbd;

import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

public class MainActivity extends Activity {

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		FragmentManager fm=getFragmentManager();
		FragmentTransaction ft=fm.beginTransaction();
		
		Fragment fl=new FragmentoLista();
		ft.add(R.id.actividadPrincipal, fl);
		ft.commit();
	}
}
