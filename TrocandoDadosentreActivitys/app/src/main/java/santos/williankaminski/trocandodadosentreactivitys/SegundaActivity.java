package santos.williankaminski.trocandodadosentreactivitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {

    private TextView nome;
    private TextView idade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        nome = findViewById(R.id.textViewNome);
        idade = findViewById(R.id.textViewIdade);

        //Recuperar os dados enviados
        Bundle dados = getIntent().getExtras();
        String nome = dados.getString("nome");
        int idade = dados.getInt("idade");

        //Configurar valores recuperados
        this.nome.setText(nome);
        this.idade.setText(String.valueOf(idade));
    }
}
