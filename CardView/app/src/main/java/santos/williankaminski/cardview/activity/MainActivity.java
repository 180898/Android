package santos.williankaminski.cardview.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import santos.williankaminski.cardview.R;
import santos.williankaminski.cardview.adapter.PostagemAdapter;
import santos.williankaminski.cardview.model.Postagem;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerPostagem;
    private List<Postagem> postagens = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerPostagem = findViewById(R.id.recyclerView);

        //Define o Layout
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //layoutManager.setOrientation(LinearLayout.HORIZONTAL); // --> Exiir a listagem de forma horizontal.

        //RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 2); // --> Exibir as postagens em modo Grid.
        recyclerPostagem.setLayoutManager(layoutManager);

        //Define o Adapter
        this.prepararPostagens();
        PostagemAdapter adapter = new PostagemAdapter(postagens);
        recyclerPostagem.setAdapter(adapter);
    }

    public void prepararPostagens(){
        Postagem p = new Postagem("Willian Kaminski dos Santos","#tbt Viagem Legal!", R.drawable.imagem1);
        this.postagens.add(p);

        p = new Postagem("Willian Kaminski dos Santos","#tbt Viagem Legal!", R.drawable.imagem2);
        this.postagens.add(p);

        p = new Postagem("Willian Kaminski dos Santos","#tbt Viagem Legal!", R.drawable.imagem3);
        this.postagens.add(p);

        p = new Postagem("Willian Kaminski dos Santos","#tbt Viagem Legal!", R.drawable.imagem4);
        this.postagens.add(p);
    }
}
