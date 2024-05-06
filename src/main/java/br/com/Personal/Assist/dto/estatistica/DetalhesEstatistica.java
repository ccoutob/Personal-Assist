package br.com.Personal.Assist.dto.estatistica;

import br.com.Personal.Assist.dto.empresa.DetalhesEmpresa;
import br.com.Personal.Assist.model.estatistica.Estatistica;

import java.time.LocalDate;

public record DetalhesEstatistica(Long codigo, Integer mediaCrescimento, Integer crescimentoMensal,
                                  Integer receita, String analise, LocalDate dataRegistro) {

    public DetalhesEstatistica(Estatistica estatistica){
        this(estatistica.getCodigo(), estatistica.getMediaCrescimento(), estatistica.getCrescimentoMensal(),
                estatistica.getReceita(), estatistica.getAnalise(), estatistica.getDataRegistro());
    }
}
