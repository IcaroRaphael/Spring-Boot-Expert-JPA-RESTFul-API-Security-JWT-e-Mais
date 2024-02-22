package io.github.icaroraphael.localizacao.service;

import io.github.icaroraphael.localizacao.domain.entity.Cidade;
import io.github.icaroraphael.localizacao.domain.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
