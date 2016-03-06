package com.example.breno.seenme;

import java.io.Serializable;

/**
 * Classe que tem os atributos de um filme.
 */
public class Filme extends ItemCultural {
    private String duracao;
    private String elenco;
    private String produtora;
    private String formato;
    private String legenda;

    public Filme() {

    }

    public String getDuracao() {
        return duracao;
    }

    public String getLegenda() {
        return legenda;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getProdutora() {
        return produtora;
    }

    public void setProdutora(String produtora) {
        this.produtora = produtora;
    }

    public String getElenco() {
        return elenco;
    }

    public void setElenco(String elenco) {
        this.elenco = elenco;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public void setLegenda(String legenda) {
        this.legenda = legenda;
    }
}
