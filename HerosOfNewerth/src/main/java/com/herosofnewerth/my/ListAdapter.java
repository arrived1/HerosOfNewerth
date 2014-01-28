package com.herosofnewerth.my;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<DataBaseRecord> {

    private final Context context;
    private final ArrayList<DataBaseRecord> itemsArrayList;

    public ListAdapter(Context context, ArrayList<DataBaseRecord> itemsArrayList) {
        super(context, R.layout.row, itemsArrayList);

        this.context = context;
        this.itemsArrayList = itemsArrayList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row, parent, false);

        TextView positionView = (TextView)rowView.findViewById(R.id.position);
        TextView scoreView = (TextView)rowView.findViewById(R.id.scoreRes);
        TextView timeView = (TextView)rowView.findViewById(R.id.timeRes);

        if(itemsArrayList.size() == 0) {
            TextView label1View = (TextView)rowView.findViewById(R.id.labelTxt1);
            TextView label2View = (TextView)rowView.findViewById(R.id.labelTxt2);

            label1View.setText("");
            label2View.setText("");

            positionView.setText("");
            scoreView.setText("No scores");
            timeView.setText("");
        }
        else {
            positionView.setText(Integer.toString(position + 1));
            scoreView.setText(itemsArrayList.get(position).getScore());
            timeView.setText(itemsArrayList.get(position).getTime());
        }
        return rowView;
    }
}