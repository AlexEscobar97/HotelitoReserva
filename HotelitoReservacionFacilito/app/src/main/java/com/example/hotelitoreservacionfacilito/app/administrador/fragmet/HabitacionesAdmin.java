package com.example.hotelitoreservacionfacilito.app.administrador.fragmet;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotelitoreservacionfacilito.R;
import com.example.hotelitoreservacionfacilito.adapters.RecycleHabitacion;
import com.example.hotelitoreservacionfacilito.models.Habitacion;
import com.example.hotelitoreservacionfacilito.service.HabitacionService;

import java.util.ArrayList;
import java.util.List;


public class HabitacionesAdmin extends Fragment {

    TextView tvTituloHabitacion;
    Button btnAgregarHabitacion;
    RecyclerView rvhabitacion;

    Habitacionestask habitacionestask = new Habitacionestask();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_habitaciones_admin, container, false);
        final View view = inflater.inflate(R.layout.fragment_habitaciones_admin, container, false);
        tvTituloHabitacion = view.findViewById(R.id.tvTituloHabitacion);
        btnAgregarHabitacion = view.findViewById(R.id.btnAgregarHabitacion);
        rvhabitacion = view.findViewById(R.id.rvhabitacion);

       habitacionestask.execute();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        final NavController navController = Navigation.findNavController(view);

        btnAgregarHabitacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.mantenimientoAHabitacion);
            }
        });
    }

    public void reiniciarAsysnc(){
        habitacionestask.cancel(true);
        habitacionestask = new Habitacionestask();
    }

    public class Habitacionestask extends AsyncTask<String,String, List<Habitacion>>{

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
                    RecycleHabitacion adapter = new RecycleHabitacion(habitacions, getParentFragment());
                    //rvhabitacion.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
                    rvhabitacion.setLayoutManager(new GridLayoutManager(getContext(), 2));
                    rvhabitacion.setAdapter(adapter);
                }
                reiniciarAsysnc();
            }catch (Exception e){
                System.out.println("Error al imprimir la lista de Habitaciones: " +e.getMessage());
            }
        }
    }
}
