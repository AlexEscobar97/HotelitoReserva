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
import com.example.hotelitoreservacionfacilito.adapters.RecyclerPromocion;
import com.example.hotelitoreservacionfacilito.models.Promocion;
import com.example.hotelitoreservacionfacilito.models.PromocionHabitacion;

import java.util.List;

public class RecyclerPromocionCliente extends RecyclerView.Adapter<RecyclerPromocionCliente.ViewHolder> {

    private List<PromocionHabitacion> lista;
    private Fragment context;
    private FragmentManager fragmentManager;

    public RecyclerPromocionCliente(List<PromocionHabitacion> lista, Fragment context) {
        this.lista = lista;
        this.context = context;
        this.fragmentManager = context.getActivity().getSupportFragmentManager();
    }

    @NonNull
    @Override
    public RecyclerPromocionCliente.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.holderclientes_promocion, parent, false);
        return new RecyclerPromocionCliente.ViewHolder(v);
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

        CardView btncardviewpromocioncliente;
        ImageView promo_img;
        TextView tvestadopromocion,tvfechainiciopromocion,tvfechafinalpromocion,tvdescuentocliente;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            btncardviewpromocioncliente = itemView.findViewById(R.id.btncardviewpromocioncliente);
            promo_img = itemView.findViewById(R.id.promo_img);
            tvestadopromocion = itemView.findViewById(R.id.tvestadopromocion);
            tvfechainiciopromocion = itemView.findViewById(R.id.tvfechainiciopromocion);
            tvfechafinalpromocion = itemView.findViewById(R.id.tvfechafinalpromocion);
            tvdescuentocliente = itemView.findViewById(R.id.tvdescuentocliente);
        }

        public void asignarDatos(final PromocionHabitacion promocionHabitacion){
            promo_img.setImageResource(R.drawable.habitacioneslogolista);
            tvestadopromocion.setText(promocionHabitacion.getIdHabitacion().getEstadoHabitacion());
            tvdescuentocliente.setText(""+promocionHabitacion.getIdPromocion().getDescuento());
            tvfechainiciopromocion.setText(""+promocionHabitacion.getIdPromocion().getFechaIinicioProm());
            tvfechafinalpromocion.setText(""+promocionHabitacion.getIdPromocion().getFechaFinProm());
        }
    }

    private void showFragment(Fragment fragment) {
        fragmentManager
                .beginTransaction().replace(R.id.nav_host_fragment, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }
}
