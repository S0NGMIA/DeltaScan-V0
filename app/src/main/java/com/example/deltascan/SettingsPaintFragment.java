package com.example.deltascan;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.deltascan.databinding.FragmentSettingsPaintBinding;

public class SettingsPaintFragment extends Fragment {
    private FragmentSettingsPaintBinding binding;

    public SettingsPaintFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSettingsPaintBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SettingsPaintFragment.this)
                        .navigate(R.id.action_SettingsPaintFragment_to_PaintFragment);
            }
        }); //SettingsPaintFragment --> paintFragment
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}