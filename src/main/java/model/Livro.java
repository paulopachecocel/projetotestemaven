package model;

/**
 *
 * @author Paulo_Note
 */
public class Livro extends ModeloAbstrato{
    private int issn;
    private String nome;
    private String resenha;
    private String editora;
    private String autor;

    //contrutor
    public Livro() {} //contrutor vazio para toda vez for instanciar a classe nao quer passar atributo e nem nada

    public Livro(int issn, String nome, String resenha, String editora, String autor) {  
        this.issn = issn;
        this.nome = nome;
        this.resenha = resenha;
        this.editora = editora;
        this.autor = autor;
    }
    
    //gets e sets
    public int getIssn() {
        return issn;
    }

    public void setIssn(int issn) {
        this.issn = issn;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getResenha() {
        return resenha;
    }

    public void setResenha(String resenha) {
        this.resenha = resenha;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
    
}
