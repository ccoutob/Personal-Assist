package br.com.Personal.Assist.dto.estatistica;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record CadastroEstatistica(Integer mediaCrescimento,
                                  Integer crescimentoMensal,
                                  Integer receita,
                                  @Size(max = 500)
                                  String analise,
                                  @NotNull
                                  LocalDate dataRegistro) {

}
