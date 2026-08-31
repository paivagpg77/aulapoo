package biblioteca;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Biblioteca biblioteca = new Biblioteca(
                "Biblioteca Central",
                "Rua Principal, 100"
        );

       

        Livro livro1 = new Livro(
                "Harry Potter",
                "J.K. Rowling",
                "001",
                "12 anos"
        );

        Livro livro2 = new Livro(
                "O Hobbit",
                "J.R.R. Tolkien",
                "002",
                "10 anos"
        );

        Livro livro3 = new Livro(
                "Dom Casmurro",
                "Machado de Assis",
                "003",
                "14 anos"
        );

        biblioteca.adicionarLivro(livro1);
        biblioteca.adicionarLivro(livro2);
        biblioteca.adicionarLivro(livro3);

 

        int opcao;

        do {

            System.out.println("\n==============================");
            System.out.println("     SISTEMA DE BIBLIOTECA");
            System.out.println("==============================");
            System.out.println("1 - Cadastrar usuário");
            System.out.println("2 - Listar usuários");
            System.out.println("3 - Listar livros");
            System.out.println("4 - Locar livro");
            System.out.println("5 - Ver empréstimos");
            System.out.println("0 - Sair");
            System.out.println("==============================");

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:

                    System.out.println("\n=== CADASTRO DE USUÁRIO ===");

                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();

                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();

                    System.out.print("Endereço: ");
                    String endereco = scanner.nextLine();

                    System.out.print("Idade: ");
                    int idade = scanner.nextInt();

                    System.out.print("Código do usuário: ");
                    int codigoUsuario = scanner.nextInt();
                    scanner.nextLine();

                    Usuario usuario = new Usuario(
                            nome,
                            cpf,
                            email,
                            telefone,
                            endereco,
                            idade,
                            codigoUsuario
                    );

                    biblioteca.adicionarUsuario(usuario);

                    System.out.println("\nUsuário cadastrado com sucesso!");

                    break;

                case 2:

                    System.out.println("\n=== USUÁRIOS CADASTRADOS ===");

                    biblioteca.listarUsuarios();

                    break;

                case 3:

                    System.out.println("\n=== LIVROS DISPONÍVEIS ===");

                    biblioteca.listarLivros();

                    break;

                case 4:

                    System.out.println("\n=== LOCAÇÃO DE LIVRO ===");

                    if (biblioteca.getUsuarios().isEmpty()) {
                        System.out.println("Nenhum usuário cadastrado.");
                        break;
                    }

                    System.out.print("Digite o código do usuário: ");
                    int codigo = scanner.nextInt();
                    scanner.nextLine();

                    Usuario usuarioEncontrado = null;

                    for (Usuario u : biblioteca.getUsuarios()) {

                        if (u.getCodigoUsuario() == codigo) {
                            usuarioEncontrado = u;
                            break;
                        }
                    }

                    if (usuarioEncontrado == null) {
                        System.out.println("Usuário não encontrado.");
                        break;
                    }

                    System.out.print("Digite o código do livro: ");
                    String codigoLivro = scanner.nextLine();

                    Livro livroEncontrado = null;

                    for (Livro l : biblioteca.getLivros()) {

                        if (l.getCodigo().equals(codigoLivro)) {
                            livroEncontrado = l;
                            break;
                        }
                    }

                    if (livroEncontrado == null) {
                        System.out.println("Livro não encontrado.");
                        break;
                    }

                    biblioteca.realizarEmprestimo(
                            usuarioEncontrado,
                            livroEncontrado
                    );

                    usuarioEncontrado.getLivrosLocados().add(livroEncontrado);

                    System.out.println("\nLivro locado com sucesso!");
                    System.out.println("Usuário: " +
                            usuarioEncontrado.getNome());
                    System.out.println("Livro: " +
                            livroEncontrado.getNome());

                    break;

                case 5:

                    System.out.println("\n=== EMPRÉSTIMOS ===");

                    for (Emprestimo e : biblioteca.getEmprestimos()) {

                        System.out.println("------------------------------");
                        System.out.println("Usuário: " +
                                e.getUsuario().getNome());

                        System.out.println("Livro: " +
                                e.getLivro().getNome());

                        System.out.println("Data do empréstimo: " +
                                e.getDataEmprestimo());

                        System.out.println("Devolvido: " +
                                (e.isDevolvido() ? "Sim" : "Não"));
                    }

                    break;

                case 0:

                    System.out.println("\nSistema encerrado.");

                    break;

                default:

                    System.out.println("\nOpção inválida.");

                    break;
            }

        } while (opcao != 0);

        scanner.close();
    }
}