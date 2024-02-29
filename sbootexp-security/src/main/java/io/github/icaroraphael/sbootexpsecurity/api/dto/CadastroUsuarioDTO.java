package io.github.icaroraphael.sbootexpsecurity.api.dto;

import io.github.icaroraphael.sbootexpsecurity.domain.entity.Grupo;
import io.github.icaroraphael.sbootexpsecurity.domain.entity.Usuario;
import lombok.Data;

import java.util.List;

@Data
public class CadastroUsuarioDTO {
    private Usuario usuario;
    private List<String> permissoes;
}
