package santos.williankaminski.listadetarefas.Model;

import java.io.Serializable;
import java.util.Date;

public class Tarefa implements Serializable {

    private long id;
    private String url_img;
    private String prioridada;
    private String tarefa;
    private String data_alteracao;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrl_img() {
        return url_img;
    }

    public void setUrl_img(String url_img) {
        this.url_img = url_img;
    }

    public String getPrioridada() {
        return prioridada;
    }

    public void setPrioridada(String prioridada) {
        this.prioridada = prioridada;
    }

    public String getTarefa() {
        return tarefa;
    }

    public void setTarefa(String tarefa) {
        this.tarefa = tarefa;
    }

    public String getData_alteracao() {
        return data_alteracao;
    }

    public void setData_alteracao(String data_alteracao) {
        this.data_alteracao = data_alteracao;
    }
}
