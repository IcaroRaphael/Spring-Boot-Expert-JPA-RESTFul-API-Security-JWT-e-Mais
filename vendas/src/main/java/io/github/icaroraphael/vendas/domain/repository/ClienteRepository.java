package io.github.icaroraphael.vendas.domain.repository;

import io.github.icaroraphael.vendas.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

//    @Query(value = "select c from Cliente c where c.nome like %:nome%")
    @Query(value = "select * from Cliente c where c.nome like %:nome%", nativeQuery = true)
    List<Cliente> encontrarPorNome(@Param("nome") String nome);

    List<Cliente> findByNomeOrIdOrderById(String nome, Integer id);

    boolean existsByNome(String nome);

    @Transactional
    @Modifying
    @Query("DELETE FROM Cliente c WHERE c.nome = :nome")
    void deletarPorNome(@Param("nome") String nome);
}
