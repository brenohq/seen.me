package com.example.breno.seenme;

public class RegraDeNegocioSingleton {

    private ListaDeItensSingleton listaDeItensSingleton = new ListaDeItensSingleton();

    private static RegraDeNegocioSingleton ourInstance = new RegraDeNegocioSingleton();

    public static RegraDeNegocioSingleton getInstance() {
        return ourInstance;
    }

    public RegraDeNegocioSingleton() {
    }

    public void cadastrarFilme(String nomeDoFilme, String genero, String ano, String autor, String descricao, String idioma,
                          String duracao,String elenco,String produtora,String formato,String legenda, float avaliacao, int prioridade, boolean isChecked){
        Filme filme = new Filme();
        filme.setNome(nomeDoFilme);
        filme.setGenero(genero);
        filme.setAno(ano);
        filme.setAutor(autor);
        filme.setDescricao(descricao);
        filme.setIdioma(idioma);
        filme.setDuracao(duracao);
        filme.setElenco(elenco);
        filme.setProdutora(produtora);
        filme.setFormato(formato);
        filme.setLegenda(legenda);
        filme.setAvaliacao(avaliacao);
        filme.setPrioridade(prioridade);
        filme.setConsumido(isChecked);
        getListaDeItensSingleton().getListaDeItensCulturais().add(filme);
    }

    public void cadastrarLivro(String nomeDoLivro,String genero,String ano,String autor,String descricao,String idioma,String editora,String edicao,
                               float avaliacao, int prioridade, boolean isChecked){
        Livro livro = new Livro();
        livro.setNome(nomeDoLivro);
        livro.setGenero(genero);
        livro.setAno(ano);
        livro.setAutor(autor);
        livro.setDescricao(descricao);
        livro.setIdioma(idioma);
        livro.setEditora(editora);
        livro.setEdicao(edicao);
        livro.setAvaliacao(avaliacao);
        livro.setPrioridade(prioridade);
        livro.setConsumido(isChecked);
        getListaDeItensSingleton().getListaDeItensCulturais().add(livro);
    }

    public ListaDeItensSingleton getListaDeItensSingleton() {
        return listaDeItensSingleton;
    }
}
