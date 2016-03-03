package com.example.breno.seenme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;

public class TelaCadastraFilme extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final EditText nomeDoFilme, genero, ano, autor, descricao, idioma, duracao, elenco, produtora, formato, legenda;
        Button cadastrar;
        final RatingBar avaliacao;
        final CheckBox checkBoxFilme;
        final Spinner spinnerFilme;

        final RegraDeNegocioSingleton regraDeNegocioSingleton = RegraDeNegocioSingleton.getInstance();

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
        checkBoxFilme = (CheckBox) findViewById(R.id.checkBoxFilme);
        spinnerFilme = (Spinner) findViewById(R.id.spinnerFilme);
        final Intent retornaMainActivity = new Intent(getApplicationContext(), MainActivity.class);

        checkBoxFilme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBoxFilme.isChecked()){
                    avaliacao.setVisibility(View.VISIBLE);
                }else {
                    avaliacao.setVisibility(View.INVISIBLE);
                }
            }
        });

        cadastrar.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        regraDeNegocioSingleton.cadastrarFilme(nomeDoFilme.getText().toString(), genero.getText().toString(), ano.getText().toString(),
                                autor.getText().toString(), descricao.getText().toString(), idioma.getText().toString(), duracao.getText().toString(),
                                elenco.getText().toString(), produtora.getText().toString(), formato.getText().toString(), legenda.getText().toString(),
                                avaliacao.getRating(), spinnerFilme.getSelectedItemPosition()+1, checkBoxFilme.isChecked());
                        startActivity(retornaMainActivity);
                    }
                });
    }
}
