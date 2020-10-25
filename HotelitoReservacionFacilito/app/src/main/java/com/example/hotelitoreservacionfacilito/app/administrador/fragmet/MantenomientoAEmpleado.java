package com.example.hotelitoreservacionfacilito.app.administrador.fragmet;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hotelitoreservacionfacilito.R;


public class MantenomientoAEmpleado extends Fragment {

    public MantenomientoAEmpleado() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mantenomiento_a_empleado, container, false);
    }
}