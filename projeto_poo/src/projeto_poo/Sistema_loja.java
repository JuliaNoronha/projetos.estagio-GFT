package projeto_poo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema_loja {

    static class Produto {
        private int codigo;
        private String nome;
        private double preco;

        public Produto(int codigo, String nome, double preco) {
            if (preco < 0) {
                throw new IllegalArgumentException("Preço nao pode ser negativo.");
            }
            this.codigo = codigo;
            this.nome = nome;
            this.preco = preco;
        }

        public int getCodigo() {
            return codigo;
        }

        public String getNome() {
            return nome;
        }

        public double getPreco() {
            return preco;
        }
    }

    static class Carrinho {
        private List<Produto> produtos;

        public Carrinho() {
            produtos = new ArrayList<>();
        }

        public void adicionarProduto(Produto produto) {
            if (produto == null) {
                throw new IllegalArgumentException("Produto nao pode ser nulo.");
            }
            produtos.add(produto);
        }

        public void exibirCarrinho() {
            if (produtos.isEmpty()) {
                System.out.println("Carrinho vazio.");
                return;
            }

            System.out.println("Produtos no carrinho:");
            double total = 0;
            for (int i = 0; i < produtos.size(); i++) {
                Produto p = produtos.get(i);
                System.out.println((i + 1) + ". " + p.getNome() + " - R$ " + String.format("%.2f", p.getPreco()));
                total += p.getPreco();
            }
            System.out.println("Total: R$ " + String.format("%.2f", total));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Carrinho carrinho = new Carrinho();

        while (true) {
            try {
                System.out.print("Digite o código do produto (ou 0 para sair): ");
                int codigo = scanner.nextInt();
                if (codigo == 0) {
                    break;
                }

                scanner.nextLine(); // Limpar o buffer do scanner
                System.out.print("Digite o nome do produto: ");
                String nome = scanner.nextLine();
                System.out.print("Digite o preço do produto: ");
                double preco = scanner.nextDouble();

                Produto produto = new Produto(codigo, nome, preco);
                carrinho.adicionarProduto(produto);
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
                scanner.nextLine(); // Limpar buffer
            }
        }

        carrinho.exibirCarrinho();
        scanner.close();
    }
}