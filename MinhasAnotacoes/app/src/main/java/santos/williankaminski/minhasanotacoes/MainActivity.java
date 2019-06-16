package santos.williankaminski.minhasanotacoes;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Preferences preferences;
    private EditText editAnotacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editAnotacao = findViewById(R.id.editAnotacao);
        preferences = new Preferences(getApplicationContext());

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Validar seo foi digitado algo
                String textoAnotacao = editAnotacao.getText().toString();
                if(textoAnotacao.equals("") || textoAnotacao.isEmpty()){
                    Snackbar.make(view, "Preencha a anotação!", Snackbar.LENGTH_LONG).show();
                }else{

                    preferences.savePreference(textoAnotacao);
                    Snackbar.make(view, "Anotação salva com sucesso!", Snackbar.LENGTH_LONG).show();
                }
            }
        });

        //Recuparar a anotação
        String anotacao = preferences.readPreference();

        if(!anotacao.equals("") || !anotacao.isEmpty()){
            editAnotacao.setText(anotacao);
        }
    }
}
