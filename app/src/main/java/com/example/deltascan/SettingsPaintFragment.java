package com.example.deltascan;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.text.Editable;
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
       if(getArguments().getBoolean("timer")) {
           binding.timer.setChecked(true);
       }
        if(getArguments().getInt("counter")!=-1) {
           // binding.amntScanInput.setText(getArguments().getInt("counter"));
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
                String countAmnt = binding.amntScanInput.getText().toString();
                if(!countAmnt.isEmpty()) {
                    args.putInt("count", Integer.parseInt(countAmnt));
                }
                else {
                    args.putInt("count", -1);
                }
                NavHostFragment.findNavController(SettingsPaintFragment.this)
                        .navigate(R.id.action_SettingsPaintFragment_to_PaintFragment, args);
            }
        }); //SettingsPaintFragment --> paintFragment
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}