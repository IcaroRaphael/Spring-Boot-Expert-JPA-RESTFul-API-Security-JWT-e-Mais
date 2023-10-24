package io.github.icaroraphael.vendas;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MinhaConfiguration {

    @Bean(name = "applicationName")
    public String applicationName(){
        return "Sistema de Vendas";
    }

    @Bean(name = "outraConfiguration")
    public String outraConfiguration(){
        return "Sistema de Vendas";
    }
}
