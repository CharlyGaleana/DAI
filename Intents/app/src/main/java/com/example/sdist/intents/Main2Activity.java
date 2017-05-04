package com.example.sdist.intents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Main2Activity extends AppCompatActivity {

    private TextView txSaludo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txSaludo = (TextView) findViewById(R.id.tvHola);
        Bundle bundle = this.getIntent().getExtras();
        txSaludo.setText("Hola, " + bundle.get("Nombre"));
    }
}
