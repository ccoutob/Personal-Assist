package br.com.Personal.Assist.dto.cliente;

import br.com.Personal.Assist.model.cliente.PerfilCliente;

public record CadastroCliente(Long id, String nome, String email, String cpf,
                              PerfilCliente perfil, String objetivo) {
}
