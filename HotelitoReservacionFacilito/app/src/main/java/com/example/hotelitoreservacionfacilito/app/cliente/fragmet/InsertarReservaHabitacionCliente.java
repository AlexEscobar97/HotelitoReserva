package com.example.hotelitoreservacionfacilito.app.cliente.fragmet;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.hotelitoreservacionfacilito.Logued;
import com.example.hotelitoreservacionfacilito.R;
import com.google.android.material.textfield.TextInputLayout;


public class InsertarReservaHabitacionCliente extends Fragment {

    View viewGlobal;
    EditText r_nombrecliente;
    TextInputLayout r_nombrecliente2;

    public InsertarReservaHabitacionCliente() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        viewGlobal= inflater.inflate(R.layout.fragment_insertar_reserva_habitacion_cliente, container, false);
        r_nombrecliente2 = viewGlobal.findViewById(R.id.r_nombrecliente);

        //r_nombrecliente2.setText(""+Logued.clienteLogued.getIdCliente()+" "+Logued.clienteLogued.getNombre() +" " +Logued.clienteLogued.getApellido());
        r_nombrecliente2.getEditText().setText(""+Logued.clienteLogued.getIdCliente()+" "+Logued.clienteLogued.getNombre() +" " +Logued.clienteLogued.getApellido());

        return  viewGlobal;
    }
}