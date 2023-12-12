package com.marce.hasarcaja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_importe, et_tarjeta;
    Button btn_enviar;
    Spinner spTipoTarj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_importe = findViewById(R.id.etImporte);
        et_tarjeta =findViewById(R.id.etTarjeta);
        btn_enviar = findViewById(R.id.btnEnviar);
        spTipoTarj = findViewById(R.id.spTipoTarj);

        btn_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validar()){
                    registrar();
                    limpiar();
                }
            }
        });

    }

    private boolean validar(){
        String importeStr = et_importe.getText().toString();
        String tarjetaStr = et_tarjeta.getText().toString();

        if(importeStr.isEmpty() || tarjetaStr.isEmpty()){
            Toast.makeText(MainActivity.this, "Ingrese importe y Núm. de tarjeta", Toast.LENGTH_SHORT).show();
            return false;
        }
        try{
            //validar que el imp sea un num valido
            double importe = Double.parseDouble(importeStr);
        } catch (NumberFormatException e) {
            Toast.makeText(MainActivity.this, "Formato de importe no válido", Toast.LENGTH_SHORT).show();
            return false;
        }
        //validar formato de tarj (ej: 16 digitos numericos)
        if(!tarjetaStr.matches("\\d{16}")){
            Toast.makeText(MainActivity.this, "Formato de tarjeta no válido", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public void registrar(){
        Toast.makeText(MainActivity.this, "Datos correctos", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this, TransactionActivity.class);
        intent.putExtra("importe", et_importe.getText().toString());
        intent.putExtra("tipoTarjeta", String.valueOf(spTipoTarj.getSelectedItemId()));
        intent.putExtra("tarjeta", et_tarjeta.getText().toString());
        startActivity(intent);
    }

    public void limpiar(){
        et_importe.setText("");
        et_tarjeta.setText("");
        spTipoTarj.setSelection(0);
        et_importe.requestFocus();
    }

}