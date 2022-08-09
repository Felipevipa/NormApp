package com.normapp.ui.normativas;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.normapp.MainActivity;
import com.normapp.R;
import com.normapp.databinding.FragmentNormativasBinding;

import java.util.List;

public class NormativasFragment extends Fragment {

    private FragmentNormativasBinding binding;
    Button Norma1;
    Button Norma2;
    Button Norma3;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        NormativasViewModel normativasViewModel =
                new ViewModelProvider(this).get(NormativasViewModel.class);

        binding = FragmentNormativasBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        Norma1 = root.findViewById(R.id.button2);
        Norma2 = root.findViewById(R.id.button3);
        Norma3 = root.findViewById(R.id.button4);



        Norma1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.add(R.id.nav_host_fragment_activity_main,ieee802_3.newInstance("",""));
                transaction.addToBackStack(null);
                transaction.remove(NormativasFragment.this);
                transaction.commit();
            }
        });


        Norma2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.add(R.id.nav_host_fragment_activity_main,ieee802_5.newInstance("",""));
                transaction.addToBackStack(null);
                transaction.remove(NormativasFragment.this);
                transaction.commit();
            }
        });


        Norma3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.add(R.id.nav_host_fragment_activity_main,ieee802_11.newInstance("",""));
                transaction.addToBackStack(null);
                transaction.remove(NormativasFragment.this);
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