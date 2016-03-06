package com.example.breno.seenme;

/**
 * Classe que trata todas as logicas do programa, onde ela que tem o relacionamento da Interface de
 * usuario com a regra de negocio
 */
public class RegraDeNegocioSingleton {

    private ListaDeItensSingleton listaDeItensSingleton = new ListaDeItensSingleton();

    private static RegraDeNegocioSingleton ourInstance = new RegraDeNegocioSingleton();

    public static RegraDeNegocioSingleton getInstance() {
        return ourInstance;
    }

    public RegraDeNegocioSingleton() {
    }

    /**
     * Manda os valores que a interface de usuario recebeu para a classe filme, instanciando cada
     * atributo.
     *
     * @param nomeDoFilme
     * @param genero
     * @param ano
     * @param autor
     * @param descricao
     * @param idioma
     * @param duracao
     * @param elenco
     * @param produtora
     * @param formato
     * @param legenda
     * @param avaliacao
     * @param prioridade
     * @param isChecked   se a checkBox da tela de cadastro está ou não marcada.
     */
    public void cadastrarFilme(String nomeDoFilme, String genero, String ano, String autor, String descricao, String idioma,
                               String duracao, String elenco, String produtora, String formato, String legenda, float avaliacao, int prioridade, boolean isChecked) {
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

    /**
     * Manda os valores que a interface de usuario recebeu para a classe livro, instanciando cada
     * atributo.
     *
     * @param nomeDoLivro
     * @param genero
     * @param ano
     * @param autor
     * @param descricao
     * @param idioma
     * @param editora
     * @param edicao
     * @param avaliacao
     * @param prioridade
     * @param isChecked   se a checkBox da tela de cadastro está ou não marcada.
     */
    public void cadastrarLivro(String nomeDoLivro, String genero, String ano, String autor, String descricao, String idioma, String editora, String edicao,
                               float avaliacao, int prioridade, boolean isChecked) {
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

    /**
     * Retorna a lista de itens da classe ListaDeItensSingleton
     *
     * @return
     */
    public ListaDeItensSingleton getListaDeItensSingleton() {
        return listaDeItensSingleton;
    }
}
