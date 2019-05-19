package santos.williankaminski.cardview.model;

/***
 * Created by Willian Kaminski dos Santos
 */
public class Postagem {

    private String nome;
    private String postegem;
    private int imagem;

    public Postagem(String nome, String postegem, int imagem) {
        this.nome = nome;
        this.postegem = postegem;
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPostegem() {
        return postegem;
    }

    public void setPostegem(String postegem) {
        this.postegem = postegem;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }
}
