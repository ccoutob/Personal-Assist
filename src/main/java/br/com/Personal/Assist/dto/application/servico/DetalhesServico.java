package br.com.Personal.Assist.dto.application.servico;

import br.com.Personal.Assist.model.application.servico.CategoriaServico;
import br.com.Personal.Assist.model.application.servico.Servico;

public record DetalhesServico(Long codigo, String nome, String descricao, Integer preco,
                              CategoriaServico categoria) {

    public DetalhesServico(Servico servico){
        this(servico.getCodigo(), servico.getNome(), servico.getDescricao(), servico.getPreco(),
                servico.getCategoria());
    }
}
