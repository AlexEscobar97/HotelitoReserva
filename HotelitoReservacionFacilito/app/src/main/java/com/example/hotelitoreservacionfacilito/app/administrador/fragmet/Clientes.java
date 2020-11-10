package com.example.hotelitoreservacionfacilito.app.administrador.fragmet;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.hotelitoreservacionfacilito.R;
import com.example.hotelitoreservacionfacilito.adapters.RecyclerClientes;
import com.example.hotelitoreservacionfacilito.models.Cliente;
import com.example.hotelitoreservacionfacilito.service.ClienteService;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;


public class Clientes extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";



    TextView tvTitulo;
    Button btnAgregarCliente;
    RecyclerView rvClientes;

    ClientesTask clientesTask = new ClientesTask();

    Activity activity;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Clientes() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_clientes.
     */
    // TODO: Rename and change types and number of parameters
    public static Clientes newInstance(String param1, String param2) {
        Clientes fragment = new Clientes();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_clientes, container, false);

        final NavigationView navigationView = view.findViewById(R.id.nav_view);

        tvTitulo = view.findViewById(R.id.tvTitulo);
        btnAgregarCliente = view.findViewById(R.id.btnAgregarCliente);
        rvClientes = view.findViewById(R.id.rvClientes);

        clientesTask.execute();

        //final NavController navController = Navigation.findNavController(view.findViewById(R.id.nav_host_fragment));
        //final NavController navController = Navigation.findNavController(view.findViewById(R.id.mobile_navigation));

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        final NavController navController = Navigation.findNavController(view);

        btnAgregarCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.mantenimientoCliente);
                //navigationView.findViewById(R.id.mobile_navigation).getContext().startActivity(); Se puede ocupar

            }
        });

    }

    public void reinicarAsysnc(){
        clientesTask.cancel(true);
        clientesTask = new ClientesTask();
    }

    public class ClientesTask extends AsyncTask<String, String, List<Cliente>> {

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected List<Cliente> doInBackground(String... strings) {
            List<Cliente> listaClientes = new ArrayList<>();
            try {
                ClienteService clienteService = new ClienteService();
                listaClientes = clienteService.obtenerClientes();
            }catch (Exception e){
                System.out.println("Error al traer la lista de clientes: " +e.getMessage());
            }
            return listaClientes;
        }

        @Override
        protected void onPostExecute(List<Cliente> clientes) {
            super.onPostExecute(clientes);
            try {
                if(!clientes.isEmpty()){
                    RecyclerClientes adapter = new RecyclerClientes(clientes, getParentFragment());
                    rvClientes.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
                    rvClientes.setAdapter(adapter);
                }
                reinicarAsysnc();
            }catch (Throwable throwable){
                System.out.println("Error al imprimir la lista de clientes: " +throwable.getMessage());
            }
        }
    }


}