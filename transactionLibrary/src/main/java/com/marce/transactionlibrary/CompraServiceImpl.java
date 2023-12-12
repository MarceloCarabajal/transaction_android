package com.marce.transactionlibrary;

import android.widget.Toast;

public class CompraServiceImpl implements CompraService{
    @Override
    public void compra(String importe, String numeroTarjeta){
        //ver la logica para manejar la compra
        Toast.makeText(MainActivity.this, "Compra exitosa!", Toast.LENGTH_SHORT).show();
    }
}
