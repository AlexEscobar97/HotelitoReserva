package com.example.hotelitoreservacionfacilito.app.cliente.fragmet;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.hotelitoreservacionfacilito.R;
import com.example.hotelitoreservacionfacilito.adapters.Cliente.RecycleHabitacionClientes;
import com.example.hotelitoreservacionfacilito.adapters.RecycleHabitacion;
import com.example.hotelitoreservacionfacilito.models.Habitacion;
import com.example.hotelitoreservacionfacilito.service.HabitacionService;

import java.util.ArrayList;
import java.util.List;


public class HabitacionesCliente extends Fragment {

    TextView tvlistahabitaciones;
    ImageButton imghabitacioncliente;
    RecyclerView rvhabitacioncliente;
    RecycleHabitacionClientes adapter;
    View viewGlobal;
    HabitacionesClientesTask habitacionesClientesTask = new HabitacionesClientesTask();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_habitaciones_cliente, container, false);
        viewGlobal = inflater.inflate(R.layout.fragment_habitaciones_cliente, container, false);
        tvlistahabitaciones = viewGlobal.findViewById(R.id.tvlistahabitaciones);
        //imghabitacioncliente = view.findViewById(R.id.imghabitacioncliente);
        rvhabitacioncliente = viewGlobal.findViewById(R.id.rvhabitacioncliente);

        habitacionesClientesTask.execute();
        return viewGlobal;
    }

    public void reiniciarAsysnc(){
        habitacionesClientesTask.cancel(true);
        habitacionesClientesTask = new HabitacionesClientesTask();
    }

    public class HabitacionesClientesTask extends AsyncTask<String,String, List<Habitacion>>{

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected List<Habitacion> doInBackground(String... strings) {
            List<Habitacion> listahabitacion = new ArrayList<>();
            try {
                HabitacionService habitacionService = new HabitacionService();
                listahabitacion = habitacionService.obtenerHabitacions();
            }catch (Exception e){
                System.out.println("Error al traer la lista de Habitaciones: " +e.getMessage());
            }
            return listahabitacion;
        }

        @Override
        protected void onPostExecute(List<Habitacion> habitacions) {
            super.onPostExecute(habitacions);
            try {
                if(!habitacions.isEmpty()){
                    adapter = new RecycleHabitacionClientes(habitacions,viewGlobal.getContext(), getActivity());
                    //rvhabitacion.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
                    rvhabitacioncliente.setLayoutManager(new GridLayoutManager(getActivity(), 2));
                    rvhabitacioncliente.setAdapter(adapter);

                }
                reiniciarAsysnc();
            }catch (Exception e){
                System.out.println("Error al imprimir la lista de Habitaciones: " +e.getMessage());
            }
        }

    }
}