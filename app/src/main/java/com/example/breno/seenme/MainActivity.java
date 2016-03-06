package com.example.breno.seenme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

/**
 * Classe principal da interface de usuário, onde fica a nossa tela inicial.
 */
public class MainActivity extends AppCompatActivity {
    /**
     * Inicia a tela de cadastrar Filme
     *
     * @param view a interface a ser chamada
     */
    public void startCadastraFilme(View view) {
        Intent telaCadastraFilme = new Intent(this, TelaCadastraFilme.class);
        startActivity(telaCadastraFilme);
    }

    /**
     * Inicia a tela inicial
     *
     * @param view a interface a ser chamada
     */
    public void startMainActivity(Intent view) {
        Intent mainActivity = new Intent(this, MainActivity.class);
        startActivity(mainActivity);
    }

    /**
     * Inicia a tela de cadastrar Livro
     *
     * @param view a interface a ser chamada
     */
    public void startCadastraLivro(View view) {
        Intent telaCadastraLivro = new Intent(this, TelaCadastraLivro.class);
        startActivity(telaCadastraLivro);
    }

    /**
     * Inicia a tela de vizualizar os itens cadastrados
     *
     * @param view a interface a ser chamada
     */
    public void startCadastrados(View view) {
        Intent telaCadastrados = new Intent(this, TelaCadastrados.class);
        startActivity(telaCadastrados);
    }

    /**
     * Quando a tela é chamada inicia esta função, cuja tem um objeto de CustomAdapter para deixar
     * os itens que não estao consumidos visivel na interface que é criada nessa função, onde aparece
     * na tela inicial.
     *
     * @param savedInstanceState instancia salva a partir da tela anterior.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RegraDeNegocioSingleton regraDeNegocioSingleton = RegraDeNegocioSingleton.getInstance();

        setContentView(R.layout.activity_main);
        ListView listaOrdenada = (ListView) findViewById(R.id.listaOrdenada);
        listaOrdenada.setClickable(true);

        final CustomAdapter myAdapter = new CustomAdapter(this, android.R.layout.simple_list_item_1, regraDeNegocioSingleton.getListaDeItensSingleton().getListaDeItensCulturais(), CustomAdapter.VIEW_TYPE_MAINACTIVITY);

        ListView listView = (ListView) findViewById(R.id.listaOrdenada);
        listView.setClickable(false);
        listView.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
    }

    /**
     * Quando precionamos o botao de voltar do device, volta para a tela Inicial
     */
    @Override
    public void onBackPressed() {
        Intent retornaMainActivity = new Intent(getApplicationContext(), MainActivity.class);
        startMainActivity(retornaMainActivity);
    }
}

