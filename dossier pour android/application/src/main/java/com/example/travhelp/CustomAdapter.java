package com.example.travhelp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    private Context mContext;
    PatientsDbHelper controldb;
    SQLiteDatabase db;
    private ArrayList<String> Id = new ArrayList<String>();
    private ArrayList<String> Name = new ArrayList<String>();

    public CustomAdapter(Context  context, ArrayList<String> Name,ArrayList<String> Id)
    {
        this.mContext = context;
        this.Name = Name;
        this.Id = Id;
    }
    @Override
    public int getCount() {
        return Name.size();
    }
    @Override
    public Object getItem(int position) {
        return null;
    }
    @Override
    public long getItemId(int position) {
        return 0;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        System.out.println("jaja5");
        final    viewHolder holder;
        controldb = new PatientsDbHelper(mContext);
        LayoutInflater layoutInflater;
        if (convertView == null) {
            layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.layout_list_patients, null);
            holder = new viewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.tvname);
        } else {
            holder = (viewHolder) convertView.getTag();
        }


        holder.name.setText(Name.get(position));
        holder.name.setTag(Id.get(position));
        convertView.setTag(Id.get(position));
        return convertView;
    }
    public class viewHolder {
        TextView name;
    }
}
