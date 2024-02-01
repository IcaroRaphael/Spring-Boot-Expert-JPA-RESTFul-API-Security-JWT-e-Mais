package io.github.icaroraphael.localizacao.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_cidade")
@Data
public class Cidade {
    @Id
    @Column(name = "id_cidade")
    private Long id;
    @Column(name = "nome", length = 50)
    private String nome;
    @Column(name = "qrd_habitantes")
    private Long habitantes;
}
