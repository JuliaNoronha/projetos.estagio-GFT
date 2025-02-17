package br.com.julia.pedidos.api.entity;

import br.com.julia.pedidos.api.entity.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Pedido {
    private UUID id = UUID.randomUUID();
    private String cliente;
    private List<ItemPedido> itens = new ArrayList<>();
    private Double valorTotal;
    private String emailNotificacao;
    private  Status status = Status.EM_PROCESSAMENTO;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataHora = LocalDateTime.now();

    // Construtor padrão
    public Pedido() {
        this.id = UUID.randomUUID();
        this.itens = new ArrayList<>();
        this.status = Status.EM_PROCESSAMENTO;
        this.dataHora = LocalDateTime.now();
    }

    // Getters e Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getEmailNotificacao() {
        return emailNotificacao;
    }

    public void setEmailNotificacao(String emailNotificacao) {
        this.emailNotificacao = emailNotificacao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", cliente='" + cliente + '\'' +
                ", itens=" + itens +
                ", valorTotal=" + valorTotal +
                ", emailNotificacao='" + emailNotificacao + '\'' +
                ", status=" + status +
                ", dataHora=" + dataHora +
                '}';
    }
}
