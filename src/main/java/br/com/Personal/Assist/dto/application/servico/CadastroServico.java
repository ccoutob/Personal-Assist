package br.com.Personal.Assist.dto.application.servico;

import br.com.Personal.Assist.model.application.servico.CategoriaServico;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CadastroServico(@NotBlank @Size(max = 70)
                              @Schema(description = "Nome do Servico", type = "String")
                              String nome,
                              @NotBlank @Size(max = 255)
                              @Schema(description = "Descricao do Servico", type = "String")
                              String descricao,
                              @NotNull
                              @Schema(description = "Preco do Servico", type = "Integer")
                              Integer preco,
                              @NotNull
                              @Schema(description = "Categoria do Servico", type = "String")
                              CategoriaServico categoria) {
}
