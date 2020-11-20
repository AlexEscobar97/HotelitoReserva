package com.example.hotelitoreservacionfacilito.app.administrador.fragmet;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hotelitoreservacionfacilito.R;
import com.example.hotelitoreservacionfacilito.adapters.RecycleReservaciones;
import com.example.hotelitoreservacionfacilito.models.Reserva;
import com.example.hotelitoreservacionfacilito.service.ReservaService;

import java.util.ArrayList;
import java.util.List;

public class ListareservasAdministrador extends Fragment {

    TextView tvTituloreservasAdmin;
    RecyclerView rvlistareservasAdmin;

    ListareservasAdministradorTask listareservasAdministradorTask = new ListareservasAdministradorTask();
    public ListareservasAdministrador() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View viewglobal= inflater.inflate(R.layout.fragment_listareservas_administrador, container, false);
        tvTituloreservasAdmin = viewglobal.findViewById(R.id.tvTituloreservasAdmin);
        rvlistareservasAdmin = viewglobal.findViewById(R.id.rvlistareservasAdmin);

        listareservasAdministradorTask.execute();
        return  viewglobal;
    }

    public void reiniciarAsysnc(){
        listareservasAdministradorTask.cancel(true);
        listareservasAdministradorTask = new ListareservasAdministradorTask();
    }

    public class ListareservasAdministradorTask extends AsyncTask<String,String, List<Reserva>>{

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected List<Reserva> doInBackground(String... strings) {
            List<Reserva> lista = new ArrayList<>();
            try {
                ReservaService reservaService = new ReservaService();
                lista = reservaService.obtenerReservas();
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
                if (!reservas.isEmpty()){
                    RecycleReservaciones recycleReservaciones = new RecycleReservaciones(reservas, getParentFragment());
                    rvlistareservasAdmin.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
                    rvlistareservasAdmin.setAdapter(recycleReservaciones);
                }
                reiniciarAsysnc();
            }catch (Exception e){
                System.out.println("Error al imprimir la lista de Reservaciones: " +e.getMessage());
            }
        }
    }
}