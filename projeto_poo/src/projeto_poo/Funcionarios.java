package projeto_poo;
import java.util.Scanner;

		class Funcionario {
		    private String nome;
		    private double salario;

		    public Funcionario(String nome, double salario) {
		        this.nome = nome;
		        this.salario = salario;
		    }

		    public double calcularSalarioTotal() {
		        return salario;
		    }

		    public String getNome() {
		        return nome;
		    }
		}

		class Gerente extends Funcionario {
		    private double bonus;

		    public Gerente(String nome, double salario, double bonus) {
		        super(nome, salario);
		        this.bonus = bonus;
		    }

		    @Override
		    public double calcularSalarioTotal() {
		        return super.calcularSalarioTotal() + bonus;
		    }
		}

		public class Funcionarios {
		    public static void main(String[] args) {
		        Scanner scanner = new Scanner(System.in);

		        System.out.println("Digite o nome do funcionário:");
		        String nomeFuncionario = scanner.nextLine();
		        System.out.println("Digite o salário do funcionário:");
		        double salarioFuncionario = scanner.nextDouble();
		        scanner.nextLine();

		        Funcionario funcionario = new Funcionario(nomeFuncionario, salarioFuncionario);

		        System.out.println("Digite o nome do gerente:");
		        String nomeGerente = scanner.nextLine();
		        System.out.println("Digite o salário do gerente:");
		        double salarioGerente = scanner.nextDouble();
		        System.out.println("Digite o bônus do gerente:");
		        double bonusGerente = scanner.nextDouble();

		        Gerente gerente = new Gerente(nomeGerente, salarioGerente, bonusGerente);

		        System.out.printf("Salário total do funcionário %s: R$%.2f%n", funcionario.getNome(), funcionario.calcularSalarioTotal());
		        System.out.printf("Salário total do gerente %s: R$%.2f%n", gerente.getNome(), gerente.calcularSalarioTotal());

		        scanner.close();
		    }
}