package io.github.icaroraphael.vendas;

import io.github.icaroraphael.vendas.domain.entity.Cliente;
import io.github.icaroraphael.vendas.domain.entity.Pedido;
import io.github.icaroraphael.vendas.domain.repository.ClienteRepository;
import io.github.icaroraphael.vendas.domain.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
public class VendasApplication {
	@Bean
	public CommandLineRunner init(
			@Autowired ClienteRepository clienteRepository,
			@Autowired PedidoRepository pedidoRepository){
		return args -> {
			System.out.println("SALVANDO CLIENTES:");
			Cliente fulano = new Cliente("Fulano");
			clienteRepository.save(fulano);
			clienteRepository.save(new Cliente("Outro Cliente"));

			System.out.println("SALVANDO PEDIDO:");
			Pedido p = new Pedido();
			p.setCliente(fulano);
			p.setDataPedido(LocalDate.now());
			p.setTotal(BigDecimal.valueOf(100.00));
			pedidoRepository.save(p);

			System.out.println("PESQUISANDO CLIENTE:");
//			Cliente cliente = clienteRepository.findClienteFetchPedidos(fulano.getId());
//			System.out.println(cliente);
//			System.out.println(cliente.getPedidos());
			pedidoRepository.findByCliente(fulano).forEach(System.out::println);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}
}
