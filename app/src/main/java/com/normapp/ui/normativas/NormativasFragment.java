package com.normapp.ui.normativas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.normapp.R;
import com.normapp.databinding.FragmentNormativasBinding;
import com.normapp.ieee802_3;
import com.normapp.ieee802_5;
import com.normapp.ieee802_11;
import com.normapp.ui.equipos.EquiposFragment;

public class NormativasFragment extends Fragment {

    private FragmentNormativasBinding binding;
    Button Norma1;
    Button Norma2;
    Button Norma3;
    ScrollView Caja;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NormativasViewModel normativasViewModel =
                new ViewModelProvider(this).get(NormativasViewModel.class);

        binding = FragmentNormativasBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Caja = root.findViewById(R.id.scrollView2);
        Norma1 = root.findViewById(R.id.button2);
        Norma2 = root.findViewById(R.id.button3);
        Norma3 = root.findViewById(R.id.button4);

        Norma1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Create new fragment and transaction
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setReorderingAllowed(true);
                // Replace whatever is in the fragment_container view with this fragment
                transaction.replace(R.id.nav_host_fragment_activity_main, ieee802_3.newInstance("",""));
                // Commit the transaction
                transaction.commit();
                // Ocultar Caja principal
                Caja.setVisibility(View.GONE);
            }
        });


        Norma2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Create new fragment and transaction
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setReorderingAllowed(true);
                // Replace whatever is in the fragment_container view with this fragment
                transaction.replace(R.id.nav_host_fragment_activity_main, ieee802_5.newInstance("",""));
                // Commit the transaction
                transaction.commit();
                // Ocultar Caja principal
                Caja.setVisibility(View.GONE);
            }
        });


        Norma3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Create new fragment and transaction
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setReorderingAllowed(true);
                // Replace whatever is in the fragment_container view with this fragment
                transaction.replace(R.id.nav_host_fragment_activity_main, ieee802_11.newInstance("",""));
                // Commit the transaction
                transaction.commit();
                // Ocultar Caja principal
                Caja.setVisibility(View.GONE);
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