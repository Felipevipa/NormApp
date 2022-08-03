package com.normapp.ui.ping;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.normapp.databinding.FragmentPingBinding;

public class PingFragment extends Fragment {

    private FragmentPingBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        PingViewModel pingViewModel =
                new ViewModelProvider(this).get(PingViewModel.class);

        binding = FragmentPingBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textPing;
        pingViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}