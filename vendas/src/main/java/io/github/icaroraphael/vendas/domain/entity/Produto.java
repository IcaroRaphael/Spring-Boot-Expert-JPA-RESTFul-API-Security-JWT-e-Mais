package io.github.icaroraphael.vendas.domain.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "produto")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer Id;

    @Column(name = "descricao")
    @NotEmpty(message = "Campo Descrição é obrigatório.")
    private String decricao;

    @Column(name = "preco_unitario")
    @NotNull(message = "Campo Preço é obrigatório.")
    private BigDecimal preco;
}
