package com.example.breno.seenme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RegraDeNegocioSingleton regraDeNegocioSingleton = RegraDeNegocioSingleton.getInstance();

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