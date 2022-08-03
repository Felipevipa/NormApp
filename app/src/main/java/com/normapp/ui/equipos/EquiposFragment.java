package com.normapp.ui.equipos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.normapp.databinding.FragmentEquiposBinding;

public class EquiposFragment extends Fragment {

    private FragmentEquiposBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        EquiposViewModel equiposViewModel =
                new ViewModelProvider(this).get(EquiposViewModel.class);

        binding = FragmentEquiposBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textEquipos;
        equiposViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}