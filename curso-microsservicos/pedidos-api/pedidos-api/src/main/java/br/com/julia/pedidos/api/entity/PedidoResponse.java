package br.com.julia.pedidos.api.entity;

import br.com.julia.pedidos.api.entity.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class PedidoResponse {
    private UUID id;
    private String cliente;
    private List<ItemPedido> itens;
    private Double valorTotal;
    private String emailNotificacao;
    private Status status;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataHora;

    public PedidoResponse(Pedido pedido) {
        this.id = pedido.getId();
        this.cliente = pedido.getCliente();
        this.itens = pedido.getItens();
        this.valorTotal = pedido.getValorTotal();
        this.emailNotificacao = pedido.getEmailNotificacao();
        this.status = pedido.getStatus();
        this.dataHora = pedido.getDataHora();
    }

    // Getters
    public UUID getId() {
        return id;
    }

    public String getCliente() {
        return cliente;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public String getEmailNotificacao() {
        return emailNotificacao;
    }

    public Status getStatus() {
        return status;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    @Override
    public String toString() {
        return "PedidoResponse{" +
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
