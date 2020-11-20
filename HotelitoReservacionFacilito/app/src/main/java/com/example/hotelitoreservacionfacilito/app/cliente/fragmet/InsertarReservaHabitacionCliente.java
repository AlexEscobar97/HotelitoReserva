package com.example.hotelitoreservacionfacilito.app.cliente.fragmet;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.hotelitoreservacionfacilito.Logued;
import com.example.hotelitoreservacionfacilito.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;


public class InsertarReservaHabitacionCliente extends Fragment {

    View viewGlobal;

    EditText r_nombrecliente;
    TextInputLayout r_nombrecliente2;
    Button crear_reserva;
    EditText edtFechaInicio;
    EditText edtFechaFinal;
    EditText edtHabitacion;



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
                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), R.style.AppTheme, new DatePickerDialog.OnDateSetListener() {
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
                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), R.style.AppTheme, new DatePickerDialog.OnDateSetListener() {
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
        return  viewGlobal;
    }


}