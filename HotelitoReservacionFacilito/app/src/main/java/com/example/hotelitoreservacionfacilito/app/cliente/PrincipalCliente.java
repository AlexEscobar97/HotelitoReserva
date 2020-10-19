package com.example.hotelitoreservacionfacilito.app.cliente;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.hotelitoreservacionfacilito.Logued;
import com.example.hotelitoreservacionfacilito.R;

public class PrincipalCliente extends AppCompatActivity {

    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_cliente);

        textView2 = findViewById(R.id.textView2);
        textView2.setText(Logued.clienteLogued.getNombre() +" " +Logued.clienteLogued.getApellido());
    }
}