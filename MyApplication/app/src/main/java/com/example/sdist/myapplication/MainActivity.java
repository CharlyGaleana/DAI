package com.example.sdist.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = (EditText) findViewById(R.id.etNum1);
        num2 = (EditText) findViewById(R.id.etNum2);
    }

    public void sumar(View v){
        int numero1, numero2, suma;
        numero1 = Integer.parseInt(num1.getText().toString());
        numero2 = Integer.parseInt(num2.getText().toString());

        suma = numero1 + numero2;
        mostrar(suma);
    }

    public void mostrar(int res){
        Toast.makeText(this, "el resultado es: " + res, Toast.LENGTH_LONG).show();
    }
}
