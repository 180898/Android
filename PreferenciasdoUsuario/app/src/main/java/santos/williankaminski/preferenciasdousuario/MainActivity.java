package santos.williankaminski.preferenciasdousuario;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editNome;
    private TextView textResultado;
    private Button buttonSalvar;
    private static final String ARQUIVO_PREFERENCIA = "ArquivoPreferencia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNome = findViewById(R.id.editNome);
        textResultado = findViewById(R.id.textResultado);
        buttonSalvar = findViewById(R.id.buttonSalvar);

        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Instancia que ira criar o arquivo de preferencias.
                SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
                SharedPreferences.Editor editor = preferences.edit();

                //Validar nome
                if(editNome.getText().toString().equals("") || editNome.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "Preencha o nome", Toast.LENGTH_LONG).show();
                }else{

                    //Salvar os dados no arquivo
                    String nome = editNome.getText().toString();
                    editor.putString("nome", nome);
                    editor.commit();
                    textResultado.setText("Olá, " + nome);
                }

            }
        });

        //Recuperar os dados do arquivo
        SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);

        //Validar a existencia do 'nome' no arquivo de preferencias.
        if(preferences.contains("nome")){

            String nome = preferences.getString("nome", "Olá, usuário não definido");
            textResultado.setText("Olá, " + nome);

        }else{
            textResultado.setText("Olá, usuário não definido");
        }
    }
}
