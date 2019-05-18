package santos.williankaminski.alcoolougasolina;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText precoalcool;
    private EditText precogasolina;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        precoalcool = findViewById(R.id.precoalcool);
        precogasolina = findViewById(R.id.precogasolina);
        resultado = findViewById(R.id.resultado);
    }

    public void calcularPreco(View v){

        String alcool = precoalcool.getText().toString();
        String gasolina  = precogasolina.getText().toString();

        Boolean camposvalidados = this.validarCampos(alcool, gasolina);

        if(camposvalidados){
            this.calcularMelhorPreco(alcool, gasolina);
        }else{
            resultado.setText("Preencha os preços primeiro!");
        }

    }

    public boolean validarCampos(String alcool, String gasolina){

        Boolean camposValidados = true;

        if(alcool.isEmpty() || alcool.equals("")){
            camposValidados = false;
        }else if(gasolina.isEmpty() || gasolina.equals("")){
            camposValidados = false;
        }

        return camposValidados;
    }

    public void calcularMelhorPreco(String alcool, String gasolina){

        float precoalcool = Float.parseFloat(alcool);
        float precogasolina = Float.parseFloat(gasolina);

        float calculo = precoalcool / precogasolina;

        if(calculo >= 0.7){
            resultado.setText("Melhor utilizar gasolina!");
        }else{
            resultado.setText("Melhor utilizar álcool!");
        }

    }
}
