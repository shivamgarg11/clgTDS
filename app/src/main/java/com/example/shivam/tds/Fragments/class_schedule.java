package com.example.shivam.tds.Fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shivam.tds.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class class_schedule extends Fragment {


    public class_schedule() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_class_schedule, container, false);
    }

}
