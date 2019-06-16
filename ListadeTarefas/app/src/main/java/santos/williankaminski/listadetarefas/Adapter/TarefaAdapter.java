package santos.williankaminski.listadetarefas.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import santos.williankaminski.listadetarefas.Model.Tarefa;
import santos.williankaminski.listadetarefas.R;

public class TarefaAdapter extends RecyclerView.Adapter<TarefaAdapter.MyViewHolder> {

    private List<Tarefa> listaTarefas;

    public TarefaAdapter(List<Tarefa> lista){
        this.listaTarefas = lista;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemList = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.lista_tarefa_adapter, viewGroup, false);

        return new MyViewHolder(itemList);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        Tarefa tarefa =listaTarefas.get(i);

        myViewHolder.icone_tarefa.setImageResource(R.drawable.ic_insert_drive_file);
        myViewHolder.tarefa_tarefa.setText(tarefa.getTarefa());
        myViewHolder.prioridade_tarefa.setText(tarefa.getPrioridada());
        myViewHolder.dataAltaracao_tarefa.setText(tarefa.getData_alteracao());

    }

    @Override
    public int getItemCount() {
        return this.listaTarefas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView icone_tarefa;
        TextView tarefa_tarefa;
        TextView prioridade_tarefa;
        TextView dataAltaracao_tarefa;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            icone_tarefa = itemView.findViewById(R.id.imageViewTarefa);
            tarefa_tarefa = itemView.findViewById(R.id.textViewTarefa);
            prioridade_tarefa = itemView.findViewById(R.id.textViewPrioridade);
            dataAltaracao_tarefa = itemView.findViewById(R.id.textViewData);
        }
    }
}
