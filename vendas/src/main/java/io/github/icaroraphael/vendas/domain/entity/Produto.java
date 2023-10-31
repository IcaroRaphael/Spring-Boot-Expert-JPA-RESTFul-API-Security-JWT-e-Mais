package io.github.icaroraphael.vendas.domain.entity;

import java.math.BigDecimal;

public class Produto {
    private Integer Id;
    private String decricao;
    private BigDecimal preco;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getDecricao() {
        return decricao;
    }

    public void setDecricao(String decricao) {
        this.decricao = decricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
}
