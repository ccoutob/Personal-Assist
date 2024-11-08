package br.com.Personal.Assist.dto.application.empresa;

import br.com.Personal.Assist.model.application.empresa.Empresa;
import br.com.Personal.Assist.model.application.empresa.SegEmpresa;

public record DetalhesEmpresa(Long codigo, String nome, String cnpj, SegEmpresa seguimento, Integer nota,
                              String positivo, String negativo) {

    public DetalhesEmpresa(Empresa empresa){
        this(empresa.getCodigo(), empresa.getNome(), empresa.getCnpj(), empresa.getSeguimento(),
                empresa.getFeedback().getNota(), empresa.getFeedback().getPositivo(),
                empresa.getFeedback().getNegativo());
    }

}
