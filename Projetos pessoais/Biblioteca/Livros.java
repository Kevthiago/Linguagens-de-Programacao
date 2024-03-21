package Biblioteca;
public class Livros {
    // Atributos
    private String titulo, autor, editora;
    private int quantidade;

    // Construtor
    public Livros(String titulo, String autor, String editora, int quantidade) {
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.quantidade = quantidade;
    }

    // Getters e setters
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditora() {
        return editora;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    // Outros métodos
    public String status() {
        return "Nome: " + titulo + "\nAutor: " + autor + "\nEditora: " + editora + "\nQuantidade: " + quantidade;
    }

    public void emprestimo() {
        if (quantidade >= 1) {
            quantidade--;
            System.out.println("Livro retirado do estoque. Estoque atual: " + quantidade);
        } else {
            System.out.println("Estoque insuficiente!");
        }
    }

    public void devolucao() {
        quantidade++;
        System.out.println("Livro adicionado ao estoque. Estoque atual: " + quantidade);
    }

    public void disponibilidade() {
        if (quantidade >= 1) {
            System.out.println("Livro disponível para leitura e empréstimo.");
        } else {
            System.out.println("Livro em falta no estoque.");
        }
    }
}