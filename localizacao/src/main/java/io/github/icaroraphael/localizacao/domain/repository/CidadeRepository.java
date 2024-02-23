package io.github.icaroraphael.localizacao.domain.repository;

import io.github.icaroraphael.localizacao.domain.entity.Cidade;
import io.github.icaroraphael.localizacao.domain.repository.projections.CidadeProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CidadeRepository extends JpaRepository<Cidade, Long>, JpaSpecificationExecutor<Cidade> {
    // Busca todas as cidades ordenadas por parâmetro
    List<Cidade> findAll(Sort sort);

    // Busca todas as cidades paginadas
    Page<Cidade> findAll(Pageable pageable);

    // Busca pelo nome
    List<Cidade> findByNome(String nome);

    // Busca pelo nome com SQL Nativo
    @Query(nativeQuery = true, value = "select c.id_cidade as id, c.nome from tb_cidade as c where c.nome = :nome")
    List<CidadeProjection> findByNomeSqlNativo(@Param("nome") String nome);

    // Busca pelo nome like
    @Query("select c from Cidade c where upper(c.nome) like upper(:nome)")
    List<Cidade> findByNomeLike(String nome);

    // Busca pelo nome começado por determinada string
    List<Cidade> findByNomeStartingWith(String nome);

    // Busca pelo nome terminado por determinada string
    List<Cidade> findByNomeEndingWith(String nome);

    // Busca pelo nome que contem determinada string
    List<Cidade> findByNomeContaining(String nome);

    // Busca pelo nome que contem determinada string ignorando case
    List<Cidade> findByNomeContainingIgnoreCase(String nome);

    // Busca cidade pelo numero de habitantes
    List<Cidade> findByHabitantes(Long habitantes);

    // Busca cidade com população menor que a do parâmetro
    List<Cidade> findByHabitantesLessThan(Long habitantes);

    // Busca cidade com população maior que a do parâmetro
    List<Cidade> findByHabitantesGreaterThan(Long habitantes);

    // Busca cidade com população menor que a do parâmetro e com determinado nome
    List<Cidade> findByHabitantesLessThanAndNomeLike(Long habitantes, String nome);
}
