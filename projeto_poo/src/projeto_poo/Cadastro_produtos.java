package projeto_poo;

import java.util.Scanner;

public class Cadastro_produtos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Produto[] produtos = new Produto[3];

        for (int i = 0; i < 3; i++) {
            System.out.println("Digite o código, nome e preço do produto " + (i + 1) + ":");
            int codigo = scanner.nextInt();
            String nome = scanner.next();
            double preco = scanner.nextDouble();
            produtos[i] = new Produto(codigo, nome, preco);
        }

        System.out.println("\nInformaçoes dos Produtos:");
        for (int i = 0; i < 3; i++) {
            System.out.println("\nProduto " + (i + 1) + ":");
            produtos[i].exibirInformacoes();
        }

        scanner.close();
    }
}

class Produto {
    int codigo;
    String nome;
    double preco;

    public Produto(int codigo, String nome, double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
    }

    public void exibirInformacoes() {
        System.out.println("Código: " + codigo);
        System.out.println("Nome: " + nome);
        System.out.println("Preço: " + preco);
    }
}
