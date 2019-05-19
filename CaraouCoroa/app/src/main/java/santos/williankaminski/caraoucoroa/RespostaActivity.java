package santos.williankaminski.caraoucoroa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class RespostaActivity extends AppCompatActivity {

    private ImageView imageViewMoeda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resposta);

        imageViewMoeda = findViewById(R.id.imageViewMoeda);

        //Recuperar dados
        Bundle dados = getIntent().getExtras();
        int numero = dados.getInt("numero");

        if(numero == 0){
            imageViewMoeda.setImageResource(R.drawable.moeda_cara);
        }else{
            imageViewMoeda.setImageResource(R.drawable.moeda_coroa);
        }
    }

    //Finalizar a Activity
    public void voltar(View v){
        finish();
    }
}
