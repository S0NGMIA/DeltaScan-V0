package com.example.deltascan;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.deltascan.databinding.FragmentPaintBinding;
import com.example.deltascan.databinding.FragmentScanBinding;

public class ScanFragment extends Fragment {
    private FragmentScanBinding binding;
    private boolean timer;
    public ScanFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            timer = getArguments().getBoolean("timer", true);
        }
        else{
            timer = true;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentScanBinding.inflate(inflater, container, false);
        if(timer){
            binding.timer.setVisibility(View.VISIBLE);
        }
        else {
            binding.timer.setVisibility(View.INVISIBLE);
        }
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ScanFragment.this)
                        .navigate(R.id.action_ScanFragment_to_HomeFragment);
            }
        }); //ScanFragment --> HomeFragment
        binding.settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle args = new Bundle();
                args.putBoolean("timer", timer);
                NavHostFragment.findNavController(ScanFragment.this)
                        .navigate(R.id.action_ScanFragment_to_SettingsScanFragment, args);
            }
        }); //ScanFragment --> SettingsScanFragment

        binding.analysisButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle args = new Bundle();
                args.putString("location", "ScanFragment");
                NavHostFragment.findNavController(ScanFragment.this)
                        .navigate(R.id.action_ScanFragment_to_BarcodeAnalysisFragment, args);
            }
        }); //ScanFragment --> BarcodeAnalysisFragment
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}