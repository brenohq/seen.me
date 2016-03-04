package com.example.breno.seenme;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListaDeItensSingleton implements Serializable {
    private List<ItemCultural> listaDeItensCulturais = new ArrayList<>();

    private static ListaDeItensSingleton ourInstance = new ListaDeItensSingleton();

    public static ListaDeItensSingleton getInstance() {
        return ourInstance;
    }

    public ListaDeItensSingleton() {
    }

    public List<ItemCultural> getListaDeItensCulturais() {
        ordenar(this.listaDeItensCulturais);
        return this.listaDeItensCulturais;
    }

    public void setListaDeItensCulturais(List<ItemCultural> lista) {
        this.listaDeItensCulturais = lista;
    }

    public void ordenar(List<ItemCultural> array) {
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
