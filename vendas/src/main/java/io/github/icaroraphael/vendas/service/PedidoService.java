package io.github.icaroraphael.vendas.service;

import io.github.icaroraphael.vendas.domain.entity.Pedido;
import io.github.icaroraphael.vendas.rest.dto.PedidoDTO;

import java.util.Optional;

public interface PedidoService {
    Pedido salvar(PedidoDTO dto);
    Optional<Pedido> obterPedidoCompleto(Integer id);
}
