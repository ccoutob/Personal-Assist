package br.com.Personal.Assist.dto.empresa;

import br.com.Personal.Assist.model.empresa.SegEmpresa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CadastroEmpresa(@NotBlank @Size(max = 100)
                              String nome,
                              @NotBlank @Size(max = 14)
                              String cnpj,
                              @NotNull
                              SegEmpresa seguimento) {
}
