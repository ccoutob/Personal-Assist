package br.com.Personal.Assist.dto.application.empresa;

import br.com.Personal.Assist.dto.application.servico.DetalhesServico;
import br.com.Personal.Assist.model.application.empresa.Empresa;
import br.com.Personal.Assist.model.application.empresa.SegEmpresa;

import java.util.List;

public record DetalhesEmpresaServico(Long codigo, String nome, String cnpj, SegEmpresa seguimento,
                                     List<DetalhesServico> servico) {

    public DetalhesEmpresaServico(Empresa empresa){
        this(empresa.getCodigo(), empresa.getNome(), empresa.getCnpj(), empresa.getSeguimento(),
                empresa.getServico().stream().map(DetalhesServico::new).toList());
    }

}