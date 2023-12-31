package com.example.deltascan;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import  com.example.deltascan.R;
import com.example.deltascan.databinding.FragmentBarcodeAnalysisBinding;

public class BarcodeAnalysisFragment extends Fragment {

    private FragmentBarcodeAnalysisBinding binding;
    private String prevLocation;

    public BarcodeAnalysisFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            prevLocation = getArguments().getString("location");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBarcodeAnalysisBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(prevLocation.equals("PaintFragment")) {
                    NavHostFragment.findNavController(BarcodeAnalysisFragment.this)
                            .navigate(R.id.action_BarcodeAnalysisFragment_to_PaintFragment);
                }
                else if(prevLocation.equals("ScanFragment")) {
                    NavHostFragment.findNavController(BarcodeAnalysisFragment.this)
                            .navigate(R.id.action_BarcodeAnalysisFragment_to_ScanFragment);
                }
            }
        }); //barcodeAnalysisFragment --> PrevFragment

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}