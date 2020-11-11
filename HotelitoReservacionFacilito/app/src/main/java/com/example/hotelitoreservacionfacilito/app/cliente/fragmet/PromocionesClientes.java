package com.example.hotelitoreservacionfacilito.app.cliente.fragmet;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hotelitoreservacionfacilito.R;
import com.example.hotelitoreservacionfacilito.adapters.Cliente.RecyclerPromocionCliente;
import com.example.hotelitoreservacionfacilito.models.Promocion;
import com.example.hotelitoreservacionfacilito.models.PromocionHabitacion;
import com.example.hotelitoreservacionfacilito.service.PromocionHabitacionService;
import com.example.hotelitoreservacionfacilito.service.PromocionService;

import java.util.ArrayList;
import java.util.List;


public class PromocionesClientes extends Fragment {

    TextView tvpromocionesclientes;
    ImageView descuentoicono;
    RecyclerView rvpromocioncliente;

    PromocionesClientetask promocionesClientetask = new PromocionesClientetask();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_promociones_clientes, container, false);
        final View view = inflater.inflate(R.layout.fragment_promociones_clientes, container, false);
        tvpromocionesclientes = view.findViewById(R.id.tvpromocionesclientes);
        descuentoicono = view.findViewById(R.id.descuentoicono);
        rvpromocioncliente = view.findViewById(R.id.rvpromocioncliente);

        promocionesClientetask.execute();
        return view;
    }

    public void reiniciarAsysnc(){
        promocionesClientetask.cancel(true);
        promocionesClientetask = new PromocionesClientetask();
    }

    public class PromocionesClientetask extends AsyncTask<String,String, List<PromocionHabitacion>> {

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected List<PromocionHabitacion> doInBackground(String... strings) {
            List<PromocionHabitacion> listapromocionhabitaciones = new ArrayList<>();
            try {
                PromocionHabitacionService promocionHabitacionService = new PromocionHabitacionService();
                listapromocionhabitaciones = promocionHabitacionService.obtenerPromocionHabitacions();
                System.out.println("Lista traida PromocionHabitacion : "+listapromocionhabitaciones.toString());
            }catch (Exception e){
                System.out.println("Error al traer la lista de Promociones: " +e.getMessage());
            }
            return listapromocionhabitaciones;
        }

        @Override
        protected void onPostExecute(List<PromocionHabitacion> promocionHabitacions) {
            super.onPostExecute(promocionHabitacions);
            try {
                if(!promocionHabitacions.isEmpty()){
                    RecyclerPromocionCliente apater = new RecyclerPromocionCliente
                            (promocionHabitacions, getParentFragment());
                    rvpromocioncliente.setLayoutManager(new GridLayoutManager(getContext(), 2));
                    rvpromocioncliente.setAdapter(apater);

                }
                reiniciarAsysnc();
            }catch (Exception e){
                System.out.println("Error al imprimir la lista de PromocionesHabitaciones" +
                        " en el Modulo Cliente: " +e.getMessage());
            }
        }
    }
}