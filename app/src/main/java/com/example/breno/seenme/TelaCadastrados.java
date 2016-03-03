package com.example.breno.seenme;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.Toast;


public class TelaCadastrados extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastrados);
        final String[] consumido = new String[1];


        ListView listView = (ListView) findViewById(R.id.listaDeItensCadastrados);
        listView.setClickable(true);
        final RegraDeNegocioSingleton regraDeNegocioSingleton = RegraDeNegocioSingleton.getInstance();

        final ArrayAdapter<ItemCultural> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, regraDeNegocioSingleton.getListaDeItensSingleton().getListaDeItensCulturais());
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, final int position, long id) {

                AlertDialog.Builder firstBuilder = new AlertDialog.Builder(TelaCadastrados.this);
                firstBuilder.setTitle(arrayAdapter.getItem(position).getNome());

                if (regraDeNegocioSingleton.getListaDeItensSingleton().getListaDeItensCulturais().get(position).isConsumido()) {
                    consumido[0] = " Sim";
                } else {
                    consumido[0] = " Não";
                }

                String textoComDetalhes = "Gênero: " + regraDeNegocioSingleton.getListaDeItensSingleton().getListaDeItensCulturais().get(position).getGenero() + "\n" +
                        "Prioridade: " + regraDeNegocioSingleton.getListaDeItensSingleton().getListaDeItensCulturais().get(position).getPrioridade() + "\n" +
                        "Ano: " + regraDeNegocioSingleton.getListaDeItensSingleton().getListaDeItensCulturais().get(position).getAno() + "\n" +
                        "Autor: " + regraDeNegocioSingleton.getListaDeItensSingleton().getListaDeItensCulturais().get(position).getAutor() + "\n" +
                        "Descrição: " + regraDeNegocioSingleton.getListaDeItensSingleton().getListaDeItensCulturais().get(position).getDescricao() + "\n" +
                        "Idioma: " + regraDeNegocioSingleton.getListaDeItensSingleton().getListaDeItensCulturais().get(position).getIdioma() + "\n" +
                        "Avaliação: " + regraDeNegocioSingleton.getListaDeItensSingleton().getListaDeItensCulturais().get(position).getAvaliacao() + "\n" +
                        "Consumido:" + consumido[0] + "\n";

                if (regraDeNegocioSingleton.getListaDeItensSingleton().getListaDeItensCulturais().get(position) instanceof Filme) {
                    textoComDetalhes = textoComDetalhes +
                            "Duracao: " + ((Filme) regraDeNegocioSingleton.getListaDeItensSingleton().getListaDeItensCulturais().get(position)).getDuracao() + "\n" +
                            "Elenco: " + ((Filme) regraDeNegocioSingleton.getListaDeItensSingleton().getListaDeItensCulturais().get(position)).getElenco() + "\n" +
                            "Produtora: " + ((Filme) regraDeNegocioSingleton.getListaDeItensSingleton().getListaDeItensCulturais().get(position)).getProdutora() + "\n" +
                            "Formato: " + ((Filme) regraDeNegocioSingleton.getListaDeItensSingleton().getListaDeItensCulturais().get(position)).getFormato() + "\n" +
                            "Legenda: " + ((Filme) regraDeNegocioSingleton.getListaDeItensSingleton().getListaDeItensCulturais().get(position)).getLegenda();
                    firstBuilder.setIcon(R.drawable.iconefilme);
                }

                if (regraDeNegocioSingleton.getListaDeItensSingleton().getListaDeItensCulturais().get(position) instanceof Livro) {
                    textoComDetalhes = textoComDetalhes +
                            "Editora: " + ((Livro) regraDeNegocioSingleton.getListaDeItensSingleton().getListaDeItensCulturais().get(position)).getEditora() + "\n" +
                            "Edição: " + ((Livro) regraDeNegocioSingleton.getListaDeItensSingleton().getListaDeItensCulturais().get(position)).getEdicao();
                    firstBuilder.setIcon(R.drawable.rsz_book);
                }

                firstBuilder.setMessage(textoComDetalhes);
                final String labelEditar, labelToast;


                if (regraDeNegocioSingleton.getListaDeItensSingleton().getListaDeItensCulturais().get(position).isConsumido()) {
                    labelEditar = "Marcar como não consumido";
                    labelToast = "Não!";

                } else {
                    labelEditar = "Marcar como consumido";
                    labelToast = "Sim!";
                }

                firstBuilder.setNeutralButton(labelEditar, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        if (regraDeNegocioSingleton.getListaDeItensSingleton().getListaDeItensCulturais().get(position).isConsumido()) {
                            regraDeNegocioSingleton.getListaDeItensSingleton().getListaDeItensCulturais().get(position).setConsumido(false);
                        } else {
                            regraDeNegocioSingleton.getListaDeItensSingleton().getListaDeItensCulturais().get(position).setConsumido(true);

                            /*AlertDialog.Builder secondBuilder = new AlertDialog.Builder(TelaCadastrados.this);
                            secondBuilder.setTitle("Avalie este item!");

                            secondBuilder.setView(R.layout.layout_alert_dialog_avaliacao);
                            final RatingBar reAvalia = (RatingBar) findViewById(R.id.reAvalia);

                            secondBuilder.setNeutralButton("Ok2", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    arrayAdapter.getItem(position).setAvaliacao(reAvalia.getRating());
                                }
                            });

                            secondBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    regraDeNegocioSingleton.getListaDeItensSingleton().getListaDeItensCulturais().get(position).setAvaliacao(reAvalia.getRating());
                                }
                            });
                            secondBuilder.show();*/
                        }
                        Toast.makeText(TelaCadastrados.this, "Status de consumido alterado para: " + labelToast, Toast.LENGTH_SHORT).show();
                    }
                });

                firstBuilder.setNegativeButton("Remover Item", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        arrayAdapter.remove(arrayAdapter.getItem(position));
                    }
                });
                firstBuilder.show();
            }
        });
    }
}
