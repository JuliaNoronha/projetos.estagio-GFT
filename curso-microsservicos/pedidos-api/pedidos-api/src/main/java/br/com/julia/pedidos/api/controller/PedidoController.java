package br.com.julia.pedidos.api.controller;

import br.com.julia.pedidos.api.entity.PedidoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import br.com.julia.pedidos.api.entity.Pedido;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Tag(name = "Pedidos", description = "Recurso para criar um novo pedido")
@RestController
@RequestMapping("/api/v1/pedidos")
public class PedidoController {
    private final Logger logger = LoggerFactory.getLogger(PedidoController.class);

    @Operation(summary = "Cria um novo pedido", description = "Contém as operações para criar um novo pedido",
        responses = @ApiResponse(responseCode = "201", description = "Recurso criado com sucesso",
        content = @Content(mediaType ="application/json", schema = @Schema(implementation = Pedido.class)))
    )
    @PostMapping
    public ResponseEntity<PedidoResponse> criarPedido(@RequestBody Pedido pedido){
        logger.info("Pedido recebido:{}", pedido.toString());
        PedidoResponse response = new PedidoResponse(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
