package santos.williankaminski.calculadoradegorjeta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText valor;
    private TextView porcetagem;
    private SeekBar seekBar;
    private TextView valorGorjeta;
    private TextView valorFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        valor = findViewById(R.id.editTextValor);
        porcetagem = findViewById(R.id.textViewPorcentagem);
        seekBar = findViewById(R.id.seekBar);
        valorGorjeta = findViewById(R.id.textViewGorjeta);
        valorFinal = findViewById(R.id.textViewValorTotal);

    }
}
