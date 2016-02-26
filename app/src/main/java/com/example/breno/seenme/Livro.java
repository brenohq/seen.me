package com.example.breno.seenme;

public class Livro extends ItemCultural {
    private int numeroDePaginas;
    private String dataDaPublicacao;
    private String tipoDeCapa;
    private String edicao;
    private String editora;


    public Livro() {
    }

    public int getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public void setNumeroDePaginas(int numeroDePaginas) {
        this.numeroDePaginas = numeroDePaginas;
    }

    public String getTipoDeCapa() {
        return tipoDeCapa;
    }

    public void setTipoDeCapa(String tipoDeCapa) {
        this.tipoDeCapa = tipoDeCapa;
    }

    public String getDataDaPublicacao() {
        return dataDaPublicacao;
    }

    public void setDataDaPublicacao(String dataDaPublicacao) {
        this.dataDaPublicacao = dataDaPublicacao;
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
