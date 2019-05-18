package santos.williankaminski.pedrapapeletesoura;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

/**
 * @author Willian Kaminski dos Santos
 * @since 12-05/2019
 * @version 1.0
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionarPedra(View view){
        this.opcaoSeleconada(1);
    }

    public void selecionarPapel(View view){
        this.opcaoSeleconada(2);
    }

    public void selecionarTesoura(View view){
        this.opcaoSeleconada(3);
    }

    public void opcaoSeleconada(int escolhaUsuario){

        ImageView imageViewApp = findViewById(R.id.imageViewApp);
        TextView textViewMessage = findViewById(R.id.textViewMessage);

        //Gerar número aleatório para a escolha do app
        String[] opcoes = {"pedra", "papel", "tesoura"};

        int numero = new Random().nextInt(3);

        String escolhaApp = opcoes[numero];

        switch (escolhaApp){
            case "pedra":
                imageViewApp.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imageViewApp.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imageViewApp.setImageResource(R.drawable.tesoura);
        }

        if(
                (escolhaApp == "pedra" && escolhaUsuario == 3) ||
                (escolhaApp == "papel" && escolhaUsuario == 1) ||
                (escolhaApp == "tesoura" && escolhaUsuario == 2)

        ){//App ganhador

            textViewMessage.setText("Você perdeu :(");

        }else if(
                (escolhaUsuario == 1 && escolhaApp == "tesoura") ||
                (escolhaUsuario == 2 && escolhaApp == "pedra") ||
                (escolhaUsuario == 3 && escolhaApp == "papel")
        ){//Usuário ganhador

            textViewMessage.setText("Você ganhou :)");

        }else{// Empate

            textViewMessage.setText("Empatamos :0");

        }

    }
}
