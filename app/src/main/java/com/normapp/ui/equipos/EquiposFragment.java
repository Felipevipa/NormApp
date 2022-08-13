package com.normapp.ui.equipos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.normapp.databinding.FragmentEquiposBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.normapp.MainActivity;
import com.normapp.R;
import com.normapp.ui.equipos.EquiposFragment;

import java.util.List;

public class EquiposFragment extends Fragment {

    private FragmentEquiposBinding binding;
    Button Equipo1;
    Button Equipo2;
    Button Equipo3;
    Button Equipo4;
    Button Equipo5;
    Button Equipo6;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        EquiposViewModel equiposViewModel =
                new ViewModelProvider(this).get(EquiposViewModel.class);

        binding = FragmentEquiposBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Equipo1 = root.findViewById(R.id.button2);
        Equipo2 = root.findViewById(R.id.button3);
        Equipo3 = root.findViewById(R.id.button4);
        Equipo4 = root.findViewById(R.id.button8);
        Equipo5 = root.findViewById(R.id.button9);
        Equipo6 = root.findViewById(R.id.button10);

        Equipo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.add(R.id.nav_host_fragment_activity_main,Router2900.newInstance("",""));
                transaction.addToBackStack(null);
                transaction.remove(EquiposFragment.this);
                transaction.commit();
            }
        });

        Equipo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.add(R.id.nav_host_fragment_activity_main,Router3600.newInstance("",""));
                transaction.addToBackStack(null);
                transaction.remove(EquiposFragment.this);
                transaction.commit();
            }
        });

        Equipo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.add(R.id.nav_host_fragment_activity_main,Switch2960.newInstance("",""));
                transaction.addToBackStack(null);
                transaction.remove(EquiposFragment.this);
                transaction.commit();
            }
        });

        Equipo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.add(R.id.nav_host_fragment_activity_main,Switch3650.newInstance("",""));
                transaction.addToBackStack(null);
                transaction.remove(EquiposFragment.this);
                transaction.commit();
            }
        });

        Equipo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.add(R.id.nav_host_fragment_activity_main,Firewall1000.newInstance("",""));
                transaction.addToBackStack(null);
                transaction.remove(EquiposFragment.this);
                transaction.commit();
            }
        });

        Equipo6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.add(R.id.nav_host_fragment_activity_main,Firewall4100.newInstance("",""));
                transaction.addToBackStack(null);
                transaction.remove(EquiposFragment.this);
                transaction.commit();
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}