package com.example.breno.seenme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {

    public void startCadastraFilme(View view) {
        Intent telaCadastraFilme = new Intent(this, TelaCadastraFilme.class);
        startActivity(telaCadastraFilme);
    }

    public void startMainActivity(Intent view){
        Intent mainActivity = new Intent(this, MainActivity.class);
        startActivity(mainActivity);
    }

    public void startCadastraLivro(View view) {
        Intent telaCadastraLivro = new Intent(this, TelaCadastraLivro.class);
        startActivity(telaCadastraLivro);
    }

    public void startCadastrados(View view) {
        Intent telaCadastrados = new Intent(this, TelaCadastrados.class);
        startActivity(telaCadastrados);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listaOrdenada = (ListView) findViewById(R.id.listaOrdenada);
        listaOrdenada.setClickable(true);

        RegraDeNegocioSingleton regraDeNegocioSingleton = RegraDeNegocioSingleton.getInstance();

        final ArrayAdapter<ItemCultural> arrayAdapterOrdenado = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, regraDeNegocioSingleton.getListaDeItensSingleton().getListaDeItensCulturais());

        ListView listView = (ListView) findViewById(R.id.listaOrdenada);
        listView.setClickable(false);
        listView.setAdapter(arrayAdapterOrdenado);
        arrayAdapterOrdenado.notifyDataSetChanged();



        /*try {
            // Save the list of entries to internal storage
            //InternalStorage.writeObject(this, "arquivo.txt", regraDeNegocioSingleton.getListaDeItensSingleton().getListaDeItensCulturais());

            // Retrieve the list from internal storage
            List<ItemCultural> cachedEntries = (List<ItemCultural>) InternalStorage.readObject(this, "arquivo.txt");
            regraDeNegocioSingleton.getListaDeItensSingleton().setListaDeItensCulturais(cachedEntries);

        } catch (IOException e) {

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/

        /*try {
            ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("arquivo.txt"));
            regraDeNegocioSingleton.getListaDeItensSingleton().getListaDeItensCulturais() = (List<ItemCultural>) entrada.readObject();
            entrada.close();
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }*/
    }

    @Override
    public void onBackPressed (){
        Intent retornaMainActivity = new Intent(getApplicationContext(), MainActivity.class);
        startMainActivity(retornaMainActivity);
    }

 /*   @Override
    public void onDestroy(){
        super.onDestroy();
        try {
            RegraDeNegocioSingleton regraDeNegocioSingleton = RegraDeNegocioSingleton.getInstance();

            InternalStorage.writeObject(this, "arquivo.txt", regraDeNegocioSingleton.getListaDeItensSingleton().getListaDeItensCulturais());

        }catch (Exception e){
        }
    }*/
}

