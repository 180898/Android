package santos.williankaminski.componentesdeinterface;

import android.os.TestLooperManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private Switch sw;
    private ToggleButton tb;
    private CheckBox ch;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sw = findViewById(R.id.switchEstado);
        tb = findViewById(R.id.toggleButtonEstado);
        ch = findViewById(R.id.checkBoxEstado);
        resultado = findViewById(R.id.resultado);
    }

    public void enviar(View v){
        if(tb.isChecked()){
            resultado.setText("Toggle Ligado");
        }else{
            resultado.setText("Toggle Desligado");
        }
    }
}
