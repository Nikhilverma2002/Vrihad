package com.honeysha_tech.vrihad;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.LinearLayout;


public class Home extends Fragment {

   View view ;
   LinearLayout maths;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);



/*        maths = view.findViewById(R.id.linearLayout1);
        maths.setOnClickListener(v-> {
            Fragment quizFrag = new QuizList();
            assert getFragmentManager() != null;
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.container, quizFrag);
            ft.addToBackStack(null);
            ft.commit();

        });*/

        return view;
    }
}