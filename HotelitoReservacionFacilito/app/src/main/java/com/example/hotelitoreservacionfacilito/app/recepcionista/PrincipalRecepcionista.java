package com.example.hotelitoreservacionfacilito.app.recepcionista;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.hotelitoreservacionfacilito.Logued;
import com.example.hotelitoreservacionfacilito.R;

public class PrincipalRecepcionista extends AppCompatActivity {

    TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_recepcionista);

        textView3 = findViewById(R.id.textView3);
        textView3.setText(Logued.usuarioEmpleadoLogued.getPersonal().getRol().getNombre_rol());
    }
}