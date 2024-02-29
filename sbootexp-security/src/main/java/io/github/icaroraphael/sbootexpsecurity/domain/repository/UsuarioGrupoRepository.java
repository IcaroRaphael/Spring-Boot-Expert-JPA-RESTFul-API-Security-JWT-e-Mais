package io.github.icaroraphael.sbootexpsecurity.domain.repository;

import io.github.icaroraphael.sbootexpsecurity.domain.entity.UsuarioGrupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioGrupoRepository extends JpaRepository<UsuarioGrupo, String> {
}
