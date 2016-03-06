package com.example.breno.seenme;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;


/**
 * Esta é uma classe personalizada de ArrayAdapter, onde podemos encontrar um item deste array
 * e torná-lo invisivel ou não, de acordo com o parâmetro que quisermos.
 */
public class CustomAdapter extends ArrayAdapter<ItemCultural> {

    /**
     * Indica qual é a tela que estamos referenciando
     */
    public static final int VIEW_TYPE_MAINACTIVITY = 124; // qualquer número inteiro.
    public static final int VIEW_TYPE_TELACADAS = 125; // qualquer número inteiro.

    private int viewType;
    List<ItemCultural> lista;
    private final LayoutInflater mInflater;
    private int resource;

    /**
     * Construtor do nosso ArrayAdapter personalizado
     *
     * @param context  contexto em que o adapter vai ser criado
     * @param resource o arquivo xml (aparência) de como cada item da lista vai ser mostrado
     * @param items    Lista de itens que o adapter vai conter
     * @param viewType VIEW_TYPE_MAINACTIVITY ou VIEW_TYPE_TELACADAS, de acordo com qual tela o CustomAdapter vai ser criado
     */
    public CustomAdapter(Context context, int resource, List<ItemCultural> items, int viewType) {
        super(context, resource, items);
        this.viewType = viewType;
        this.lista = items;
        mInflater = LayoutInflater.from(context);
        this.resource = resource;
    }

    /**
     * Deixa invisível ou visível de acordo com a propriedade de um item dentro do ArrayAdapter
     *
     * @param position    posição do item no vetor
     * @param convertView view a ser escondida/mostrada
     * @param parent ViewGroup a ser inflada
     * @return retorna a view já com o item visivel ou invisivel.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v;
        if (convertView == null) {
            v = mInflater.inflate(resource, parent, false);
        } else {
            v = convertView;
        }
        if (viewType == VIEW_TYPE_MAINACTIVITY) {
            if (lista.get(position).isConsumido()) {
                v.setVisibility(View.GONE);
            } else {
                v.setVisibility(View.VISIBLE);
                ((TextView) v).setText(lista.get(position).toString());
            }
        } else if (viewType == VIEW_TYPE_TELACADAS) {
            ((TextView) v).setText(lista.get(position).toString());
        } else {
            // Caso uma Tela de cadastro de séries fosse implementada, o código viria aqui.
        }
        return v;
    }
}
