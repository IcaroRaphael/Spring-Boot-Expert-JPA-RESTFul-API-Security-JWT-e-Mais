package io.github.icaroraphael.vendas;

import io.github.icaroraphael.vendas.domain.entity.Cliente;
import io.github.icaroraphael.vendas.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VendasApplication {
	@Bean
	public CommandLineRunner commandLineRunner(@Autowired ClienteRepository repository){
		return args -> {
			Cliente c = new Cliente(null, "Fulano");
			repository.save(c);
		};
	}
	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}
}
