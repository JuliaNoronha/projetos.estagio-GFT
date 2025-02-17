package projeto_poo;
import java.util.ArrayList;
import java.util.Scanner;

class Livro {
    private String titulo;
    private String autor;
    private double preco;

    public Livro(String titulo, String autor, double preco) {
        this.titulo = titulo;
        this.autor = autor;
        setPreco(preco);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco < 0) {
            System.out.println("Erro: O preço não pode ser negativo. Definindo como 0.");
            this.preco = 0;
        } else {
            this.preco = preco;
        }
    }

    public void exibirInformacoes() {
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Preço: R$ " + preco);
    }
}

public class Biblioteca {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Livro> livros = new ArrayList<>();

        System.out.println("Quantos livros deseja cadastrar?");
        int quantidade = scanner.nextInt();
        scanner.nextLine(); // Consumir o "\n" após o número

        for (int i = 0; i < quantidade; i++) {
            System.out.println("\nCadastro do Livro " + (i + 1) + ":");
            System.out.print("Digite o título: ");
            String titulo = scanner.nextLine();

            System.out.print("Digite o autor: ");
            String autor = scanner.nextLine();

            System.out.print("Digite o preço: ");
            double preco = scanner.nextDouble();
            scanner.nextLine();

            Livro livro = new Livro(titulo, autor, preco);
            livros.add(livro);
        }

        System.out.println("\nInformaçoes dos Livros Cadastrados:");
        for (int i = 0; i < livros.size(); i++) {
            System.out.println("\nLivro " + (i + 1) + ":");
            livros.get(i).exibirInformacoes();
        }

        scanner.close();
    }
}
