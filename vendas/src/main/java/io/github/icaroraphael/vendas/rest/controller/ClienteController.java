package io.github.icaroraphael.vendas.rest.controller;

import io.github.icaroraphael.vendas.domain.entity.Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/clientes")
public class ClienteController {
    @RequestMapping(
            value = {"/hello/{nome}", "/api/hello"},
            method = RequestMethod.POST,
            consumes = {"application/jason", "application/xml"},
            produces = {"application/jason", "application/xml"})
    @ResponseBody
    public String helloCliente(@PathVariable("nome") String nomeCliente, @RequestBody Cliente cliente){
        return String.format("Hello %s", nomeCliente);
    }
}
