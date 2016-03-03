package com.example.breno.seenme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listaOrdenada = (ListView) findViewById(R.id.listaOrdenada);
        listaOrdenada.setClickable(true);

        RegraDeNegocioSingleton regraDeNegocioSingleton = RegraDeNegocioSingleton.getInstance();
        final ArrayAdapter<ItemCultural> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, regraDeNegocioSingleton.getListaDeItensSingleton().getListaDeItensCulturais());
        ListView listView = (ListView) findViewById(R.id.listaOrdenada);
        listView.setClickable(true);
        listView.setAdapter(arrayAdapter);

        /*try {
            ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("arquivo.txt"));
            regraDeNegocioSingleton.getListaDeItensSingleton().getListaDeItensCulturais() = (List<ItemCultural>) entrada.readObject();
            entrada.close();
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }*/
    }

    public void startCadastraFilme(View view) {
        Intent telaCadastraFilme = new Intent(this, TelaCadastraFilme.class);
        startActivity(telaCadastraFilme);
    }

    public void startCadastraLivro(View view) {
        Intent telaCadastraLivro = new Intent(this, TelaCadastraLivro.class);
        startActivity(telaCadastraLivro);
    }

    public void startCadastrados(View view) {
        Intent telaCadastrados = new Intent(this, TelaCadastrados.class);
        startActivity(telaCadastrados);
    }
}