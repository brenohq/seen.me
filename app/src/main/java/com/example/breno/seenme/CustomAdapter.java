package com.example.breno.seenme;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<ItemCultural> {

    public CustomAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public CustomAdapter(Context context, int resource, List<ItemCultural> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if(this.getItem(position).isConsumido()){
            // I Think the code to hide elements with isConsumido = true
        }else{

        }

        return v;
    }


}