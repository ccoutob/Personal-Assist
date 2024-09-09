package br.com.Personal.Assist.dto.application.empresa;

import br.com.Personal.Assist.model.application.empresa.SegEmpresa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CadastroEmpresa(@NotBlank @Size(max = 100)
                              String nome,
                              @NotBlank @Size(max = 14)
                              String cnpj,
                              @NotNull
                              SegEmpresa seguimento,
                              @NotNull Integer nota,
                              @NotBlank @Size(max = 255)
                              String positivo,
                              @NotBlank @Size(max = 255)
                              String negativo) {
}
