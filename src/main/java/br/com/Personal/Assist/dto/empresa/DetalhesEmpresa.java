package br.com.Personal.Assist.dto.empresa;

import br.com.Personal.Assist.model.empresa.Empresa;
import br.com.Personal.Assist.model.empresa.SegEmpresa;

public record DetalhesEmpresa(Long codigo, String nome, String cnpj, SegEmpresa seguimento) {

    public DetalhesEmpresa(Empresa empresa){
        this(empresa.getCodigo(), empresa.getNome(), empresa.getCnpj(), empresa.getSeguimento());
    }

}
