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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotelitoreservacionfacilito.R;
import com.example.hotelitoreservacionfacilito.adapters.RecyclerEmpleados;
import com.example.hotelitoreservacionfacilito.models.UsuarioEmpleado;
import com.example.hotelitoreservacionfacilito.service.UsuarioEmpleadoService;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;
//import com.example.hotelitoreservacionfacilito.app.administrador.R;

public class EmpleadoAdmin extends Fragment {

    TextView tvTituloEmpleado;
    Button btnAgregarEmpleado;
    RecyclerView rvEmpleados;

    EmpleadoTask empleadoTask = new EmpleadoTask();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_empleados_admin, container, false);
        final View view = inflater.inflate(R.layout.fragment_empleados_admin, container, false);
        final NavigationView navigationView = view.findViewById(R.id.nav_view);

        tvTituloEmpleado = view.findViewById(R.id.tvTitulo);
        btnAgregarEmpleado = view.findViewById(R.id.btnAgregarEmpleado);
        rvEmpleados = view.findViewById(R.id.rvEmpleados);

        empleadoTask.execute();
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        final NavController navController = Navigation.findNavController(view);

        btnAgregarEmpleado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.mantenomientoAEmpleado);
                //navigationView.findViewById(R.id.mobile_navigation).getContext().startActivity(); Se puede ocupar

            }
        });


    }

    public void reiniciarAsysnc(){
        empleadoTask.cancel(true);
        empleadoTask = new EmpleadoTask();
    }

    public class EmpleadoTask extends AsyncTask<String, String, List<UsuarioEmpleado>>{

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected List<UsuarioEmpleado> doInBackground(String... strings) {
            List<UsuarioEmpleado> listaempleado = new ArrayList<>();
            try {
                UsuarioEmpleadoService usuarioEmpleadoService = new UsuarioEmpleadoService();
                listaempleado = usuarioEmpleadoService.obtenerUsuarioEmpleados();

            }catch (Exception e){
                System.out.println("Error al traer la lista de Empleados: " +e.getMessage());
            }
            return listaempleado;
        }

        @Override
        protected void onPostExecute(List<UsuarioEmpleado> usuarioEmpleados) {
            super.onPostExecute(usuarioEmpleados);
            try {
                if(!usuarioEmpleados.isEmpty()){
                    RecyclerEmpleados adapter = new RecyclerEmpleados(usuarioEmpleados, getParentFragment());
                    rvEmpleados.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
                    rvEmpleados.setAdapter(adapter);
                }
                reiniciarAsysnc();
            }catch (Throwable throwable){
                System.out.println("Error al imprimir la lista de Empleados: " +throwable.getMessage());
            }
        }
    }

}
