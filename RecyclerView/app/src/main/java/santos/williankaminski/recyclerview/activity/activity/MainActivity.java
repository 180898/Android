package santos.williankaminski.recyclerview.activity.activity;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import santos.williankaminski.recyclerview.R;
import santos.williankaminski.recyclerview.activity.RecyclerItemClickListener;
import santos.williankaminski.recyclerview.activity.adapter.Adapter;
import santos.williankaminski.recyclerview.activity.model.Filme;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Filme> listFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        //Listagem de Filmes
        this.criarFilmes();

        //Configurar Adapter
        Adapter adapter = new Adapter(listFilmes);


        //Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.HORIZONTAL));
        recyclerView.setAdapter(adapter);

        //Evento de Clique
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {

                                Filme filme = listFilmes.get(position);

                                Toast.makeText(
                                        getApplicationContext(),
                                        "Item pressionado: " + filme.getTitulo(),
                                        Toast.LENGTH_LONG
                                ).show();
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {

                                Filme filme = listFilmes.get(position);

                                Toast.makeText(
                                        getApplicationContext(),
                                        "Clique longo: " + filme.getTitulo(),
                                        Toast.LENGTH_LONG
                                ).show();
                            }

                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            }
                        }
                ));
    }

    public void criarFilmes(){

        Filme filme = new Filme("Título de Teste", "Gênero de Teste", "2019");
        this.listFilmes.add(filme);

        filme = new Filme("Título de Teste", "Gênero de Teste", "2019");
        this.listFilmes.add(filme);

        filme = new Filme("Título de Teste", "Gênero de Teste", "2019");
        this.listFilmes.add(filme);

        filme = new Filme("Título de Teste", "Gênero de Teste", "2019");
        this.listFilmes.add(filme);

        filme = new Filme("Título de Teste", "Gênero de Teste", "2019");
        this.listFilmes.add(filme);

        filme = new Filme("Título de Teste", "Gênero de Teste", "2019");
        this.listFilmes.add(filme);

        filme = new Filme("Título de Teste", "Gênero de Teste", "2019");
        this.listFilmes.add(filme);

        filme = new Filme("Título de Teste", "Gênero de Teste", "2019");
        this.listFilmes.add(filme);

    }
}
