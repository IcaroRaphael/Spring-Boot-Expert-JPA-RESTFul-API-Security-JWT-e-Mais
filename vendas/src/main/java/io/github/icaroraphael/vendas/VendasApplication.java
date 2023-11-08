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
			clienteRepository.save(new Cliente("Dougllas"));
			clienteRepository.save(new Cliente("Outro Cliente"));

			List<Cliente> todosClientes = clienteRepository.findAll();
			todosClientes.forEach(System.out::println);

			System.out.println("ATUALIZANDO CLIENTES:");
			todosClientes.forEach(cliente -> {
				cliente.setNome(cliente.getNome() + " atualizado");
				clienteRepository.save(cliente);
			});

			todosClientes = clienteRepository.findAll();
			todosClientes.forEach(System.out::println);

			System.out.println("BUSCANDO CLIENTES:");
			System.out.println(clienteRepository.findByNomeContainingIgnoreCase("Cli"));

			System.out.println("DELETANDO CLIENTES:");
			clienteRepository.findAll().forEach(cliente -> {
				clienteRepository.delete(cliente);
			});

			todosClientes = clienteRepository.findAll();
			if(todosClientes.isEmpty()){
				System.out.println("Nenhum cliente encontrado");
			}
			else {
				todosClientes.forEach(System.out::println);
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}
}
