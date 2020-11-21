package com.example.hotelitoreservacionfacilito.app.cliente.fragmet;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hotelitoreservacionfacilito.Logued;
import com.example.hotelitoreservacionfacilito.R;
import com.example.hotelitoreservacionfacilito.models.Cliente;
import com.example.hotelitoreservacionfacilito.models.EstadoReserva;
import com.example.hotelitoreservacionfacilito.models.Habitacion;
import com.example.hotelitoreservacionfacilito.models.PromocionHabitacion;
import com.example.hotelitoreservacionfacilito.models.Reserva;
import com.example.hotelitoreservacionfacilito.service.ReservaService;
import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class InsertarReservaHabitacionCliente extends Fragment {

    View viewGlobal;

    EditText r_nombrecliente;
    TextInputLayout r_nombrecliente2;
    Button crear_reserva;
    EditText edtFechaInicio;
    EditText edtFechaFinal;
    EditText edtHabitacion;


    SimpleDateFormat ffecha = new SimpleDateFormat("yyyy-MM-dd");

    AgregarReserva agregarReserva = new AgregarReserva();

    public InsertarReservaHabitacionCliente() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        viewGlobal= inflater.inflate(R.layout.fragment_insertar_reserva_habitacion_cliente, container, false);
        r_nombrecliente2 = viewGlobal.findViewById(R.id.r_nombrecliente);

        //r_nombrecliente2.setText(""+Logued.clienteLogued.getIdCliente()+" "+Logued.clienteLogued.getNombre() +" " +Logued.clienteLogued.getApellido());
        r_nombrecliente2.getEditText().setText(""+Logued.clienteLogued.getIdCliente()+" "+Logued.clienteLogued.getNombre() +" " +Logued.clienteLogued.getApellido());

        edtFechaInicio = viewGlobal.findViewById(R.id.edtFechaInicio);
        edtFechaFinal = viewGlobal.findViewById(R.id.edtFechaFinal);
        edtHabitacion = viewGlobal.findViewById(R.id.edtIdHabitacion);

        edtFechaInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR);
                int mMonth = c.get(Calendar.MONTH);
                int mDay = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        final int mesActual = month + 1;
                        String diaFormateado = (dayOfMonth < 10) ? "0" + String.valueOf(dayOfMonth) : String.valueOf(dayOfMonth);
                        String mesFormateado = (mesActual < 10) ? "0" + String.valueOf(mesActual) : String.valueOf(mesActual);
                        edtFechaInicio.setText(year + "-" + mesFormateado + "-" + diaFormateado);
                    }
                }, mYear, mMonth, mDay);
                datePickerDialog.getDatePicker().setMinDate(c.getTime().getTime());
                datePickerDialog.show();
            }
        });

        edtFechaFinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR);
                int mMonth = c.get(Calendar.MONTH);
                int mDay = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        final int mesActual = month + 1;
                        String diaFormateado = (dayOfMonth < 10) ? "0" + String.valueOf(dayOfMonth) : String.valueOf(dayOfMonth);
                        String mesFormateado = (mesActual < 10) ? "0" + String.valueOf(mesActual) : String.valueOf(mesActual);
                        edtFechaFinal.setText(year + "-" + mesFormateado + "-" + diaFormateado);
                    }
                }, mYear, mMonth, mDay);
                datePickerDialog.getDatePicker().setMinDate(c.getTime().getTime());
                datePickerDialog.show();
            }
        });

        edtHabitacion.setText(""+Logued.habitacionLogued.getIdHabitacion());
        crear_reserva = viewGlobal.findViewById(R.id.crear_reserva);

        crear_reserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarReserva.execute();
            }
        });
        return  viewGlobal;
    }

    public void reinicarAsysnc(){
        agregarReserva.cancel(true);
        agregarReserva = new AgregarReserva();
    }

    public class AgregarReserva extends AsyncTask<String, String, Reserva> {

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected Reserva doInBackground(String... strings) {
            Reserva reserva = new Reserva();
            Cliente cliente = new Cliente();
            Habitacion habitacion = new Habitacion();
            PromocionHabitacion promocionHabitacion = new PromocionHabitacion();
            EstadoReserva estado = new EstadoReserva();
            try {

                ReservaService reservaService = new ReservaService();
                reserva.setIdReserva(0);
                reserva.setFechaInicio(ffecha.parse(edtFechaInicio.getText().toString().trim()));
                reserva.setFechaFin(ffecha.parse(edtFechaFinal.getText().toString().trim()));
                reserva.setTotal(0.0);
                cliente.setIdCliente(Logued.clienteLogued.getIdCliente());
                habitacion.setIdHabitacion(Logued.habitacionLogued.getIdHabitacion());
                //promocionHabitacion.setIdPromHab(null);
                estado.setIdEstadoReserva(1);

                reserva.setIdCliente(cliente);
                reserva.setIdHabitacion(habitacion);
                reserva.setIdEstado(estado);


                reservaService.crearReserva(reserva);
            }catch (Exception e){
                System.out.println("Error al crear Reserva: " +e.getMessage());
            }
            return reserva;
        }

        @Override
        protected void onPostExecute(Reserva reserva) {
            super.onPostExecute(reserva);
            try {
                if(!(reserva == null)){
                    //RecyclerClientes adapter = new RecyclerClientes(clientes, getApplicationContext());
                    //rvClientes.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false));
                    //rvClientes.setAdapter(adapter);
                    Toast.makeText(getContext(), "Reserva Agregado" , Toast.LENGTH_SHORT).show();
                    //Intent i = new Intent(getContext(), .class);
                    //i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    //startActivity(i);
                }
                reinicarAsysnc();
            }catch (Throwable throwable){
                System.out.println("Error al imprimir al agregar reserva: " +throwable.getMessage());
            }
        }
    }

}
