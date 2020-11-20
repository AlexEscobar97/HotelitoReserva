package com.example.hotelitoreservacionfacilito.adapters.Cliente;

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

public class RecycleReservasClientes extends RecyclerView.Adapter<RecycleReservasClientes.ViewHolder>{

    private List<Reserva> lista;
    private Fragment context;
    private FragmentManager fragmentManager;
    private SimpleDateFormat ffecha = new SimpleDateFormat("dd-MM-yyyy");

    public RecycleReservasClientes(List<Reserva> lista, Fragment context) {
        this.lista = lista;
        this.context = context;
        this.fragmentManager = context.getActivity().getSupportFragmentManager();
    }

    @NonNull
    @Override
    public RecycleReservasClientes.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.holderclientes_promocion, parent, false);
        return new RecycleReservasClientes.ViewHolder(v);
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

        CardView cardViewreservaCliente;
        ImageView imgreservacliente;
        TextView tvNombreClienteReserva,tvreservafechainicio,tvreservafechafinal,tvreservahabitacion;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cardViewreservaCliente = itemView.findViewById(R.id.cardViewreservaCliente);
            imgreservacliente = itemView.findViewById(R.id.imgreservacliente);
            tvNombreClienteReserva = itemView.findViewById(R.id.tvNombreClienteReserva);
            tvreservafechainicio = itemView.findViewById(R.id.tvreservafechainicio);
            tvreservafechafinal = itemView.findViewById(R.id.tvreservafechafinal);
            tvreservahabitacion = itemView.findViewById(R.id.tvreservahabitacion);
        }

        public void asignarDatos(final Reserva reserva){
            try {
                imgreservacliente.setImageResource(R.drawable.habitacioneslogolista);
                tvNombreClienteReserva.setText(""+reserva.getIdCliente().getNombre()+" "+reserva.getIdCliente().getApellido());
                tvreservafechainicio.setText(ffecha.format(reserva.getFechaInicio()));
                tvreservafechafinal.setText(ffecha.format(reserva.getFechaInicio()));
                tvreservahabitacion.setText(""+reserva.getIdHabitacion().getNombreHabitacion());
            }catch (Exception e){
                System.out.println("Error al imprimir Reserva: " +e.getMessage());
            }
        }
    }
}
