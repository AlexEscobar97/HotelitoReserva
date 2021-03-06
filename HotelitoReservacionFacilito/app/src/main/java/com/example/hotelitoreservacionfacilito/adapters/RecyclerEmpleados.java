package com.example.hotelitoreservacionfacilito.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotelitoreservacionfacilito.R;
import com.example.hotelitoreservacionfacilito.app.administrador.fragmet.MantenomientoAEmpleado;
import com.example.hotelitoreservacionfacilito.models.UsuarioEmpleado;

import java.util.List;

public class RecyclerEmpleados extends RecyclerView.Adapter<RecyclerEmpleados.ViewHolder> {

    private List<UsuarioEmpleado> lista;
    private Fragment context;
    private FragmentManager fragmentManager;

    private FragmentTransaction  fragmentTransaction;

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
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
         holder.asignarDatos(lista.get(position));
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CardView cardView;
        ImageView iVFoto;
        TextView tvNombreEmpleado, tvTelefono;
        Button btnActualizarE,btnEliminarE;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardViewEmpleado);
            iVFoto = itemView.findViewById(R.id.iVFotoEmpleado);
            tvNombreEmpleado = itemView.findViewById(R.id.tvNombreEmpleado);
            tvTelefono = itemView.findViewById(R.id.tvTelefonoEmpleado);
            btnActualizarE = itemView.findViewById(R.id.btnActualizarE);
        }

        public void asignarDatos(final UsuarioEmpleado usuarioEmpleado){

            iVFoto.setImageResource(R.drawable.logocircle);
            String nombre = usuarioEmpleado.getPersonal().getNombre();
            System.out.println(nombre);
            tvNombreEmpleado.setText(usuarioEmpleado.getPersonal().getNombre()+" "+usuarioEmpleado.getPersonal().getApellido());
            tvTelefono.setText(usuarioEmpleado.getUsuario());

            btnActualizarE.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    MantenomientoAEmpleado mantenomientoAEmpleado = new MantenomientoAEmpleado();
                    fragmentManager = context.getActivity().getSupportFragmentManager();
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.FragmentEmpleadoAdmin, mantenomientoAEmpleado);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();

                }
            });
        }

    }

    private void showFragment(Fragment fragment) {
        fragmentManager
                .beginTransaction().replace(R.id.nav_host_fragment, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }
}
