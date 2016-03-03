package com.example.breno.seenme;

import java.io.Serializable;

public abstract class ItemCultural implements Serializable {
    private String nome;
    private String genero;
    private String ano;
    private String autor;
    private String descricao;
    private String classificacaoIndicativa;
    private float avaliacao;
    private int prioridade;
    private boolean consumido;
    private String protagonistas;
    private String precedidoPor;
    private String prosseguidoPor;
    private String idioma;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getClassificacaoIndicativa() {
        return classificacaoIndicativa;
    }

    public void setClassificacaoIndicativa(String classificacaoIndicativa) {
        this.classificacaoIndicativa = classificacaoIndicativa;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public boolean isConsumido() {
        return consumido;
    }

    public void setConsumido(boolean consumido) {
        this.consumido = consumido;
    }

    public float getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(float avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getProtagonistas() {
        return protagonistas;
    }

    public void setProtagonistas(String protagonistas) {
        this.protagonistas = protagonistas;
    }

    public String getProsseguidoPor() {
        return prosseguidoPor;
    }

    public void setProsseguidoPor(String prosseguidoPor) {
        this.prosseguidoPor = prosseguidoPor;
    }

    public String getPrecedidoPor() {
        return precedidoPor;
    }

    public void setPrecedidoPor(String precedidoPor) {
        this.precedidoPor = precedidoPor;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    @Override
    public String toString() {
        return getNome();
    }
}
