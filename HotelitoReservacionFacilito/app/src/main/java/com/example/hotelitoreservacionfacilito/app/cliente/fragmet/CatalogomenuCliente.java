package com.example.hotelitoreservacionfacilito.app.cliente.fragmet;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hotelitoreservacionfacilito.Logued;
import com.example.hotelitoreservacionfacilito.R;


public class CatalogomenuCliente extends Fragment {

    TextView textView7Usuario;
    public CatalogomenuCliente() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewglobal= inflater.inflate(R.layout.fragment_catalogomenu_cliente, container, false);


        return viewglobal;
    }
}