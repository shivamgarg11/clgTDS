package com.example.shivam.tds.adaptors;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.shivam.tds.R;
import com.example.shivam.tds.classes.questionofweek;


import java.util.ArrayList;

/**
 * Created by shivam on 07/04/18.
 */

public class questionofweekadaptor extends BaseAdapter {

    ArrayList<questionofweek> questions=new ArrayList<>();
    Context context;

    public questionofweekadaptor(ArrayList<questionofweek> questions, Context context) {
        this.questions = questions;
        this.context = context;
    }

    @Override
    public int getCount() {
        return questions.size();
    }

    @Override
    public questionofweek getItem(int position) {
        return questions.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null) {
            LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = li.inflate(R.layout.layoutquestionofdaylistview, parent, false);
        }

        final questionofweek f=questions.get(position);

        TextView weekno=convertView.findViewById(R.id.questionweeknumber);
        TextView description=convertView.findViewById(R.id.questiondetail);
        TextView input=convertView.findViewById(R.id.questioninput);
        TextView output=convertView.findViewById(R.id.questionoutput);
        Button solve=convertView.findViewById(R.id.questionsolve);
        Button summission=convertView.findViewById(R.id.questionsummision);

        weekno.setText(f.getWeekno());
        description.setText(f.getDescription());
        input.setText(f.getInput());
        output.setText(f.getOutput());

        solve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = f.getSolve();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                context.startActivity(i);
            }
        });

        summission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = f.getSolution();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                context.startActivity(i);
            }
        });




        return convertView;
    }
}
