package br.com.Personal.Assist.dto.application.estatistica;

import br.com.Personal.Assist.dto.application.empresa.DetalhesEmpresa;
import br.com.Personal.Assist.model.application.estatistica.Estatistica;

import java.time.LocalDate;

public record DetalhesEstatisticaEmpresa(Long codigo, Integer mediaCrescimento, Integer crescimentoMensal,
                                         Integer receita, String analise, LocalDate dataRegistro, DetalhesEmpresa empresa){

    public DetalhesEstatisticaEmpresa(Estatistica estatistica) {
        this(estatistica.getCodigo(), estatistica.getMediaCrescimento(), estatistica.getCrescimentoMensal(),
                estatistica.getReceita(), estatistica.getAnalise(), estatistica.getDataRegistro(), new DetalhesEmpresa(estatistica.getEmpresa()));
    }
}
