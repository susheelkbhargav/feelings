package com.susheel.autism.feelings;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;


public class ArrayContactAdapter extends ArrayAdapter<Contact> {

    public ArrayContactAdapter(Context context, int resource, List<Contact> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Contact c = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    com.susheel.autism.feelings.R.layout.item_contact, parent, false);
        }
        TextView tvContactName = (TextView) convertView.findViewById(com.susheel.autism.feelings.R.id.tvContactName);
        tvContactName.setText(c.getName());
        return convertView;         // Return the completed view to render on screen
    }
}
