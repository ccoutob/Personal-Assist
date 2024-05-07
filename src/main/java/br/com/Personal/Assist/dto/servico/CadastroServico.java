package br.com.Personal.Assist.dto.servico;

import br.com.Personal.Assist.model.servico.CategoriaServico;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CadastroServico(@NotBlank @Size(max = 70) String nome,
                              @NotBlank @Size(max = 255) String descricao,
                              @NotNull Integer preco,
                              @NotNull CategoriaServico categoria) {
}
