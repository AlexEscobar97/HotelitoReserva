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
import com.example.hotelitoreservacionfacilito.models.UsuarioEmpleado;

import java.util.List;

public class RecyclerEmpleados extends RecyclerView.Adapter<RecyclerEmpleados.ViewHolder> {

    private List<UsuarioEmpleado> lista;
    private Fragment context;
    private FragmentManager fragmentManager;

    public RecyclerEmpleados(List<UsuarioEmpleado> lista,Fragment context){
        this.lista = lista;
        this.context = context;
        this.fragmentManager = context.getActivity().getSupportFragmentManager();
    }

    @NonNull
    @Override
    public RecyclerEmpleados.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.holder_empleados, parent, false);
        return new RecyclerEmpleados.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerEmpleados.ViewHolder holder, int position) {
        //holder.asignarDatos(lista.get(position));
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CardView cardView;
        ImageView iVFoto;
        TextView tvNombreEmpleado, tvTelefono;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardViewEmpleado);
            iVFoto = itemView.findViewById(R.id.iVFotoEmpleado);
            tvNombreEmpleado = itemView.findViewById(R.id.tvNombreCliente);
            tvTelefono = itemView.findViewById(R.id.tvTelefonoEmpleado);
        }

        public void asignarDatos(final UsuarioEmpleado usuarioEmpleado){

            iVFoto.setImageResource(R.drawable.logocircle);
            tvNombreEmpleado.setText(usuarioEmpleado.getPersonal().getNombre() + " " +usuarioEmpleado.getPersonal().getApellido());
            tvTelefono.setText(usuarioEmpleado.getUsuario());
        }

    }

    private void showFragment(Fragment fragment) {
        fragmentManager
                .beginTransaction().replace(R.id.nav_host_fragment, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }
}
