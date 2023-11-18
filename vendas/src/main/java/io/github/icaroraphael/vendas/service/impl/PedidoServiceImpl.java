package io.github.icaroraphael.vendas.service.impl;

import io.github.icaroraphael.vendas.domain.repository.PedidoRepository;
import io.github.icaroraphael.vendas.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements PedidoService {
    @Autowired
    private PedidoRepository repository;


}
