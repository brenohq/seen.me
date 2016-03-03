package com.example.breno.seenme;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListaDeItensSingleton implements Serializable{
    private List<ItemCultural> listaDeItensCulturais = new ArrayList<>();

    private static ListaDeItensSingleton ourInstance = new ListaDeItensSingleton();

    public static ListaDeItensSingleton getInstance() {
        return ourInstance;
    }

    public ListaDeItensSingleton() {
    }

    public List<ItemCultural> getListaDeItensCulturais() {
        return this.listaDeItensCulturais;
    }

    public void setListaDeItensCulturais(List<ItemCultural> lista){
        this.listaDeItensCulturais = lista;
    }
}
