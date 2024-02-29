package io.github.icaroraphael.sbootexpsecurity.domain.repository;

import io.github.icaroraphael.sbootexpsecurity.domain.entity.Usuario;
import io.github.icaroraphael.sbootexpsecurity.domain.entity.UsuarioGrupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioGrupoRepository extends JpaRepository<UsuarioGrupo, String> {
    @Query("""
            select distinct g.nome 
            from UsuarioGrupo ug 
            join ug.grupo g 
            join ug.usuario u
            where u = ?1
            """)
    List<String> findPermissoesByUsuario(Usuario usuario);
}
