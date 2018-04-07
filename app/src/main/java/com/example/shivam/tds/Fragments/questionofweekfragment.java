package com.example.shivam.tds.Fragments;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ListView;
import android.widget.ProgressBar;
import com.example.shivam.tds.R;
import com.example.shivam.tds.adaptors.questionofweekadaptor;
import com.example.shivam.tds.classes.questionofweek;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class questionofweekfragment extends Fragment {

    ArrayList<questionofweek> arrayList=new ArrayList<>();
    ListView li;
    DatabaseReference ref;
    Context context;
    ProgressBar p;

    public questionofweekfragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public questionofweekfragment( Context context) {
        this.context=context;
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview= inflater.inflate(R.layout.fragment_questionofweek, container, false);
        final FirebaseDatabase database = FirebaseDatabase.getInstance();

        li=rootview.findViewById(R.id.listviewquestionofweek);
        p=rootview.findViewById(R.id.progressionbarquestionofweek);



        arrayList.clear();
        ref=database.getReference("questionofweek");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot snap:dataSnapshot.getChildren()){
                    questionofweek products=snap.getValue(questionofweek.class);
                    arrayList.add(products);
                }
                questionofweekadaptor adaptor=new questionofweekadaptor(arrayList,context);
                li.setAdapter( adaptor);
                p.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



   return  rootview; }

}
