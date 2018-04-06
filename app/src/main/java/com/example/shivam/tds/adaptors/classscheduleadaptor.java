package com.example.shivam.tds.adaptors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shivam.tds.R;
import com.example.shivam.tds.classes.classschedule;

import java.util.ArrayList;

/**
 * Created by shivam on 06/04/18.
 */

public class classscheduleadaptor extends BaseAdapter {

    ArrayList<classschedule> classes=new ArrayList<>();
    Context context;

    public classscheduleadaptor(ArrayList<classschedule> classes, Context context) {
        this.classes = classes;
        this.context = context;
    }

    @Override
    public int getCount() {
        return classes.size();
    }

    @Override
    public classschedule getItem(int position) {
        return classes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null) {
            LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = li.inflate(R.layout.layoutclassscheduleforlistview, parent, false);
        }

        final classschedule f=classes.get(position);

        TextView topic=convertView.findViewById(R.id.classtopicname);
        TextView time=convertView.findViewById(R.id.classtime);
        TextView lecture=convertView.findViewById(R.id.classlecturenumber);
        TextView venue=convertView.findViewById(R.id.classvenue);
        TextView teacher=convertView.findViewById(R.id.classteacher);

        topic.setText(f.getTopic());
        lecture.setText(f.getLectureno());
        time.setText(f.getTime());
        venue.setText(f.getVenue());
        teacher.setText(f.getTeacher());


        return convertView;
    }
}
