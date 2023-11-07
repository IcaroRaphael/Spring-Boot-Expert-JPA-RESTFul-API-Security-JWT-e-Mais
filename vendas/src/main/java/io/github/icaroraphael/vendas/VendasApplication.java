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
			clienteRepository.salvar(new Cliente("Dougllas"));
			clienteRepository.salvar(new Cliente("Outro Cliente"));

			List<Cliente> todosClientes = clienteRepository.obterTodos();
			todosClientes.forEach(System.out::println);

//			System.out.println("ATUALIZANDO CLIENTES:");
//			todosClientes.forEach(cliente -> {
//				cliente.setNome(cliente.getNome() + " atualizado");
//				clienteRepository.atualizar(cliente);
//			});
//
//			System.out.println("BUSCANDO CLIENTES:");
//			System.out.println(clienteRepository.buscarPorNome("Cli"));

//			System.out.println("DELETANDO CLIENTES:");
//			clienteRepository.obterTodos().forEach(cliente -> {
//				clienteRepository.deletar(cliente);
//			});

//			todosClientes = clienteRepository.obterTodos();
//			if(todosClientes.isEmpty()){
//				System.out.println("Nenhum cliente encontrado");
//			}
//			else {
//				todosClientes.forEach(System.out::println);
//			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}
}
