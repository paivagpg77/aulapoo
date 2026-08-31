package biblioteca;

public class Livro {

    private String nome;
    private String autor;
    private String codigo;
    private String faixaEtaria;

    public Livro(String nome, String autor, String codigo, String faixaEtaria) {
        this.nome = nome;
        this.autor = autor;
        this.codigo = codigo;
        this.faixaEtaria = faixaEtaria;
    }

    public String getNome() {
        return nome;
    }

    public String getAutor() {
        return autor;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getFaixaEtaria() {
        return faixaEtaria;
    }
}