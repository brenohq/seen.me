package com.example.breno.seenme;

public interface UsaLista {
    void cadastrar(ItemCultural item);

    void buscar(String titulo);

    void remover(String titulo);

    void imprimir();
}
