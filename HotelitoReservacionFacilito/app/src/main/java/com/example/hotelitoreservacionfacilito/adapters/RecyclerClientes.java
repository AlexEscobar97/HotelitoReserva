package com.example.hotelitoreservacionfacilito.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
import com.example.hotelitoreservacionfacilito.app.administrador.fragmet.MantenimientoCliente;
import com.example.hotelitoreservacionfacilito.models.Cliente;

import java.util.List;

public class RecyclerClientes extends RecyclerView.Adapter<RecyclerClientes.ViewHolder> {

    private List<Cliente> lista;
    private Fragment context;
    private FragmentManager fragmentManager;

    public RecyclerClientes(List<Cliente> lista, Fragment context) {
        this.lista = lista;
        this.context = context;
        this.fragmentManager = context.getActivity().getSupportFragmentManager();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.holder_clientes, parent, false);
        return new ViewHolder(v);
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
        TextView tvNombreCliente, tvTelefono;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardView);
            iVFoto = itemView.findViewById(R.id.iVFoto);
            tvNombreCliente = itemView.findViewById(R.id.tvNombreCliente);
            tvTelefono = itemView.findViewById(R.id.tvTelefono);
        }

        public void asignarDatos(final Cliente cliente){
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Intent i = new Intent(context.getContext(), MantenimientoCliente.class);
                    //i.putExtra("id", cliente.getIdCliente());
                    //context.startActivity(i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                    Bundle datosEnviar = new Bundle();
                    datosEnviar.putInt("idCliente", cliente.getIdCliente());


                    MantenimientoCliente mantenimientoCliente = new MantenimientoCliente();
                    mantenimientoCliente.setArguments(datosEnviar);

                    /*FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.nav_view, mantenimientoCliente);
                    //fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                    fragmentTransaction.commit();*/


                    fragmentManager
                            .beginTransaction()
                            .replace(R.id.nav_host_fragment, mantenimientoCliente)
                            .setPrimaryNavigationFragment(mantenimientoCliente).commit();
                            //.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                            //.commit();


                    /*Fragment fragment = context.getParentFragment();
                    context.setArguments(datosEnviar);
                    FragmentManager fragmentManager = context.getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_clientes, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();*/
                }
            });
            iVFoto.setImageResource(R.drawable.logocircle);
            tvNombreCliente.setText(cliente.getNombre() + " " +cliente.getApellido());
            tvTelefono.setText(cliente.getCorreo());
        }
    }

    private void showFragment(Fragment fragment) {
        fragmentManager
                .beginTransaction().replace(R.id.nav_host_fragment, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }
}
