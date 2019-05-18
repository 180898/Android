package santos.williankaminski.primeiroprojeto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void randomNumber(View view){

        int number = new Random().nextInt(10);
        TextView textViewResultado = findViewById(R.id.textViewResultado);
        textViewResultado.setText("Número escolhido: " + number);

        System.out.println(number);
    }
}
