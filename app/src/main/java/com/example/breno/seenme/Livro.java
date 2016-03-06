package com.example.breno.seenme;

/**
 * Classe que tem os atributos de um livro.
 */
public class Livro extends ItemCultural {
    private String edicao;
    private String editora;


    public Livro() {
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getEditora() {
        return editora;
    }
}
