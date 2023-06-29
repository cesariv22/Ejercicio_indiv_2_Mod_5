package com.example.ejercicio_indiv_2_m_5;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ejercicio_indiv_2_m_5.databinding.Fragment1Binding;

public class Fragment1 extends Fragment {

    public Fragment1Binding binding;

    public Fragment1() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = Fragment1Binding.inflate(inflater, container, false);
        return binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        binding.radioGroup.setOnCheckedChangeListener((group, i) -> {

            int index = binding.radioGroup.indexOfChild(binding.radioGroup.findViewById(i));
            switch (index) {

                case 0:
                    binding.fragmentHeader.setText(R.string.yes_msg);
                    break;

                case 1:
                    binding.fragmentHeader.setText(R.string.no_msg);
                    break;
                default:
                    break;
            }
        });
    }
}