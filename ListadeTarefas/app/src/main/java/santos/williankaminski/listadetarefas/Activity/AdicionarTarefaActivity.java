package santos.williankaminski.listadetarefas.Activity;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import santos.williankaminski.listadetarefas.Model.Tarefa;
import santos.williankaminski.listadetarefas.R;
import santos.williankaminski.listadetarefas.helper.TarefaDAO;

public class AdicionarTarefaActivity extends AppCompatActivity {

    private TextInputEditText editTarefa;
    private TextInputEditText editPrioridade;
    private Tarefa tarefaAtual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_tarefa);

        editTarefa = findViewById(R.id.textTarefa);
        editPrioridade = findViewById(R.id.textPrioridade);

        //Recuperar tarefa, caso seja edição
        tarefaAtual = (Tarefa) getIntent().getSerializableExtra("tarefaSelecionada");

        //Configurar tarefa nas caixas de texto
        if(tarefaAtual != null){
            editTarefa.setText(tarefaAtual.getTarefa());
            editPrioridade.setText(tarefaAtual.getPrioridada());
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_adicionar_tarefa, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_salvar://Executa a ação para o item salvar

                TarefaDAO tarefaDAO = new TarefaDAO(getApplicationContext());
                String nome_tarefa = editTarefa.getText().toString();
                String prioridade = editPrioridade.getText().toString();

                if(tarefaAtual != null){//Alterar cadastro

                    Tarefa tarefa = new Tarefa();

                    if(!nome_tarefa.isEmpty()) {
                        tarefa.setTarefa(nome_tarefa);
                    }else{
                        throw new NumberFormatException("Informe o nome da tarefa");
                    }

                    if(!prioridade.isEmpty()){
                        tarefa.setPrioridada(prioridade);
                    }else{
                        throw new NumberFormatException("Informe a prioridade da tarefa");
                    }

                    tarefa.setId(tarefaAtual.getId());

                    //atualizar no banco de dados
                    if(tarefaDAO.atualizar(tarefa)){
                        finish();
                        Toast.makeText(getApplicationContext(),
                                "Cadastro atualizado com sucesso",
                                Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(getApplicationContext(),
                                "Erro ao salvar a atualização",
                                Toast.LENGTH_LONG).show();
                    }

                }else{// Novo cadastro

                    try{

                        Tarefa tarefa = new Tarefa();

                        if(!nome_tarefa.isEmpty()) {
                            tarefa.setTarefa(nome_tarefa);
                        }else{
                            throw new NumberFormatException("Informe o nome da tarefa");
                        }

                        if(!prioridade.isEmpty()){
                            tarefa.setPrioridada(prioridade);
                        }else{
                            throw new NumberFormatException("Informe a prioridade da tarefa");
                        }

                        tarefaDAO.salvar(tarefa);

                        if(nome_tarefa.length() > 4 && prioridade.length() > 4){
                            finish();
                        }else{
                            throw new NumberFormatException("Minimo de caracteres é 5");
                        }

                    }catch (Exception e){
                        Toast.makeText(getApplicationContext(),e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }

                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
