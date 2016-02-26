package com.example.breno.seenme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

public class TelaCadastraLivro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final EditText nomeDoLivro, genero, ano, autor, descricao, idioma, editora, edicao;
        Button cadastrar;
        final RatingBar avaliacao;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastra_livro);

        cadastrar = (Button) findViewById(R.id.btnCadastrarLivro);
        nomeDoLivro = (EditText) findViewById(R.id.nomeDoLivro);
        genero = (EditText) findViewById(R.id.genero);
        ano = (EditText) findViewById(R.id.ano);
        autor = (EditText) findViewById(R.id.autor);
        descricao = (EditText) findViewById(R.id.descricao);
        idioma = (EditText) findViewById(R.id.idioma);
        avaliacao = (RatingBar) findViewById(R.id.avaliacao);
        editora = (EditText) findViewById(R.id.editora);
        edicao = (EditText) findViewById(R.id.edicao);
        final Intent retornaMainActivity = new Intent(getApplicationContext(), MainActivity.class);
        final Livro livro = new Livro();

        cadastrar.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        livro.setNome(nomeDoLivro.getText().toString());
                        livro.setGenero(genero.getText().toString());
                        livro.setAno(ano.getText().toString());
                        livro.setAutor(autor.getText().toString());
                        livro.setDescricao(descricao.getText().toString());
                        livro.setIdioma(idioma.getText().toString());
                        livro.setAvaliacao(avaliacao.getNumStars());
                        livro.setEditora(editora.getText().toString());
                        livro.setEdicao(edicao.getText().toString());
                        livro.cadastrar(livro);

                        startActivity(retornaMainActivity);
                    }
                });
    }
}