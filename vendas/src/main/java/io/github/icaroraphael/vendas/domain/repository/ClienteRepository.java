package io.github.icaroraphael.vendas.domain.repository;

import io.github.icaroraphael.vendas.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    // select c from Cliente c where c.nome like :nome
    List<Cliente> findByNomeContainingIgnoreCase(String nome);

    List<Cliente> findByNomeOrIdOrderById(String nome, Integer id);

    boolean existsByNome(String nome);
}
