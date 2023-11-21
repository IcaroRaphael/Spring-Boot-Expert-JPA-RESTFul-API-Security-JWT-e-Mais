package io.github.icaroraphael.vendas.domain.repository;

import io.github.icaroraphael.vendas.domain.entity.Cliente;
import io.github.icaroraphael.vendas.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.Set;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
    Set<Pedido> findByCliente(Cliente cliente);

    @Query("select p from Pedido p left join fetch p.itens where p.id = :id")
    Optional<Pedido> findByIdFetchItens(@Param("id") Integer id);
}
