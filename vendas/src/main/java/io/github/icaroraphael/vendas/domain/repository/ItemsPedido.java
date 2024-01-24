package io.github.icaroraphael.vendas.domain.repository;

import io.github.icaroraphael.vendas.domain.entity.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsPedido extends JpaRepository<ItemPedido, Integer> {
}
