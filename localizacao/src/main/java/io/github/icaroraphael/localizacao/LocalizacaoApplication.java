package io.github.icaroraphael.localizacao;

import io.github.icaroraphael.localizacao.domain.entity.Cidade;
import io.github.icaroraphael.localizacao.domain.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class LocalizacaoApplication implements CommandLineRunner {
	@Autowired
	private CidadeRepository cidadeRepository;

	@Override
	public void run(String... args) throws Exception {
		listarCidadesPorNome();
		listarCidadesPorHabitantes();
	}

	public void listarCidadesPorNome(){
		cidadeRepository.findByNome("Porto Velho").forEach(System.out::println);
		cidadeRepository.findByNomeStartingWith("São").forEach(System.out::println);
		cidadeRepository.findByNomeEndingWith("fe").forEach(System.out::println);
		cidadeRepository.findByNomeContaining("Na").forEach(System.out::println);
	}

	public void listarCidadesPorHabitantes(){
		cidadeRepository.findByHabitantes(11450000l).forEach(System.out::println);
	}

	@Transactional
	public void salvarCidade(){
		var cidade = new Cidade(1L, "São Paulo", 12396372L);
		cidadeRepository.save(cidade);
	}

	public void listarCidades(){
		cidadeRepository.findAll().forEach(System.out::println);
	}

	public static void main(String[] args) {
		SpringApplication.run(LocalizacaoApplication.class, args);
	}

}