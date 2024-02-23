package io.github.icaroraphael.localizacao.service;

import io.github.icaroraphael.localizacao.domain.entity.Cidade;
import io.github.icaroraphael.localizacao.domain.repository.CidadeRepository;
import io.github.icaroraphael.localizacao.domain.repository.specs.CidadeSpecs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

import static io.github.icaroraphael.localizacao.domain.repository.specs.CidadeSpecs.*;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public void listarCidadesPorNome(){
        cidadeRepository.findByNome("Porto Velho").forEach(System.out::println);
        cidadeRepository.findByNomeStartingWith("São").forEach(System.out::println);
        cidadeRepository.findByNomeEndingWith("fe").forEach(System.out::println);
        cidadeRepository.findByNomeContaining("Na").forEach(System.out::println);
        cidadeRepository.findByNomeLike("%s%").forEach(System.out::println);
        cidadeRepository.findByNomeContainingIgnoreCase("za").forEach(System.out::println);
    }

    public void listarCidadesPorHabitantes(){
        cidadeRepository.findByHabitantes(11450000l).forEach(System.out::println);
        cidadeRepository.findByHabitantesLessThan(1000000l).forEach(System.out::println);
        cidadeRepository.findByHabitantesGreaterThan(1000000l).forEach(System.out::println);
        cidadeRepository.findByHabitantesLessThanAndNomeLike(1000000l, "Natal").forEach(System.out::println);

    }

    @Transactional
    public void salvarCidade(){
        var cidade = new Cidade(1L, "São Paulo", 12396372L);
        cidadeRepository.save(cidade);
    }

    public void listarCidades(){
        cidadeRepository.findAll(Sort.by("habitantes")).forEach(System.out::println);

        Pageable pageable = PageRequest.of(1, 2);
        cidadeRepository.findAll(pageable).forEach(System.out::println);
    }

    public List<Cidade> filtroDinamico(Cidade cidade){
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.STARTING);
        Example<Cidade> example = Example.of(cidade, matcher);
        return cidadeRepository.findAll(example);

    }

    public void listarCidadesByNomeSpec(){
        Specification<Cidade> specs = CidadeSpecs.nomeEqual("São Paulo").and(CidadeSpecs.habitantesGreaterThan(1000000l));
        cidadeRepository.findAll(specs).forEach(System.out::println);
    }

    public void listarCidadesSpecsFiltroDinamico(Cidade filtro){
        Specification<Cidade> specs = Specification.where((root, query, criteriaBuilder) -> criteriaBuilder.conjunction());
        if(filtro.getId() != null){
            specs = specs.and(idEqual(filtro.getId()));
        }
        if(StringUtils.hasText(filtro.getNome())){
            specs = specs.and(nomeLike(filtro.getNome()));
        }
        if(filtro.getHabitantes() != null){
            specs = specs.and(habitantesGreaterThan(filtro.getHabitantes()));
        }

        cidadeRepository.findAll(specs).forEach(System.out::println);
    }
}
