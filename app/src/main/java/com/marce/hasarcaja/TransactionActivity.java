package com.marce.hasarcaja;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TransactionActivity extends AppCompatActivity {

    EditText et_datos;
    Button btn_volver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);

        et_datos = findViewById(R.id.etDatos);
        et_datos.setEnabled(false);
        et_datos.setKeyListener(null);
        btn_volver = findViewById(R.id.btnVolver);

        String datosMostrar = "Importe: " + getIntent().getStringExtra("importe") +
                "\nTipo de tarjeta: "+ getIntent().getStringExtra("tipoTarjeta") +
                "\nTarjeta: " + getIntent().getStringExtra("tarjeta") ;

        et_datos.setText(datosMostrar);

        btn_volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volver();
            }
        });
    }

    public void volver(){
        finish();
    }
}