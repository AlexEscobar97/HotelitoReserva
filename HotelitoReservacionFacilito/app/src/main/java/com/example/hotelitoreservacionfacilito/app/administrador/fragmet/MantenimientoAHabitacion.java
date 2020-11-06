package com.example.hotelitoreservacionfacilito.app.administrador.fragmet;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.hotelitoreservacionfacilito.R;
import com.example.hotelitoreservacionfacilito.models.Habitacion;
import com.example.hotelitoreservacionfacilito.models.TipoHabitacion;
import com.example.hotelitoreservacionfacilito.service.TipoHabitacionService;

import java.util.ArrayList;
import java.util.List;


public class MantenimientoAHabitacion extends Fragment {

    EditText edtNombreHabitacion;
    Spinner spinnerEstado,spinnerTipoHabitacion;
    Button btnAgregarhabitacion;

    //Lista para usar en los componentes de Android
    ArrayList<String> lista1;

    ListaTipoHabitacion listaTipoHabitacion = new ListaTipoHabitacion();

    List<TipoHabitacion> listahabitacion = new ArrayList<>();
    List<String> listHabitacionSpinner = new ArrayList<>();

    int idTipoHabitacion;

    public MantenimientoAHabitacion() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_mantenimiento_a_habitacion, container, false);
        View view = inflater.inflate(R.layout.fragment_mantenimiento_a_habitacion, container, false);

        edtNombreHabitacion = view.findViewById(R.id.edtNombreHabitacion);
        spinnerEstado = view.findViewById(R.id.spinnerEstado);
        spinnerTipoHabitacion = view.findViewById(R.id.spinnerTipoHabitacion);
        btnAgregarhabitacion = view.findViewById(R.id.btnAgregarhabitacion);

        listaTipoHabitacion.execute();

        btnAgregarhabitacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        spinnerTipoHabitacion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position != 0){
                    idTipoHabitacion = listahabitacion.get(position - 1).getIdTipoHabitacion();
                    Toast.makeText(getContext(), "Usted eligio la "
                            +listahabitacion.get(position - 1).getTitulo()
                            +" con el ID: " +listahabitacion.get(position - 1).getIdTipoHabitacion() , Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getContext(), "Seleccione un Tipo de Habitacion", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;
    }
    public void reinicarAsysnc(){
        listaTipoHabitacion.cancel(true);
        listaTipoHabitacion = new ListaTipoHabitacion();
    }

    public class ListaTipoHabitacion extends AsyncTask<String, String, List<TipoHabitacion>>{

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected List<TipoHabitacion> doInBackground(String... strings) {
            listahabitacion = new ArrayList<>();
            List listaMuestra;

            try {
                TipoHabitacionService tipoHabitacionService = new TipoHabitacionService();
                listahabitacion = tipoHabitacionService.obtenerTipoHabitacions();
                System.out.println("Muestra Lista: "+listahabitacion.toString());
            }catch (Exception e){
                System.out.println("Error al traer la lista de TipoHabitaciones: " +e.getMessage());
            }
            return listahabitacion;
        }

        @Override
        protected void onPostExecute(List<TipoHabitacion> tipoHabitacion) {
            super.onPostExecute(tipoHabitacion);
            try {
                if (!(tipoHabitacion ==null)){
                    //String[] listaH = tipoHabitacion;
                    listHabitacionSpinner.add("Tipo de Habitacion");
                    for(TipoHabitacion tipo: tipoHabitacion){
                        listHabitacionSpinner.add(tipo.getTitulo() +" $ :" +tipo.getPrecio());
                    }
                    ArrayAdapter <Habitacion> lista = new ArrayAdapter
                            (getContext(), android.R.layout.simple_spinner_item,listHabitacionSpinner);
                    spinnerTipoHabitacion.setAdapter(lista);
                }
                reinicarAsysnc();
            }catch (Exception e){
                System.out.println("Error al imprimir la lista de TipoHabitaciones: " +e.getMessage());
            }
        }
    }
}