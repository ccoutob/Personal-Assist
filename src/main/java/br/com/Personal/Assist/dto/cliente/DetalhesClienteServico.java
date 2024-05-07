package br.com.Personal.Assist.dto.cliente;

import br.com.Personal.Assist.dto.servico.DetalhesServico;
import br.com.Personal.Assist.model.cliente.Cliente;
import br.com.Personal.Assist.model.cliente.PerfilCliente;

import java.util.List;

public record DetalhesClienteServico(Long id, String nome, String email, String cpf,
                                     PerfilCliente perfil, String objetivo, Integer nota,
                                     String positivo, String negativo, List<DetalhesServico> servico) {

    public DetalhesClienteServico(Cliente cliente){
        this(cliente.getCodigo(), cliente.getNome(), cliente.getEmail(), cliente.getCpf(), cliente.getPerfil(),
                cliente.getObjetivo(), cliente.getFeedback().getNota(), cliente.getFeedback().getPositivo(),
                cliente.getFeedback().getNegativo(),
                cliente.getServico().stream().map(DetalhesServico::new).toList());
    }
}
