package santos.williankaminski.alertdialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void alert(View v){

        //Criar AlertDialog
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Alert Dialog");
        dialog.setMessage("Mensagem");

        //Configurar o cancelamento
        dialog.setCancelable(false);

        //Configurar icone
        dialog.setIcon(android.R.drawable.ic_menu_delete);

        //Configurar a interação
        dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),
                        "Sim foi pressionado",
                        Toast.LENGTH_LONG).show();
            }
        });

        dialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),
                        "Não foi pressionado",
                        Toast.LENGTH_LONG).show();
            }
        });

        //Criar e exibir o AlertDialog
        dialog.create().show();
    }
}
