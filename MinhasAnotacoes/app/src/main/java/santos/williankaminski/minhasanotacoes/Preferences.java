package santos.williankaminski.minhasanotacoes;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Willian Kaminski
 */
public class Preferences {

    private Context context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private static final String ARQUIVO = "anotacao.preferencias";
    private static final String CHAVE_NOME = "nome";

    public Preferences(Context c) {
        this.context = c;
        sharedPreferences = context.getSharedPreferences(ARQUIVO, 0);
        editor = sharedPreferences.edit();
    }

    public void savePreference(String anotacao){
        editor.putString(CHAVE_NOME, anotacao);
        editor.commit();
    }

    public String readPreference(){
        return sharedPreferences.getString(CHAVE_NOME, "");
    }
}
