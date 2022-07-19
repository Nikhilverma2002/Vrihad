package com.honeysha_tech.vrihad;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Quiz extends Fragment {

   View view;
   TextView play;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_quiz, container, false);

        play = view.findViewById(R.id.play);

        play.setOnClickListener(v->{
            Intent intent = new Intent(getActivity(),QAndA.class);
            startActivity(intent);
        });

        return view;
    }
}