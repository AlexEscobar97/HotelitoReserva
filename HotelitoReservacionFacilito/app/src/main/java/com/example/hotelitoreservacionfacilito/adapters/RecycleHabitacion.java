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
import com.example.hotelitoreservacionfacilito.models.Habitacion;

import java.util.List;

public class RecycleHabitacion extends RecyclerView.Adapter<RecycleHabitacion.ViewHolder> {

    private List<Habitacion> lista;
    private Fragment context;
    private FragmentManager fragmentManager;

    public RecycleHabitacion(List<Habitacion> lista, Fragment context) {
        this.lista = lista;
        this.context = context;
        this.fragmentManager = context.getActivity().getSupportFragmentManager();
    }

    @NonNull
    @Override
    public RecycleHabitacion.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.holder_habitaciones, parent, false);
        return new RecycleHabitacion.ViewHolder(v);
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

        CardView bottom_card_right;
        ImageView cardHeaderImg_right,imgFav_right,imgBookmarks_right,imgShare_right;
        TextView TituloHabitacion,tvPrecioAd;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            bottom_card_right = itemView.findViewById(R.id.bottom_card_right);
            cardHeaderImg_right = itemView.findViewById(R.id.cardHeaderImg_right);
            imgFav_right = itemView.findViewById(R.id.imgFav_right);
            imgBookmarks_right = itemView.findViewById(R.id.imgBookmarks_right);
            imgShare_right = itemView.findViewById(R.id.imgShare_right);
            TituloHabitacion = itemView.findViewById(R.id.TituloHabitacion);
            tvPrecioAd = itemView.findViewById(R.id.tvPrecioAd);
        }

        public void asignarDatos(final Habitacion habitacion){
            cardHeaderImg_right.setImageResource(R.drawable.chabitacion);
            TituloHabitacion.setText(habitacion.getNombreHabitacion());
            tvPrecioAd.setText("$ "+habitacion.getTipoHabitacion().getPrecio());
        }
    }

    private void showFragment(Fragment fragment) {
        fragmentManager
                .beginTransaction().replace(R.id.nav_host_fragment, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }
}
