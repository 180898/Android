package santos.williankaminski.firebaseapp;

/**
 * Created by Willian Kaminski
 */
public class Usuario {

    private String nome;
    private String sobrenome;
    private int idades;

    public Usuario() {

    }

    public Usuario(String nome, String sobrenome, int idades) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idades = idades;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public int getIdades() {
        return idades;
    }

    public void setIdades(int idades) {
        this.idades = idades;
    }
}
