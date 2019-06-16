package santos.williankaminski.bancodadadossqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String sql;

        try {

            //Criar a base de dados
            SQLiteDatabase database = openOrCreateDatabase("app", MODE_PRIVATE, null);

            //Excluir a tabela da base da dados
            database.execSQL("DROP TABLE pessoas");

            //Criar a tabela
            database.execSQL("CREATE TABLE IF NOT EXISTS pessoas (id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR, idade INT(3))");

            //Inserir dados
            database.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Willian', 18)");
            database.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('João', 20)");
            database.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Maria', 24)");
            database.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Pedro', 26)");

            //Listar dados
            sql = "SELECT * FROM pessoas";

            //Listagem com filtros
            sql = "SELECT * FROM pessoas WHERE 1 = 1 ORDER BY nome";

            //Atualizar os dados
            database.execSQL("UPDATE pessoas SET idade = 19 WHERE id = 1");

            //Deletar os dados
            database.execSQL("DELETE FROM pessoas WHERE id = 4");

            //Recuperar os dados
            Cursor cursor = database.rawQuery(sql, null);

            //Indices da tabela
            int indiceId = cursor.getColumnIndex("id");
            int indiceNome = cursor.getColumnIndex("nome");
            int indiceIdade = cursor.getColumnIndex("idade");

            cursor.moveToFirst();

            while (cursor != null){
                Log.i("RESULTADO - ida >>", cursor.getString(indiceId) +" >> "+ cursor.getString(indiceNome) +" >> "+ cursor.getString(indiceIdade));
                cursor.moveToNext();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
