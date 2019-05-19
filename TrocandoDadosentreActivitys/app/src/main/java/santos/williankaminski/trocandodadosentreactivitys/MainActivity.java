package santos.williankaminski.trocandodadosentreactivitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button buttonEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonEnviar = findViewById(R.id.buttonEnviar);

        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), SegundaActivity.class);

                Usuario usuario = new Usuario("Willian Kaminski","email@email.com.br");

                //Passando dados
                intent.putExtra("nome", "Willian");
                intent.putExtra("idade", 18);

                //Passando o Objeto Usuário
                intent.putExtra("objeto", usuario);

                startActivity(intent);
            }
        });

    }
}
