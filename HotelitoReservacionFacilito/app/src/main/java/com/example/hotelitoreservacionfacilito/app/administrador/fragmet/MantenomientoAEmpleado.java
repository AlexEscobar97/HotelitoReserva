package com.example.hotelitoreservacionfacilito.app.administrador.fragmet;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.hotelitoreservacionfacilito.R;
import com.google.android.material.textfield.TextInputLayout;


public class MantenomientoAEmpleado extends Fragment {

    EditText edtNombreEmpleado,edtApellidoEmpleado,edtUsuarioEmpleado,edtClaveEmpleado;
    Spinner spinnerrol;
    Button btnAgregar;

    public MantenomientoAEmpleado() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_mantenomiento_a_empleado, container, false);
        View view = inflater.inflate(R.layout.fragment_mantenomiento_a_empleado, container, false);

        edtNombreEmpleado = view.findViewById(R.id.edtNombreEmpleado);
        edtApellidoEmpleado = view.findViewById(R.id.edtApellidoEmpleado);
        spinnerrol = view.findViewById(R.id.spinnerrol);
        edtUsuarioEmpleado = view.findViewById(R.id.edtUsuarioEmpleado);
        edtClaveEmpleado = view.findViewById(R.id.edtClaveEmpleado);

        btnAgregar = view.findViewById(R.id.btnAgregar);

        return view;
    }
}