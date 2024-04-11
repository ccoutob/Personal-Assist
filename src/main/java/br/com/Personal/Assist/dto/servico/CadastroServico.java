package br.com.Personal.Assist.dto.servico;

import br.com.Personal.Assist.model.servico.CategoriaServico;

public record CadastroServico(Long codigo, String nome, String descricao, Integer preco,
                              CategoriaServico categoria) {
}
