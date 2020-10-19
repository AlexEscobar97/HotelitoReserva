package com.example.hotelitoreservacionfacilito.app.administrador.fragmet;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hotelitoreservacionfacilito.R;
import com.example.hotelitoreservacionfacilito.models.Cliente;
import com.example.hotelitoreservacionfacilito.service.ClienteService;

import java.util.ArrayList;
import java.util.List;

public class MantenimientoCliente extends Fragment {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    EditText edtNombre,edtApellido,edtCorreo,edtUsuario,edtClave;
    Button btnAgregar, btnEditar;

    AgregarCliente agregarCliente = new AgregarCliente();
    ClienteById clienteById = new ClienteById();
    EditarCliente editarCliente = new EditarCliente();

    Bundle datosRecuperados = getArguments();

    int idCliente = 0;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MantenimientoCliente() {
        // Required empty public constructor
    }


    public static MantenimientoCliente newInstance(String param1, String param2) {
        MantenimientoCliente fragment = new MantenimientoCliente();
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
        View view = inflater.inflate(R.layout.fragment_mantenimiento_cliente, container, false);

        //idCliente = getActivity().getIntent().getIntExtra("id", 0);
        //idCliente = datosRecuperados.getInt("idCliente");
        idCliente = getArguments().getInt("idCliente");

        edtNombre = view.findViewById(R.id.edtNombre);
        edtApellido = view.findViewById(R.id.edtApellido);
        edtCorreo = view.findViewById(R.id.edtCorreo);
        edtUsuario = view.findViewById(R.id.edtUsuario);
        edtClave = view.findViewById(R.id.edtClave);

        Cliente cliente = new Cliente();

        btnAgregar = view.findViewById(R.id.btnAgregar);
        btnEditar = view.findViewById(R.id.btnEditar);

        if(idCliente != 0) {
            clienteById.execute();
            btnAgregar.setEnabled(false);
        }else{
            btnEditar.setEnabled(false);
        }

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregarCliente.execute();
            }
        });

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editarCliente.execute();
            }
        });


        return view;
    }

    public void reinicarAsysnc(){
        agregarCliente.cancel(true);
        agregarCliente = new AgregarCliente();

        editarCliente.cancel(true);
        editarCliente = new EditarCliente();

        clienteById.cancel(true);
        clienteById = new ClienteById();
    }

    public class AgregarCliente extends AsyncTask<String, String, Cliente> {

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected Cliente doInBackground(String... strings) {
            List<Cliente> listaClientes = new ArrayList<>();
            Cliente cliente = new Cliente();
            try {
                ClienteService clienteService = new ClienteService();
                cliente.setIdCliente(0);
                cliente.setNombre(edtNombre.getText().toString().trim());
                cliente.setApellido(edtApellido.getText().toString().trim());
                cliente.setCorreo(edtCorreo.getText().toString().trim());
                cliente.setUsuario(edtUsuario.getText().toString().trim());
                cliente.setClave(edtClave.getText().toString().trim());

                clienteService.crearCliente(cliente);
            }catch (Exception e){
                System.out.println("Error al traer la lista de clientes: " +e.getMessage());
            }
            return cliente;
        }

        @Override
        protected void onPostExecute(Cliente cliente) {
            super.onPostExecute(cliente);
            try {
                if(!(cliente == null)){
                    //RecyclerClientes adapter = new RecyclerClientes(clientes, getApplicationContext());
                    //rvClientes.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false));
                    //rvClientes.setAdapter(adapter);
                    Toast.makeText(getContext(), "Cliente Agregado" , Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getContext(), Clientes.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                }
                reinicarAsysnc();
            }catch (Throwable throwable){
                System.out.println("Error al imprimir al agregar clientes: " +throwable.getMessage());
            }
        }
    }

    public class EditarCliente extends AsyncTask<String, String, Cliente> {

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected Cliente doInBackground(String... strings) {
            List<Cliente> listaClientes = new ArrayList<>();
            Cliente cliente = new Cliente();
            try {
                ClienteService clienteService = new ClienteService();
                cliente.setIdCliente(idCliente);
                cliente.setNombre(edtNombre.getText().toString().trim());
                cliente.setApellido(edtApellido.getText().toString().trim());
                cliente.setCorreo(edtCorreo.getText().toString().trim());
                cliente.setUsuario(edtUsuario.getText().toString().trim());
                cliente.setClave(edtClave.getText().toString().trim());

                clienteService.actualizarClientePorId(cliente);
            }catch (Exception e){
                System.out.println("Error al traer la lista de clientes: " +e.getMessage());
            }
            return cliente;
        }

        @Override
        protected void onPostExecute(Cliente cliente) {
            super.onPostExecute(cliente);
            try {
                if(!(cliente == null)){
                    //RecyclerClientes adapter = new RecyclerClientes(clientes, getApplicationContext());
                    //rvClientes.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false));
                    //rvClientes.setAdapter(adapter);
                    Toast.makeText(getContext(), "Cliente Actualizado" , Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getContext(), Clientes.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                }
                reinicarAsysnc();
            }catch (Throwable throwable){
                System.out.println("Error al imprimir al editar clientes: " +throwable.getMessage());
            }
        }
    }



    public class ClienteById extends AsyncTask<String, String, Cliente> {

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected Cliente doInBackground(String... strings) {
            List<Cliente> listaClientes = new ArrayList<>();
            Cliente cliente = new Cliente();
            try {
                ClienteService clienteService = new ClienteService();
                cliente = clienteService.obtenerClientePorId(idCliente);
                System.out.println("Objeto: " +cliente.toString());
            }catch (Exception e){
                System.out.println("Error al traer la lista de clientes: " +e.getMessage());
            }
            return cliente;
        }

        @Override
        protected void onPostExecute(Cliente cliente) {
            super.onPostExecute(cliente);
            try {
                if(!(cliente == null)){
                    edtNombre.setText(cliente.getNombre());
                    edtApellido.setText(cliente.getApellido());
                    edtCorreo.setText(cliente.getCorreo());
                    edtUsuario.setText(cliente.getUsuario());
                    edtClave.setText(cliente.getClave());
                    Toast.makeText(getContext(), "Cliente Buscado" , Toast.LENGTH_SHORT).show();
                }
                reinicarAsysnc();
            }catch (Throwable throwable){
                System.out.println("Error al imprimir al buscar clientes: " +throwable.getMessage());
            }
        }
    }


    /*
    EditText edtNombre,edtApellido,edtCorreo,edtUsuario,edtClave;
    Button btnAgregar, btnEditar;

    AgregarCliente agregarCliente = new AgregarCliente();
    ClienteById clienteById = new ClienteById();
    EditarCliente editarCliente = new EditarCliente();

    int idCliente = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_mantenimiento_cliente);
        idCliente = getIntent().getIntExtra("id", 0);

        edtNombre = findViewById(R.id.edtNombre);
        edtApellido = findViewById(R.id.edtApellido);
        edtCorreo = findViewById(R.id.edtCorreo);
        edtUsuario = findViewById(R.id.edtUsuario);
        edtClave = findViewById(R.id.edtClave);

        Cliente cliente = new Cliente();

        btnAgregar = findViewById(R.id.btnAgregar);
        btnEditar = findViewById(R.id.btnEditar);

        if(idCliente != 0) {
            clienteById.execute();
            btnAgregar.setEnabled(false);
        }else{
            btnEditar.setEnabled(false);
        }

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregarCliente.execute();
            }
        });

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editarCliente.execute();
            }
        });

    }

    @Nullable
    @Override
    public View onCreateView(@Nullable View parent, @NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {

        return super.onCreateView(parent, name, context, attrs);

    }

    public void reinicarAsysnc(){
        agregarCliente.cancel(true);
        agregarCliente = new AgregarCliente();

        editarCliente.cancel(true);
        editarCliente = new EditarCliente();

        clienteById.cancel(true);
        clienteById = new ClienteById();
    }

    public class AgregarCliente extends AsyncTask<String, String, Cliente> {

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected Cliente doInBackground(String... strings) {
            List<Cliente> listaClientes = new ArrayList<>();
            Cliente cliente = new Cliente();
            try {
                ClienteService clienteService = new ClienteService();
                cliente.setIdCliente(0);
                cliente.setNombre(edtNombre.getText().toString().trim());
                cliente.setApellido(edtApellido.getText().toString().trim());
                cliente.setCorreo(edtCorreo.getText().toString().trim());
                cliente.setUsuario(edtUsuario.getText().toString().trim());
                cliente.setClave(edtClave.getText().toString().trim());

                clienteService.crearCliente(cliente);
            }catch (Exception e){
                System.out.println("Error al traer la lista de clientes: " +e.getMessage());
            }
            return cliente;
        }

        @Override
        protected void onPostExecute(Cliente cliente) {
            super.onPostExecute(cliente);
            try {
                if(!(cliente == null)){
                    //RecyclerClientes adapter = new RecyclerClientes(clientes, getApplicationContext());
                    //rvClientes.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false));
                    //rvClientes.setAdapter(adapter);
                    Toast.makeText(getApplicationContext(), "Cliente Agregado" , Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(), Clientes.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                }
                reinicarAsysnc();
            }catch (Throwable throwable){
                System.out.println("Error al imprimir al agregar clientes: " +throwable.getMessage());
            }
        }
    }

    public class EditarCliente extends AsyncTask<String, String, Cliente> {

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected Cliente doInBackground(String... strings) {
            List<Cliente> listaClientes = new ArrayList<>();
            Cliente cliente = new Cliente();
            try {
                ClienteService clienteService = new ClienteService();
                cliente.setIdCliente(idCliente);
                cliente.setNombre(edtNombre.getText().toString().trim());
                cliente.setApellido(edtApellido.getText().toString().trim());
                cliente.setCorreo(edtCorreo.getText().toString().trim());
                cliente.setUsuario(edtUsuario.getText().toString().trim());
                cliente.setClave(edtClave.getText().toString().trim());

                clienteService.actualizarClientePorId(cliente);
            }catch (Exception e){
                System.out.println("Error al traer la lista de clientes: " +e.getMessage());
            }
            return cliente;
        }

        @Override
        protected void onPostExecute(Cliente cliente) {
            super.onPostExecute(cliente);
            try {
                if(!(cliente == null)){
                    //RecyclerClientes adapter = new RecyclerClientes(clientes, getApplicationContext());
                    //rvClientes.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false));
                    //rvClientes.setAdapter(adapter);
                    Toast.makeText(getApplicationContext(), "Cliente Actualizado" , Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(), Clientes.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                }
                reinicarAsysnc();
            }catch (Throwable throwable){
                System.out.println("Error al imprimir al editar clientes: " +throwable.getMessage());
            }
        }
    }



    public class ClienteById extends AsyncTask<String, String, Cliente> {

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected Cliente doInBackground(String... strings) {
            List<Cliente> listaClientes = new ArrayList<>();
            Cliente cliente = new Cliente();
            try {
                ClienteService clienteService = new ClienteService();
                cliente = clienteService.obtenerClientePorId(idCliente);
                System.out.println("Objeto: " +cliente.toString());
            }catch (Exception e){
                System.out.println("Error al traer la lista de clientes: " +e.getMessage());
            }
            return cliente;
        }

        @Override
        protected void onPostExecute(Cliente cliente) {
            super.onPostExecute(cliente);
            try {
                if(!(cliente == null)){
                    edtNombre.setText(cliente.getNombre());
                    edtApellido.setText(cliente.getApellido());
                    edtCorreo.setText(cliente.getCorreo());
                    edtUsuario.setText(cliente.getUsuario());
                    edtClave.setText(cliente.getClave());
                    Toast.makeText(getApplicationContext(), "Cliente Buscado" , Toast.LENGTH_SHORT).show();
                }
                reinicarAsysnc();
            }catch (Throwable throwable){
                System.out.println("Error al imprimir al buscar clientes: " +throwable.getMessage());
            }
        }
    }*/
}