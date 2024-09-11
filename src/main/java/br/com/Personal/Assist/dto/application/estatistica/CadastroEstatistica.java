package br.com.Personal.Assist.dto.application.estatistica;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record CadastroEstatistica(@Schema(description = "Estatistica da Media de Crescimento", type = "Integer")
                                  Integer mediaCrescimento,
                                  @Schema(description = "Estatistica de Crescimento mensal", type = "Integer")
                                  Integer crescimentoMensal,
                                  @Schema(description = "Estatistica da receita", type = "Integer")
                                  Integer receita,
                                  @Size(max = 500)
                                  @Schema(description = "Analise da Estatistica", type = "String")
                                  String analise,
                                  @NotNull
                                  @Schema(description = "Data de registro da estatisica", type = "LocalDate")
                                  LocalDate dataRegistro) {

}
