package santos.williankaminski.listadetarefas.helper;

import java.util.List;

import santos.williankaminski.listadetarefas.Model.Tarefa;

public interface ITarefaDAO {

    public boolean salvar(Tarefa tarefa);
    public boolean atualizar(Tarefa tarefaa);
    public boolean deletar(Tarefa tarefa);
    public List<Tarefa> listar();
}
