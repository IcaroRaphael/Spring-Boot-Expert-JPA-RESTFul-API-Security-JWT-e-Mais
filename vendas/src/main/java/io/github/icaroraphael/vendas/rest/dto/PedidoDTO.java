package io.github.icaroraphael.vendas.rest.dto;

import io.github.icaroraphael.vendas.validation.NotEmptyList;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {
    @NotNull(message = "Informe o código do cliente.")
    private Integer cliente;
    @NotNull(message = "Campo total do pedido é obrigatório.")
    private BigDecimal total;
    @NotEmptyList(message = "Pedido não pode ser realizado sem itens.")
    private List<ItemPedidoDTO> itens;
}
