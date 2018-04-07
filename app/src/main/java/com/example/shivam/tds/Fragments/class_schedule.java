package com.example.shivam.tds.Fragments;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.shivam.tds.R;
import com.example.shivam.tds.adaptors.classscheduleadaptor;
import com.example.shivam.tds.classes.classschedule;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class class_schedule extends Fragment {

    ArrayList<classschedule> arrayList=new ArrayList<>();
    ListView li;
    DatabaseReference ref;
    Context context;
    Button java,cpp;
    ProgressBar p;
    TextView selectlanguage;


    public class_schedule() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public class_schedule(Context context) {
        this.context=context;

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview= inflater.inflate(R.layout.fragment_class_schedule, container, false);

        li=rootview.findViewById(R.id.listviewclassschedule);
        java=rootview.findViewById(R.id.javaclassbtn);
        cpp=rootview.findViewById(R.id.cppclassbtn);
        p=rootview.findViewById(R.id.classprogressionbar);
        selectlanguage=rootview.findViewById(R.id.selectlanguage);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();

        java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //progress();
                p.setVisibility(View.VISIBLE);
                selectlanguage.setVisibility(View.GONE);
                arrayList.clear();
                ref=database.getReference("javaclassschedule");
                ref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for(DataSnapshot snap:dataSnapshot.getChildren()){
                            classschedule products=snap.getValue(classschedule.class);
                            arrayList.add(products);
                        }
                        classscheduleadaptor adaptors=new classscheduleadaptor(arrayList,context);
                        li.setAdapter(adaptors);
                        p.setVisibility(View.GONE);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });

        cpp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectlanguage.setVisibility(View.GONE);
                p.setVisibility(View.VISIBLE);
                arrayList.clear();
                ref=database.getReference("cppclassschedule");
                ref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for(DataSnapshot snap:dataSnapshot.getChildren()){
                            classschedule products=snap.getValue(classschedule.class);
                            arrayList.add(products);
                        }
                        classscheduleadaptor adaptors=new classscheduleadaptor(arrayList,context);
                        li.setAdapter(adaptors);
                        p.setVisibility(View.GONE);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });




    return rootview;}



}
