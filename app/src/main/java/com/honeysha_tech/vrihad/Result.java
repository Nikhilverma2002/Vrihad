package com.honeysha_tech.vrihad;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Objects;


public class Result extends Fragment {

    View view;
    TextView done;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_result, container, false);

        done = view.findViewById(R.id.textView6);
        done.setOnClickListener(v->{
            requireActivity().finish();
        });


        return view;
    }
}