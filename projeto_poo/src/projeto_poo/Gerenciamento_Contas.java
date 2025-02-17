package projeto_poo;

import java.util.ArrayList;
import java.util.List;

abstract class Conta {
    private String titular;
    private double saldo;

    public Conta(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor do depósito deve ser positivo.");
        }
        saldo += valor;
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor do saque deve ser positivo.");
        }
        if (valor > saldo) {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }
        saldo -= valor;
    }

    public abstract void atualizarSaldo();
}

class ContaCorrente extends Conta {
    private double limite;

    public ContaCorrente(String titular, double saldoInicial, double limite) {
        super(titular, saldoInicial);
        this.limite = limite;
    }

    public void sacar(double valor) {
        if (valor > getSaldo() + limite) {
            throw new IllegalArgumentException("Valor excede o limite disponível.");
        }
        super.sacar(valor);
    }

    public void atualizarSaldo() {
    }
}

class ContaPoupanca extends Conta {
    public ContaPoupanca(String titular, double saldoInicial) {
        super(titular, saldoInicial);
    }

    public void atualizarSaldo() {
        double novoSaldo = getSaldo() * 1.01; // Aumento de 1%
        depositar(novoSaldo - getSaldo());
    }
}

public class Gerenciamento_Contas {
    public static void main(String[] args) {
        List<Conta> contas = new ArrayList<>();

        // Criando contas
        contas.add(new ContaCorrente("João", 1000, 500));
        contas.add(new ContaPoupanca("Maria", 2000));

        // Realizando operações
        try {
            contas.get(0).depositar(500);
            contas.get(0).sacar(1200);
            contas.get(1).depositar(300);
            contas.get(1).atualizarSaldo();
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // Exibindo saldos atualizados
        for (Conta conta : contas) {
            System.out.println("Titular: " + conta.getTitular() + ", Saldo: R$ " + conta.getSaldo());
        }
    }
}