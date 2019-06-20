package santos.williankaminski.listadetarefas.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import santos.williankaminski.listadetarefas.Model.Tarefa;

public class TarefaDAO implements ITarefaDAO{

    private SQLiteDatabase escreve;
    private SQLiteDatabase le;

    public TarefaDAO(Context context) {
        DBHelper db = new DBHelper(context);
        escreve = db.getReadableDatabase();
        le = db.getReadableDatabase();
    }

    @Override
    public boolean salvar(Tarefa tarefa) {

        ContentValues cv = new ContentValues();
        cv.put("nome", tarefa.getTarefa());
        cv.put("prioridade",tarefa.getPrioridada());

        try{
            escreve.insert(DBHelper.TABELA_TAREFAS, null, cv);
            Log.e("INFO>>>>>>>>>>>>>>>", "Sucesso ao salvar a tarefa");
        }catch (Exception e){
            Log.e("INFO>>>>>>>>>>>>>>>", "Erro ao salvar a tarefa" + e.getMessage());
            return false;
        }

        return true;
    }

    @Override
    public boolean atualizar(Tarefa tarefaa) {
        return false;
    }

    @Override
    public boolean deletar(Tarefa tarefa) {
        return false;
    }

    @Override
    public List<Tarefa> listar() {

        List<Tarefa> tarefas = new ArrayList<>();
        String sql = "SELECT * FROM " + DBHelper.TABELA_TAREFAS + ";";
        Cursor cursor = le.rawQuery(sql, null);

        while (cursor.moveToNext()){

            Tarefa t = new Tarefa();

            long id = cursor.getLong(cursor.getColumnIndex("id"));
            String nome_tarefa = cursor.getString(cursor.getColumnIndex("nome"));
            String prioridade = cursor.getString(cursor.getColumnIndex("prioridade"));
            String data_alteracao = cursor.getString(cursor.getColumnIndex("data_cadastro"));

            t.setId(id);
            t.setTarefa(nome_tarefa);
            t.setPrioridada(prioridade);
            t.setData_alteracao(data_alteracao);

            tarefas.add(t);
        }

        return  tarefas;
    }
}
