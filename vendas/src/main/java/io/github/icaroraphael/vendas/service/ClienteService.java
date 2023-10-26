package io.github.icaroraphael.vendas.service;

import io.github.icaroraphael.vendas.model.Cliente;
import io.github.icaroraphael.vendas.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public void salvarCliente(Cliente cliente){
        validarCliente(cliente);
        repository.persistir(cliente);
    }

    public void validarCliente(Cliente cliente){
        //aplica validações
    }
}
