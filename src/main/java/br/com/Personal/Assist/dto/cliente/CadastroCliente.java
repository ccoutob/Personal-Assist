package br.com.Personal.Assist.dto.cliente;

import br.com.Personal.Assist.model.cliente.PerfilCliente;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CadastroCliente(@NotBlank @Size(max = 100) String nome,
                              @NotBlank @Size(max = 100) String email,
                              @NotBlank @Size(max = 30) String cpf,
                              @NotNull PerfilCliente perfil,
                              @NotBlank @Size(max = 255) String objetivo,
                              @NotNull Integer nota,
                              @NotBlank @Size(max = 255)
                              String positivo,
                              @NotBlank @Size(max = 255)
                              String negativo) {
}
