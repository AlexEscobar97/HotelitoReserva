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
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotelitoreservacionfacilito.R;
import com.example.hotelitoreservacionfacilito.models.Habitacion;

import java.util.List;

public class RecycleHabitacionClientes extends RecyclerView.Adapter<RecycleHabitacionClientes.ViewHolder> {

    private List<Habitacion> lista;
    private Fragment context;
    private FragmentManager fragmentManager;

    public RecycleHabitacionClientes(List<Habitacion> lista, Fragment context) {
        this.lista = lista;
        this.context = context;
        this.fragmentManager = context.getActivity().getSupportFragmentManager();
    }

    @NonNull
    @Override
    public RecycleHabitacionClientes.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.holdercliente_habitaciones, parent, false);
        return new RecycleHabitacionClientes.ViewHolder(v);
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

        CardView crvhabitacioncliente;
        ImageView imgprincipalcliente,imgFav_right,imgShare_right;
        TextView tvPrecioCliente,tvtitulonombrehabitacion,tvdisponiblecliente,tvcategoriacliente;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            crvhabitacioncliente = itemView.findViewById(R.id.crvhabitacioncliente);
            imgprincipalcliente = itemView.findViewById(R.id.imgprincipalcliente);
            imgFav_right = itemView.findViewById(R.id.imgFav_right);
            imgShare_right = itemView.findViewById(R.id.imgShare_right);
            tvPrecioCliente = itemView.findViewById(R.id.tvPrecioCliente);
            tvtitulonombrehabitacion = itemView.findViewById(R.id.tvtitulonombrehabitacion);
            tvdisponiblecliente = itemView.findViewById(R.id.tvdisponiblecliente);
            tvcategoriacliente = itemView.findViewById(R.id.tvcategoriacliente);
        }

        public void asignarDatos(final Habitacion habitacion){
            imgprincipalcliente.setImageResource(R.drawable.pruebahabitacion);
            tvtitulonombrehabitacion.setText(habitacion.getNombreHabitacion());
            tvPrecioCliente.setText("$ "+habitacion.getTipoHabitacion().getPrecio());
            tvdisponiblecliente.setText(""+habitacion.getEstadoHabitacion());
            tvcategoriacliente.setText(habitacion.getTipoHabitacion().getTitulo());
        }
    }

    private void showFragment(Fragment fragment) {
        fragmentManager
                .beginTransaction().replace(R.id.nav_host_fragment, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }
}
