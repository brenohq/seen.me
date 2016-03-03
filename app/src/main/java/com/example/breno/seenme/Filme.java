package com.example.breno.seenme;

import java.io.Serializable;

public class Filme extends ItemCultural implements Serializable{
    private String duracao;
    private String elenco;
    private String produtora;
    private String qualidade;
    private String formato;
    private String legenda;

    public Filme() {

    }

    public String getDuracao() {
        return duracao;
    }

    public String getLegenda(){
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

    public String getQualidade() {
        return qualidade;
    }

    public void setQualidade(String qualidade) {
        this.qualidade = qualidade;
    }

    public String isLegenda() {
        return legenda;
    }

    public void setLegenda(String legenda) {
        this.legenda = legenda;
    }

    public String exibeDetalhes() {
        return this.getDuracao() + ". " + this.getFormato() + " [$" + this.getProdutora() + "]";
    }
}
