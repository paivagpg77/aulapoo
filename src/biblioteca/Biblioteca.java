package biblioteca;

import java.util.ArrayList;

public class Biblioteca {

    private String nome;
    private String endereco;

    private ArrayList<Livro> livros;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Emprestimo> emprestimos;

    public Biblioteca(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.livros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public ArrayList<Livro> getLivros() {
        return livros;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public ArrayList<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void realizarEmprestimo(Usuario usuario, Livro livro) {

        Emprestimo emprestimo = new Emprestimo(usuario, livro);

        emprestimos.add(emprestimo);
    }

    public void listarLivros() {

        for (Livro livro : livros) {
            System.out.println(livro.getNome());
        }
    }

    public void listarUsuarios() {

        for (Usuario usuario : usuarios) {
            System.out.println(usuario.getNome());
        }
    }
}