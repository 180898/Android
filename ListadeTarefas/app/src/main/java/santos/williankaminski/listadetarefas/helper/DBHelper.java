package santos.williankaminski.listadetarefas.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {

    public static int VERSION = 1;
    public static String NOME_DB = "DB_TAREFAS";
    public static String TABELA_TAREFAS = "tarefas";

    public DBHelper(Context context) {
        super(context, NOME_DB, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE IF NOT EXISTS " + TABELA_TAREFAS + "" +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " nome TEXT NOT NULL," +
                " prioridade TEXT NOT NULL," +
                " data_cadastro DATE);";

        try{
            db.execSQL(sql);
            Log.i("Info DB", "Sucesso ao criar a tabela");
        }catch (Exception e){
            Log.i("Info DB", "Erro ao criar a tabela " + e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
