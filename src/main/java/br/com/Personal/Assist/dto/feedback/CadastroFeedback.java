package br.com.Personal.Assist.dto.feedback;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CadastroFeedback(@NotNull
                               Integer nota,
                               @NotBlank @Size(max = 255)
                               String positivo,
                               @NotBlank @Size(max = 255)
                               String negativo) {
}
