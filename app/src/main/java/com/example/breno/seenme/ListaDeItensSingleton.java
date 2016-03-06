package com.example.breno.seenme;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Contem a lista de ItensCulturais que guardam Filmes e Livros instanciados
 */
public class ListaDeItensSingleton {
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

    /**
     * Ordena o arrayList  por ordem de prioridade, e dá preferência aos atributos não consumidos.
     *
     * @param array a lista que é para ser ordenada
     */
    public void ordenar(List<ItemCultural> array) {

        // Ordena a lista de acordo com o atributo prioridade de cada Item Cultural

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

        // Ordena colocando os itens já consumidos para o fim da lista.

        int k = 0;
        for (i = 0; i < array.size() - k; i++) {
            if (array.get(i).isConsumido()) {
                ItemCultural item = array.remove(i);
                array.add(item);
                k++;
                i--;
            }
        }
    }
}
