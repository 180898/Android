package santos.williankaminski.frasesdodia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void alterarFrase(View view){

        TextView textViewFrase = findViewById(R.id.textViewFrase);

        String[] frases = {
                "É pra frente que se anda, é pra cima que se olha e é lutando que se conquista.",
                "As melhores coisas da vida são gratuitas: abraços, sorrisos, amigos, beijos, família, dormir, amor, risos e boas lembranças.",
                "Treine sua mente para ver o lado bom de qualquer situação.",
                "Creio de coração que tudo nesta vida se renova. Tudo recomeça, tudo renasce, tudo avança. Creio no bem e na força maior que nos move. Creio em dias de paz e que a felicidade acontece quando nos colocamos a favor de todo o bem, em tudo e para todos.",
                "Um dia você ainda vai olhar para trás e ver que os problemas eram, na verdade, os degraus que te levaram à vitória.",
                "Está proibido abandonar seus sonhos, não importa quantas vezes caia, levante-se.",
                "Energia positiva é o melhor presente que a gente pode receber.",
                "A força de dentro é maior que todos os ventos contrários.",
                "Que vire rotina acordar todos os dias com o coração leve.",
                "Toda vez que você pensar em desistir, respire fundo, ore baixinho, convide a esperança, abrace a fé e vai."
        };

        int random = new Random().nextInt(frases.length);

        textViewFrase.setText(frases[random]);

    }
}
