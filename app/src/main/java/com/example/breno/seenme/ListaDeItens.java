package com.example.breno.seenme;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

public class ListaDeItens extends Activity {
    private List<ItemCultural> listaDeItensCulturais = new ArrayList<>();

    public List<ItemCultural> getListaDeItens(){
        return listaDeItensCulturais;
    }
}
