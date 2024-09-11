package br.com.Personal.Assist.dto.application.cliente;

import br.com.Personal.Assist.model.application.cliente.PerfilCliente;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CadastroCliente(@NotBlank @Size(max = 100)
                              @Schema(description = "Nome do cliente", type = "String")
                              String nome,
                              @NotBlank @Size(max = 100)
                              @Schema(description = "Email do cliente", type = "String")
                              String email,
                              @NotBlank @Size(max = 30)
                              @Schema(description = "CPF do cliente", type = "String")
                              String cpf,
                              @NotNull
                              @Schema(description = "Perfil do cliente", type = "String")
                              PerfilCliente perfil,
                              @NotBlank @Size(max = 255)
                              @Schema(description = "Objetivo do cliente", type = "String")
                              String objetivo,
                              @NotNull
                              @Schema(description = "Nota feedback do cliente", type = "Integer")
                              Integer nota,
                              @NotBlank @Size(max = 255)
                              @Schema(description = "Comentario feedback positivo do cliente", type = "String")
                              String positivo,
                              @NotBlank @Size(max = 255)
                              @Schema(description = "Comentario feedback negativo do cliente", type = "String")
                              String negativo) {
}
