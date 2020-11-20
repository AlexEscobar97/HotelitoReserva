package com.example.hotelitoreservacionfacilito.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotelitoreservacionfacilito.R;
import com.example.hotelitoreservacionfacilito.models.Reserva;

import java.text.SimpleDateFormat;
import java.util.List;

public class RecycleReservaciones extends RecyclerView.Adapter<RecycleReservaciones.ViewHolder>{

    private List<Reserva> lista;
    private Fragment context;
    private FragmentManager fragmentManager;
    private SimpleDateFormat ffecha = new SimpleDateFormat("dd-MM-yyyy");

    public RecycleReservaciones(List<Reserva> lista, Fragment context) {
        this.lista = lista;
        this.context = context;
        this.fragmentManager = context.getActivity().getSupportFragmentManager();
    }

    @NonNull
    @Override
    public RecycleReservaciones.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.holder_reservaciones, parent, false);
        return new RecycleReservaciones.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.asignarDatos(lista.get(position));
    }



    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CardView cardViewreservaAdmin;
        ImageView imgreservaAdmin;
        TextView tvNombreClienteReservaAdmin,tvreservafechainicioAdmin,tvreservafechafinalAdmin,tvreservahabitacionAdmin;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cardViewreservaAdmin = itemView.findViewById(R.id.cardViewreservaAdmin);
            imgreservaAdmin = itemView.findViewById(R.id.imgreservaAdmin);
            tvNombreClienteReservaAdmin = itemView.findViewById(R.id.tvNombreClienteReservaAdmin);
            tvreservafechainicioAdmin = itemView.findViewById(R.id.tvreservafechainicioAdmin);
            tvreservafechafinalAdmin = itemView.findViewById(R.id.tvreservafechafinalAdmin);
            tvreservahabitacionAdmin = itemView.findViewById(R.id.tvreservahabitacionAdmin);
        }

        public void asignarDatos(final Reserva reserva){
            try {
                imgreservaAdmin.setImageResource(R.drawable.habitacioneslogolista);
                tvNombreClienteReservaAdmin.setText(""+reserva.getIdCliente().getNombre()+" "+reserva.getIdCliente().getApellido());
                tvreservafechainicioAdmin.setText(ffecha.format(reserva.getFechaInicio()));
                tvreservafechafinalAdmin.setText(ffecha.format(reserva.getFechaInicio()));
                tvreservahabitacionAdmin.setText(""+reserva.getIdHabitacion().getNombreHabitacion());
            }catch (Exception e){
                System.out.println("Error al imprimir Reserva: " +e.getMessage());
            }
        }
    }
}
