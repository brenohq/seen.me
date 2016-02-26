package com.example.breno.seenme;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TelaCadastrados extends ListaDeItens {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastrados);

        ListView listview = (ListView) findViewById(R.id.listaDeItensCadastrados);
        ArrayAdapter<ItemCultural> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, listaDeItensCulturais);

        listview.setAdapter(arrayAdapter);
    }
}