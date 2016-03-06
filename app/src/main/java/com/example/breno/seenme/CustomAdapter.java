package com.example.breno.seenme;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<ItemCultural> {

    public static final int VIEW_TYPE_MAINACTIVITY = 124; // qualquer número inteiro.
    public static final int VIEW_TYPE_TELACADAS = 125; // qualquer número inteiro.

    private int viewType;
    List<ItemCultural> lista;
    private final LayoutInflater mInflater;
    private int resource;

    public CustomAdapter(Context context, int resource, List<ItemCultural> items, int viewType) {
        super(context, resource, items);
        this.viewType = viewType;
        this.lista = items;
        mInflater = LayoutInflater.from(context);
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v;
        if (convertView == null) {
            v = mInflater.inflate(resource, parent, false);
        } else {
            v = convertView;
        }
        if (viewType == VIEW_TYPE_MAINACTIVITY) {
            if (lista.get(position).isConsumido()) {
                v.setVisibility(View.GONE);
            } else {
                v.setVisibility(View.VISIBLE);
                ((TextView) v).setText(lista.get(position).toString());
            }
        } else if (viewType == VIEW_TYPE_TELACADAS) {
            ((TextView) v).setText(lista.get(position).toString());
        } else {
            // Caso uma Tela de cadastro de séries fosse implementada, o código viria aqui.
        }
        return v;
    }
}