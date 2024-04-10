package br.com.Personal.Assist.dto.cliente;

import br.com.Personal.Assist.model.cliente.Cliente;
import br.com.Personal.Assist.model.cliente.PerfilCliente;

public record DetalhesCliente(Long id, String nome, String email, String cpf,
                              PerfilCliente perfil, String objetivo) {

    public DetalhesCliente(Cliente cliente){
        this(cliente.getCodigo(), cliente.getNome(), cliente.getEmail(), cliente.getCpf(), cliente.getPerfil(),
                cliente.getObjetivo());
    }

}
