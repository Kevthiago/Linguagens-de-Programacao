package Biblioteca;
import java.util.Scanner;
public class Biblioteca {
    public static void main(String[] args) {
        // Instanciação
        Scanner scanner = new Scanner(System.in);
        int opcao;
        Livros[] livros = new Livros[12];
        livros[0] = new Livros("O Príncipe", "Nicolau Maquiavel", "-desconhecido(a)-", 5);
        livros[1] = new Livros("Apologia de Sócrates", "Platão", "-desconhecido(a)-", 10);
        livros[2] = new Livros("A Arte da Guerra", "Sun Tzu", "-desconhecido(a)-", 3);
        livros[3] = new Livros("Dom Quixote", "Miguel de Cervantes", "-desconhecido(a)-", 8);
        livros[4] = new Livros("1984", "George Orwell", "-desconhecido(a)-", 4);
        livros[5] = new Livros("O Senhor dos Anéis", "J.R.R. Tolkien", "-desconhecido(a)-", 6);
        livros[6] = new Livros("Crime e Castigo", "Fiódor Dostoiévski", "-desconhecido(a)-", 1);
        livros[7] = new Livros("Cem Anos de Solidão", "Gabriel García Márquez", "-desconhecido(a)-", -1);
        livros[8] = new Livros("Orgulho e Preconceito", "Jane Austen", "-desconhecido(a)-", 0);
        livros[9] = new Livros("O Pequeno Príncipe", "Antoine de Saint-Exupéry", "-desconhecido(a)-", -2);
        livros[10] = new Livros("Moby Dick", "Herman Melville", "-desconhecido(a)-", 4);
        livros[11] = new Livros("A Metamorfose", "Franz Kafka", "-desconhecido(a)-", 0);

        // Scanner
        System.out.println("\n-----------------------------------------");
        System.out.println("Bem vindo(a) à Biblioteca de Alexandria!");
        System.out.println("-----------------------------------------");

        do {
            System.out.println("Escolha um livro (ou digite " + (livros.length + 1) + " para sair):");
            for (int i = 0; i < livros.length; i++) {
                System.out.println((i + 1) + "-" + livros[i].getTitulo());
            }
            System.out.println((livros.length + 1) + "-Sair");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    gerenciarLivro(livros[0], scanner);
                    break;
                case 2:
                    gerenciarLivro(livros[1], scanner);
                    break;
                case 3:
                    gerenciarLivro(livros[2], scanner);
                    break;
                case 4:
                    gerenciarLivro(livros[3], scanner);
                    break;
                case 5:
                    gerenciarLivro(livros[4], scanner);
                    break;
                case 6:
                    gerenciarLivro(livros[5], scanner);
                    break;
                case 7:
                    gerenciarLivro(livros[6], scanner);
                    break;
                case 8:
                    gerenciarLivro(livros[7], scanner);
                    break;
                case 9:
                    gerenciarLivro(livros[8], scanner);
                    break;
                case 10:
                    gerenciarLivro(livros[9], scanner);
                    break;
                case 11:
                    gerenciarLivro(livros[10], scanner);
                    break;
                case 12:
                    gerenciarLivro(livros[11], scanner);
                    break;
                case 13:
                    break;
                default:
                    System.out.println("Comando inválido!");
            }
        } while (opcao != 3);
    }

    private static void gerenciarLivro(Livros livro, Scanner scanner) {
        int opcao;
        do {
            System.out.println("\nO que deseja fazer?\n1-Verificar informações\n2-Empréstimo\n3-Devolução\n4-Encerrar");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println(livro.status());
                    break;
                case 2:
                    livro.emprestimo();
                    break;
                case 3:
                    livro.devolucao();
                    break;
                case 4:
                    System.out.println("Encerrando o gerenciamento deste livro...");
                    break;
                default:
                    System.out.println("Comando inválido!");
            }
        } while (opcao != 4);
    }
}
