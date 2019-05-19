package santos.williankaminski.caraoucoroa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button buttonPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonPlay = findViewById(R.id.buttonPlay);
    }

    public void caraOuCoroa(View v){
        Intent intent = new Intent(getApplicationContext(), RespostaActivity.class);

        //Passar dados para a próxima tela
        int numero = new Random().nextInt(2);
        intent.putExtra("numero", numero);

        startActivity(intent);
    }
}
