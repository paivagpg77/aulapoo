package biblioteca;

import java.util.ArrayList;

public class Usuario {

    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String endereco;
    private int idade;
    private int codigoUsuario;
    private ArrayList<Livro> livrosLocados;

    public Usuario(String nome, String cpf, String email, String telefone,
                   String endereco, int idade, int codigoUsuario) {

        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.idade = idade;
        this.codigoUsuario = codigoUsuario;
        this.livrosLocados = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public int getIdade() {
        return idade;
    }

    public int getCodigoUsuario() {
        return codigoUsuario;
    }

    public ArrayList<Livro> getLivrosLocados() {
        return livrosLocados;
    }
}