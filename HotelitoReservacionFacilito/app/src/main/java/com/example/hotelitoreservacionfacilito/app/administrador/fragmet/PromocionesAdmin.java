package com.example.hotelitoreservacionfacilito.app.administrador.fragmet;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotelitoreservacionfacilito.R;
import com.example.hotelitoreservacionfacilito.adapters.RecyclerPromocion;
import com.example.hotelitoreservacionfacilito.models.Promocion;
import com.example.hotelitoreservacionfacilito.service.PromocionService;

import java.util.ArrayList;
import java.util.List;
//import com.example.hotelitoreservacionfacilito.app.administrador.R;

public class PromocionesAdmin extends Fragment {

    TextView tvTituloPromociones;
    Button btnAgregarPromociones;
    RecyclerView rvpromocion;

    Promocionestask promocionestask = new Promocionestask();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_promociones_admin, container, false);
        final View view = inflater.inflate(R.layout.fragment_promociones_admin, container, false);
        tvTituloPromociones = view.findViewById(R.id.tvTituloPromociones);
        btnAgregarPromociones = view.findViewById(R.id.btnAgregarPromociones);
        rvpromocion = view.findViewById(R.id.rvpromocion);

        promocionestask.execute();
        return  view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        final NavController navController = Navigation.findNavController(view);

        btnAgregarPromociones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.mantenimientoAPromocion);
            }
        });
    }

    public void reiniciarAsysnc(){
        promocionestask.cancel(true);
        promocionestask = new Promocionestask();
    }

    public class Promocionestask extends AsyncTask <String,String, List<Promocion>>{

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected List<Promocion> doInBackground(String... strings) {
            List<Promocion> listapromocion = new ArrayList<>();
            try {
                PromocionService promocionService = new PromocionService();
                listapromocion = promocionService.obtenerPromocions();
                System.out.println("Lista traida: "+listapromocion.toString());
            }catch (Exception e){
                System.out.println("Error al traer la lista de Promociones: " +e.getMessage());
            }
            return listapromocion;
        }

        @Override
        protected void onPostExecute(List<Promocion> promocions) {
            super.onPostExecute(promocions);

            try {
                    if(!promocions.isEmpty()){
                        RecyclerPromocion apater = new RecyclerPromocion(promocions,getParentFragment());
                        rvpromocion.setLayoutManager(new GridLayoutManager(getContext(), 2));
                        rvpromocion.setAdapter(apater);
                    }
                reiniciarAsysnc();
            }catch (Exception e){
                System.out.println("Error al imprimir la lista de Promociones: " +e.getMessage());
            }
        }
    }

}
