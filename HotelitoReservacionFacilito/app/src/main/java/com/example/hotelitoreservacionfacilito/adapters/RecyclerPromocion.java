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
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotelitoreservacionfacilito.R;
import com.example.hotelitoreservacionfacilito.models.Promocion;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class RecyclerPromocion extends RecyclerView.Adapter<RecyclerPromocion.ViewHolder> {

    private List<Promocion> lista;
    private Fragment context;
    private FragmentManager fragmentManager;

    public RecyclerPromocion(List<Promocion> lista, Fragment context) {
        this.lista = lista;
        this.context = context;
        this.fragmentManager = context.getActivity().getSupportFragmentManager();
    }

    @NonNull
    @Override
    public RecyclerPromocion.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.holder_promociones, parent, false);
        return new RecyclerPromocion.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerPromocion.ViewHolder holder, int position) {
        holder.asignarDatos(lista.get(position));
    }

    @Override
    public int getItemCount() {
         return lista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CardView btncardviewpromocion;
        ImageView promo_img,descuentoicono;
        TextView tvfechafinal,tvfechainicio;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            btncardviewpromocion = itemView.findViewById(R.id.btncardviewpromocion);
            promo_img = itemView.findViewById(R.id.promo_img);
            descuentoicono = itemView.findViewById(R.id.descuentoicono);
            tvfechafinal = itemView.findViewById(R.id.tvfechafinal);
            tvfechainicio = itemView.findViewById(R.id.tvfechainicio);
        }

        public void asignarDatos(final Promocion promocion){
            //Date FI,FF;
            SimpleDateFormat fechaInicio = new SimpleDateFormat("YYYY-MM-dd");
            //FI = fechaInicio;

            promo_img.setImageResource(R.drawable.habitacioneslogolista);
            tvfechafinal.setText("Fecha final:"+promocion.getFechaFinProm());
            tvfechainicio.setText("Fecha Inicio:"+promocion.getFechaIinicioProm());
        }
    }

    private void showFragment(Fragment fragment) {
        fragmentManager
                .beginTransaction().replace(R.id.nav_host_fragment, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }
}
