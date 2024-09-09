package br.com.Personal.Assist.dto.application.cliente;

import br.com.Personal.Assist.model.application.cliente.Cliente;
import br.com.Personal.Assist.model.application.cliente.PerfilCliente;

public record DetalhesCliente(Long id, String nome, String email, String cpf,
                              PerfilCliente perfil, String objetivo, Integer nota,
                              String positivo, String negativo) {

    public DetalhesCliente(Cliente cliente){
        this(cliente.getCodigo(), cliente.getNome(), cliente.getEmail(), cliente.getCpf(), cliente.getPerfil(),
                cliente.getObjetivo(), cliente.getFeedback().getNota(), cliente.getFeedback().getPositivo(),
                cliente.getFeedback().getNegativo());
    }


}
