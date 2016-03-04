package com.example.breno.seenme;

import android.widget.ArrayAdapter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListaDeItensSingleton implements Serializable {
    private List<ItemCultural> listaDeItensCulturais = new ArrayList<>();

    private ArrayList listaDeItensCulturaisOrdenados = new ArrayList<>();

    private static ListaDeItensSingleton ourInstance = new ListaDeItensSingleton();

    public static ListaDeItensSingleton getInstance() {
        return ourInstance;
    }

    public ListaDeItensSingleton() {
    }

    public List<ItemCultural> getListaDeItensCulturais() {
        return this.listaDeItensCulturais;
    }

    public ArrayList getListaDeItensCulturaisOrdenados() {
        return this.listaDeItensCulturaisOrdenados;
    }

    public void setListaDeItensCulturais(List<ItemCultural> lista) {
        this.listaDeItensCulturais = lista;
    }

    public void setListaDeItensCulturaisOrdenados(List<ItemCultural> lista) {

        ArrayList<ItemCultural> copiaLista = new ArrayList<>();
        for (ItemCultural i : lista) {
            copiaLista.add(i);
        }
        ordenar(copiaLista);

        for(int i = 0; i < copiaLista.size(); i++){
            if(copiaLista.get(i).isConsumido()){
                copiaLista.remove(i);
            }
        }

        this.listaDeItensCulturaisOrdenados = (ArrayList) copiaLista;
    }

    public void ordenar(ArrayList<ItemCultural> array) {
        int i;
        boolean a = true;
        while (a) {
            a = false;
            for (i = 0; i < array.size() - 1; i++) {
                if (array.get(i).getPrioridade() < array.get(i + 1).getPrioridade()) {
                    Collections.swap(array, i, i + 1);
                    a = true;
                }
            }
        }
    }
}
