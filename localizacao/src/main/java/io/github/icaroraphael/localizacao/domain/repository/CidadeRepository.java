package io.github.icaroraphael.localizacao.domain.repository;

import io.github.icaroraphael.localizacao.domain.entity.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    // Busca pelo nome
    List<Cidade> findByNome(String nome);

    // Busca pelo nome começado por determinada string
    List<Cidade> findByNomeStartingWith(String nome);

    // Busca pelo nome terminado por determinada string
    List<Cidade> findByNomeEndingWith(String nome);

    // Busca pelo nome que contem determinada string
    List<Cidade> findByNomeContaining(String nome);

    // Busca cidade pelo numero de habitantes
    List<Cidade> findByHabitantes(Long habitantes);
}
