package com.example.hotelitoreservacionfacilito.app.cliente.fragmet;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hotelitoreservacionfacilito.Logued;
import com.example.hotelitoreservacionfacilito.R;
import com.example.hotelitoreservacionfacilito.adapters.Cliente.RecycleReservasClientes;
import com.example.hotelitoreservacionfacilito.models.Reserva;
import com.example.hotelitoreservacionfacilito.service.ReservaService;

import java.util.ArrayList;
import java.util.List;


public class MisreservasClientes extends Fragment {

    TextView tvTituloreservascliente;
    RecyclerView rvmisreservascliente;
    MisreservasClientesTask misreservasClientesTask = new MisreservasClientesTask();

    public MisreservasClientes() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View viewglobal = inflater.inflate(R.layout.fragment_misreservas_clientes, container, false);
        tvTituloreservascliente = viewglobal.findViewById(R.id.tvTituloreservascliente);
        rvmisreservascliente = viewglobal.findViewById(R.id.rvmisreservascliente);

        misreservasClientesTask.execute();
        return  viewglobal;
    }

    public void reiniciarAsysnc(){
        misreservasClientesTask.cancel(true);
        misreservasClientesTask = new MisreservasClientesTask();
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
                ReservaService reservaService = new ReservaService();
                lista = reservaService.reservaCliente(String.valueOf(Logued.clienteLogued.getIdCliente()));
                System.out.println("Lista traida: "+lista.toString());
            }catch (Exception e){
                System.out.println("Error al traer la lista de mis reservas: " +e.getMessage());
            }
            return lista;
        }

        @Override
        protected void onPostExecute(List<Reserva> reservas) {
            super.onPostExecute(reservas);
            try {
                if (!reservas.isEmpty()) {
                    RecycleReservasClientes recycleReservasClientes = new RecycleReservasClientes(reservas, getParentFragment());
                    rvmisreservascliente.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
                    rvmisreservascliente.setAdapter(recycleReservasClientes);
                }
                reiniciarAsysnc();
            }catch (Exception e){
                System.out.println("Error al imprimir la lista de Mi Reserva: " +e.getMessage());
            }
        }
    }
}