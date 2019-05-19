package santos.williankaminski.cardview.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import santos.williankaminski.cardview.R;
import santos.williankaminski.cardview.model.Postagem;

/**
 * Created by Willian Kaminski dos Santos
 */

public class PostagemAdapter extends RecyclerView.Adapter<PostagemAdapter.MyViewHolder> {

    private List<Postagem> postagens;

    public PostagemAdapter(List<Postagem> p) {
        this.postagens = p;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemLista = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.postagem_detalhe, viewGroup, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        Postagem p = postagens.get(i);

        myViewHolder.nome.setText(p.getNome());
        myViewHolder.postagem.setText(p.getPostegem());
        myViewHolder.imagem.setImageResource(p.getImagem());
    }

    @Override
    public int getItemCount() {
        return postagens.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView nome;
        private TextView postagem;
        private ImageView imagem;

        public MyViewHolder(View itemView){
            super(itemView);
            nome = itemView.findViewById(R.id.textViewNome);
            postagem = itemView.findViewById(R.id.textViewPostagem);
            imagem = itemView.findViewById(R.id.imageViewImagem);
        }
    }
}
