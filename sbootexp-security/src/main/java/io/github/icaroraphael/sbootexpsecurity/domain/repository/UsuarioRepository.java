package io.github.icaroraphael.sbootexpsecurity.domain.repository;

import io.github.icaroraphael.sbootexpsecurity.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
}
