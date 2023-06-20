package com.example.deltascan;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import  com.example.deltascan.R;
import com.example.deltascan.databinding.FragmentSettingsScanBinding;

public class SettingsScanFragment extends Fragment {

    private FragmentSettingsScanBinding binding;
    public SettingsScanFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSettingsScanBinding.inflate(inflater, container, false);
        if(getArguments().getBoolean("timer")) {
            binding.timer.setChecked(true);
        }
        return binding.getRoot();
    }
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle args = new Bundle();
                args.putBoolean("timer", binding.timer.isChecked());
                NavHostFragment.findNavController(SettingsScanFragment.this)
                        .navigate(R.id.action_SettingsScanFragment_to_ScanFragment, args);
            }
        }); //SettingsScanFragment --> scanFragment
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}