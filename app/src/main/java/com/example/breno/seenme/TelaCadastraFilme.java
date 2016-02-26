package com.example.breno.seenme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

public class TelaCadastraFilme extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final EditText nomeDoFilme, genero, ano, autor, descricao, idioma, duracao, elenco, produtora, formato, legenda;
        Button cadastrar;
        final RatingBar avaliacao;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastra_filme);

        cadastrar = (Button) findViewById(R.id.btnCadastrar);
        nomeDoFilme = (EditText) findViewById(R.id.nomeDoFilme);
        genero = (EditText) findViewById(R.id.genero);
        ano = (EditText) findViewById(R.id.ano);
        autor = (EditText) findViewById(R.id.autor);
        descricao = (EditText) findViewById(R.id.descricao);
        idioma = (EditText) findViewById(R.id.idioma);
        duracao = (EditText) findViewById(R.id.duracao);
        elenco = (EditText) findViewById(R.id.elenco);
        produtora = (EditText) findViewById(R.id.produtora);
        formato = (EditText) findViewById(R.id.formato);
        legenda = (EditText) findViewById(R.id.legenda);
        avaliacao = (RatingBar) findViewById(R.id.avaliacao);
        final Intent retornaMainActivity = new Intent(getApplicationContext(), MainActivity.class);
        final Filme filme = new Filme();

        cadastrar.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        filme.setNome(nomeDoFilme.getText().toString());
                        filme.setGenero(genero.getText().toString());
                        filme.setAno(ano.getText().toString());
                        filme.setAutor(autor.getText().toString());
                        filme.setDescricao(descricao.getText().toString());
                        filme.setIdioma(idioma.getText().toString());
                        filme.setAvaliacao(avaliacao.getNumStars());
                        filme.setDuracao(duracao.getText().toString());
                        filme.setElenco(elenco.getText().toString());
                        filme.setProdutora(produtora.getText().toString());
                        filme.setFormato(formato.getText().toString());
                        filme.setLegenda(legenda.getText().toString());
                        filme.cadastrar(filme);

                        startActivity(retornaMainActivity);
                    }
                });
    }
}
