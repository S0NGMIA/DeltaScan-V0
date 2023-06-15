package com.example.deltascan;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.deltascan.databinding.FragmentPaintBinding;

public class PaintFragment extends Fragment {
    private FragmentPaintBinding binding;
    public PaintFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentPaintBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(PaintFragment.this)
                        .navigate(R.id.action_PaintFragment_to_HomeFragment);
            }
        }); //Paint Fragment --> HomeFragment
        binding.settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(PaintFragment.this)
                        .navigate(R.id.action_PaintFragment_to_SettingsPaintFragment);
            }
        }); //PaintFragment --> SettingsPaintFragment

        binding.analysisButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle args = new Bundle();
                args.putString("location", "PaintFragment");
                NavHostFragment.findNavController(PaintFragment.this)
                        .navigate(R.id.action_PaintFragment_to_BarcodeAnalysisFragment, args);
            }
        }); //PaintFragment --> BarcodeAnalysisFragment
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}