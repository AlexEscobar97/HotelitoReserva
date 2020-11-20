package com.example.hotelitoreservacionfacilito.app.cliente.fragmet;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hotelitoreservacionfacilito.R;
import com.example.hotelitoreservacionfacilito.models.Reserva;

import java.util.ArrayList;
import java.util.List;


public class MisreservasClientes extends Fragment {

    TextView tvTituloreservascliente;
    RecyclerView rvmisreservascliente;

    public MisreservasClientes() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View viewglobal = inflater.inflate(R.layout.fragment_misreservas_clientes, container, false);

        return  viewglobal;
    }

    public class MisreservasClientesTask extends AsyncTask<String,String, List<Reserva>>{

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected List<Reserva> doInBackground(String... strings) {
            List<Reserva> lista = new ArrayList<>();
            try {

            }catch (Exception e){
                System.out.println("Error al traer la lista de mis reservas: " +e.getMessage());
            }
            return null;
        }

        @Override
        protected void onPostExecute(List<Reserva> reservas) {
            super.onPostExecute(reservas);
        }
    }
}