package com.example.sdist.intents;

import android.content.Intent;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText txUno;
    private Button btSig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txUno = (EditText) findViewById(R.id.etNombre);
        btSig = (Button) findViewById(R.id.btSiguiente);
    }

    public void siguiente(View v){
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        Bundle b = new Bundle();
        b.putString("Nombre", txUno.getText().toString());
        intent.putExtras(b);
        startActivity(intent);
    }
}
