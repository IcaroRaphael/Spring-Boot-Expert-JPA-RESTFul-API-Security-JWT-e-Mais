package io.github.icaroraphael.localizacao.domain.repository;

import io.github.icaroraphael.localizacao.domain.entity.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
}
