package io.github.icaroraphael.vendas;

import io.github.icaroraphael.vendas.domain.entity.Cliente;
import io.github.icaroraphael.vendas.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class VendasApplication {
	@Bean
	public CommandLineRunner init(@Autowired ClienteRepository clienteRepository){
		return args -> {
			System.out.println("SALVANDO CLIENTES:");
			clienteRepository.save(new Cliente("Fulano"));
			clienteRepository.save(new Cliente("Outro Cliente"));

			boolean existe = clienteRepository.existsByNome("Dougllas");
			System.out.println("Existe um cliente com o nome 'Dougllas': " + existe);


		};
	}

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}
}
