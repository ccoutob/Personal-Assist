package br.com.Personal.Assist.dto.application.feedback;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CadastroFeedback(@NotNull
                               @Schema(description = "Nota do Feedback", type = "Integer")
                               Integer nota,
                               @NotBlank @Size(max = 255)
                               @Schema(description = "Comentario positivo do Feedback", type = "String")
                               String positivo,
                               @NotBlank @Size(max = 255)
                               @Schema(description = "Comentario negativo do Feedback", type = "String")
                               String negativo) {
}
