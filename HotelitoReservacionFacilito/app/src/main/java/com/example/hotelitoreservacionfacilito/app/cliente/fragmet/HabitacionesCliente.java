package com.example.hotelitoreservacionfacilito.app.cliente.fragmet;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hotelitoreservacionfacilito.R;


public class HabitacionesCliente extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_habitaciones_cliente, container, false);
    }
}