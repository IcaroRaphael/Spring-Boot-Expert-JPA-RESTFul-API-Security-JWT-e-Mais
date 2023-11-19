package io.github.icaroraphael.vendas.rest.controller;

import io.github.icaroraphael.vendas.domain.entity.Pedido;
import io.github.icaroraphael.vendas.rest.dto.PedidoDTO;
import io.github.icaroraphael.vendas.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
    @Autowired
    private PedidoService service;

    @PostMapping
    @ResponseStatus(CREATED)
    public Integer save(@RequestBody PedidoDTO dto){
        Pedido pedido = service.salvar(dto);
        return pedido.getId();
    }
}
