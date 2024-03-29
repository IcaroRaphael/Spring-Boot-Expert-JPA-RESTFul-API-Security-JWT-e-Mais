package io.github.icaroraphael.localizacao;

import io.github.icaroraphael.localizacao.domain.entity.Cidade;
import io.github.icaroraphael.localizacao.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LocalizacaoApplication implements CommandLineRunner {
	@Autowired
	private CidadeService cidadeService;

	@Override
	public void run(String... args) throws Exception {
//		cidadeService.listarCidadesPorNome();
//		cidadeService.listarCidadesPorHabitantes();
//		cidadeService.listarCidades();
//		var cidade = new Cidade(null, "porto", null);
//		cidadeService.filtroDinamico(cidade).forEach(System.out::println);
//		cidadeService.listarCidadesByNomeSpec();
//		var cidade = new Cidade(1l, "São Paulo", 10000000l);
//		cidadeService.listarCidadesSpecsFiltroDinamico(cidade);
		cidadeService.listarCidadesPorNomeSqlNativo();
	}

	public static void main(String[] args) {
		SpringApplication.run(LocalizacaoApplication.class, args);
	}

}