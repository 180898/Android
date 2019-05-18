package santos.williankaminski.componentesbasicos;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText campoProduto;
    private TextView resutado;
    private CheckBox checkBoxBranco, checkBoxVerde, checkBoxVermelho;
    private RadioGroup rgGroup;

    List<String> check = new ArrayList<String>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoProduto = findViewById(R.id.EditTextNomeProduto);
        resutado = findViewById(R.id.textViewResultado);
        checkBoxBranco = findViewById(R.id.checkBoxBranco);
        checkBoxVerde = findViewById(R.id.checkBoxVerde);
        checkBoxVermelho = findViewById(R.id.checkBoxVermelho);
        rgGroup = findViewById(R.id.rgGroup);
    }

    public void verificaCheckBox(){
        check.clear();

        if(checkBoxBranco.isChecked()){
            check.add(checkBoxBranco.getText().toString());
        }

        if(checkBoxVerde.isChecked()){
            check.add(checkBoxVerde.getText().toString());
        }

        if(checkBoxVermelho.isChecked()){
            check.add(checkBoxVermelho.getText().toString());
        }

        resutado.setText(check.toString());

    }

    public void verificaRadioButton(){
        rgGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.radioButtonSim){
                    resutado.setText("Sim");
                }else{
                    resutado.setText("Não");
                }
            }
        });
    }

    public void enviar(View v){
        String nomeProduto = campoProduto.getText().toString();
        resutado.setText(nomeProduto);

        verificaCheckBox();
        verificaRadioButton();
    }
}
