package br.com.Personal.Assist.dto.empresa;

import br.com.Personal.Assist.model.empresa.SegEmpresa;

public record CadastroEmpresa(Long codigo, String nome, String cnpj, SegEmpresa seguimento) {
}
