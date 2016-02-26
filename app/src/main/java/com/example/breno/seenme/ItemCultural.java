package com.example.breno.seenme;

public abstract class ItemCultural extends ListaDeItens implements UsaLista {
    private String nome;
    private String genero;
    private String ano;
    private String autor;
    private String descricao;
    private int classificacaoIndicativa;
    private int avaliacao;
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

    public int getClassificacaoIndicativa() {
        return classificacaoIndicativa;
    }

    public void setClassificacaoIndicativa(int classificacaoIndicativa) {
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

    public int getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(int avaliacao) {
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
    public void cadastrar(ItemCultural item) {
        getListaDeItens().add(item);
    }

    @Override
    public void buscar(String titulo) {

        boolean contem = false;
        for (ItemCultural i : getListaDeItens()) {
            if (nome.equals(i.getNome())) {
                System.out.println(i);
                contem = true;
            }
        }
        if (!contem)
            System.out.println("Não existe item Cultural cadastrado com esse Nome! ");
    }

    @Override
    public void remover(String titulo) {
        for (ItemCultural i : getListaDeItens()) {
            if (nome.equals(i.getNome())) {
                getListaDeItens().remove(i);
            }
        }
    }

    @Override
    public void imprimir() {
        for (ItemCultural i : getListaDeItens()) {
        }
    }

    @Override
    public String toString() {
        return getNome();
    }
}
