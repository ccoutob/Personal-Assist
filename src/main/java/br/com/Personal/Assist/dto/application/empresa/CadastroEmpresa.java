package br.com.Personal.Assist.dto.application.empresa;

import br.com.Personal.Assist.model.application.empresa.SegEmpresa;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CadastroEmpresa(@NotBlank @Size(max = 100)
                              @Schema(description = "Nome da empresa", type = "String")
                              String nome,
                              @NotBlank @Size(max = 14)
                              @Schema(description = "CNPJ da empresa", type = "String")
                              String cnpj,
                              @NotNull
                              @Schema(description = "Seguimento da empresa", type = "String")
                              SegEmpresa seguimento,
                              @Schema(description = "Nota do feedback da empresa", type = "Integer")
                              @NotNull Integer nota,
                              @NotBlank @Size(max = 255)
                              @Schema(description = "Comentario positivo da empresa", type = "String")
                              String positivo,
                              @NotBlank @Size(max = 255)
                              @Schema(description = "Comentario negativo da empresa", type = "String")
                              String negativo) {
}
