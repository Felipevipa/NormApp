package com.normapp.ui.info;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.normapp.Adaptadores.AdapterPreguntas;
import com.normapp.Entidades.Preguntas;
import com.normapp.R;
import com.normapp.databinding.FragmentInfoBinding;

import java.util.ArrayList;

public class InfoFragment extends Fragment {

    AdapterPreguntas adapterPreguntas;
    RecyclerView recyclerViewPreguntas;
    ArrayList<Preguntas> listaPreguntas;

    private FragmentInfoBinding binding;
    public void cargarLista() {
        listaPreguntas.add(new Preguntas( "Hola","Hola",R.drawable.ieee));
        listaPreguntas.add(new Preguntas( "Hola_2","Hola_3",R.drawable.logo));
        listaPreguntas.add(new Preguntas( "Hola_3","Hola_4",R.drawable.logo));
        listaPreguntas.add(new Preguntas( "Hola_3","Hola_5",R.drawable.logo));
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lista_preguntas,container, false);
        recyclerViewPreguntas = view.findViewById(R.id.recyclerView);
        listaPreguntas = new ArrayList<>();
        cargarLista();


        return view;
    }
    public void mostrarData(){
        recyclerViewPreguntas.setLayoutManager(new LinearLayoutManager(getContext()));
        adapterPreguntas = new AdapterPreguntas(getContext(), listaPreguntas);
        recyclerViewPreguntas.setAdapter(adapterPreguntas);
    }

}