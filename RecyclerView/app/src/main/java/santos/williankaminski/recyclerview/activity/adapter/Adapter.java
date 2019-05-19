package santos.williankaminski.recyclerview.activity.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import santos.williankaminski.recyclerview.R;
import santos.williankaminski.recyclerview.activity.model.Filme;

/***
 * Created by Willian Kaminski dos Santos
 */
public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Filme> listaFilmes;

    public Adapter(List<Filme> list) {
        this.listaFilmes = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemLista = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.adapter_list_movie, viewGroup, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        Filme filme = listaFilmes.get(i);

        myViewHolder.icone.setImageResource(R.drawable.ic_movie_green);
        myViewHolder.titulo.setText(filme.getTitulo());
        myViewHolder.genero.setText(filme.getGenero());
        myViewHolder.ano.setText(filme.getAno());

    }

    @Override
    public int getItemCount() {
        return listaFilmes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView icone;
        TextView titulo;
        TextView ano;
        TextView genero;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            icone = itemView.findViewById(R.id.imageViewIcon);
            titulo = itemView.findViewById(R.id.textViewTitulo);
            ano = itemView.findViewById(R.id.textViewAno);
            genero = itemView.findViewById(R.id.textViewGenero);
        }
    }
}
