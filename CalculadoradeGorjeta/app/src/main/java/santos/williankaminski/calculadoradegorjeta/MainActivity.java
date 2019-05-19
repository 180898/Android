package santos.williankaminski.calculadoradegorjeta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText valor;
    private TextView textViewporcetagem;
    private SeekBar seekBar;
    private TextView valorGorjeta;
    private TextView valorFinal;

    private double porcentagem = 0; //porcentagem inicial

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        valor = findViewById(R.id.editTextValor);
        textViewporcetagem = findViewById(R.id.textViewPorcentagem);
        seekBar = findViewById(R.id.seekBar);
        valorGorjeta = findViewById(R.id.textViewValorGorjeta);
        valorFinal = findViewById(R.id.textViewValorTotal);

        //Controlar seekbar
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                porcentagem = seekBar.getProgress();
                textViewporcetagem.setText(porcentagem + "%");
                calcularGorjeta();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void calcularGorjeta(){
        //Recuperar o valor digitado
        Double valorDigitado = Double.parseDouble(valor.getText().toString());

        //Calcular a gorjeta total
        double gorjeta = valorDigitado * (porcentagem / 100);
        double total = gorjeta + valorDigitado;

        //Exibir a gorjeta total
        valorGorjeta.setText("R$ " + Math.round(gorjeta));
        valorFinal.setText("R$ " + total);
    }
}
