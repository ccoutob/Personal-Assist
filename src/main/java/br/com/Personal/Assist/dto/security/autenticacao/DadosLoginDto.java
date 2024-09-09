package br.com.Personal.Assist.dto.security.autenticacao;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "Dados para validação de um Usuario")
public record DadosLoginDto(@NotBlank
                            @Schema(description = "Login do Usuario", type = "String", maximum = "50")
                            String login,
                            @NotBlank
                            @Schema(description = "Senha do Usuario", type = "String", maximum = "50")
                            String password,
                            @NotBlank
                            @Schema(description = "Email do Usuario", type = "String", maximum = "50")
                            String email) {
}
