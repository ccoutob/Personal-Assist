package br.com.Personal.Assist.dto.cliente;

import br.com.Personal.Assist.model.cliente.Cliente;
import br.com.Personal.Assist.model.cliente.PerfilCliente;
import br.com.Personal.Assist.model.estatistica.Estatistica;

public record DetalhesCliente(Long id, String nome, String email, String cpf,
                              PerfilCliente perfil, String objetivo, Integer nota,
                              String positivo, String negativo) {

    public DetalhesCliente(Cliente cliente){
        this(cliente.getCodigo(), cliente.getNome(), cliente.getEmail(), cliente.getCpf(), cliente.getPerfil(),
                cliente.getObjetivo(), cliente.getFeedback().getNota(), cliente.getFeedback().getPositivo(),
                cliente.getFeedback().getNegativo());
    }


}
