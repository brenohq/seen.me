package com.example.breno.seenme;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

public class TelaCadastrados extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastrados);

        SearchView searchView = (SearchView) findViewById(R.id.pesquisaItem);
        ListView listView = (ListView) findViewById(R.id.listaDeItensCadastrados);
        listView.setClickable(true);
        final RegraDeNegocioSingleton regraDeNegocioSingleton = RegraDeNegocioSingleton.getInstance();

        final CustomAdapter arrayAdapter = new CustomAdapter(this, android.R.layout.simple_list_item_1, regraDeNegocioSingleton.getListaDeItensSingleton().getListaDeItensCulturais(), CustomAdapter.VIEW_TYPE_TELACADAS);

        arrayAdapter.notifyDataSetChanged();
        listView.setAdapter(arrayAdapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                for (int i = 0; i < regraDeNegocioSingleton.getListaDeItensSingleton().getListaDeItensCulturais().size(); i++) {
                    if (regraDeNegocioSingleton.getListaDeItensSingleton().getListaDeItensCulturais().get(i).getNome().equals(query)) {
                        criaDialog(i, arrayAdapter, regraDeNegocioSingleton);
                    }
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick(AdapterView<?> parent, final View view, final int position,
                                                                    long id) {
                                                criaDialog(position, arrayAdapter, regraDeNegocioSingleton);
                                            }
                                        }
        );
    }

    @Override
    public void onBackPressed() {
        Intent retornaMainActivity = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(retornaMainActivity);
    }

    public void criaDialog(final int position, final CustomAdapter arrayAdapter, final RegraDeNegocioSingleton regraDeNegocioSingleton) {
        String[] consumido = new String[1];

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
                }
                Toast.makeText(TelaCadastrados.this, "Status de consumido alterado para: " + labelToast, Toast.LENGTH_SHORT).show();
            }
        });

        firstBuilder.setNegativeButton("Remover Item", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                arrayAdapter.remove(arrayAdapter.getItem(position));
                arrayAdapter.notifyDataSetChanged();
            }
        });
        firstBuilder.show();
    }
}