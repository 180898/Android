package santos.williankaminski.menus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.item_salvar:
                Toast.makeText(getApplicationContext(), "Salvar", Toast.LENGTH_LONG).show();
                break;
            case R.id.item_editar:
                Toast.makeText(getApplicationContext(), "Editar", Toast.LENGTH_LONG).show();
                break;
            case R.id.item_configurar:
                Toast.makeText(getApplicationContext(), "Configurar", Toast.LENGTH_LONG).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
