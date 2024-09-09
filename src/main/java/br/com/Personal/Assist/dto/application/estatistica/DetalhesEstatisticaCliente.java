package br.com.Personal.Assist.dto.application.estatistica;

import br.com.Personal.Assist.dto.application.cliente.DetalhesCliente;
import br.com.Personal.Assist.model.application.estatistica.Estatistica;

import java.time.LocalDate;

public record DetalhesEstatisticaCliente(Long codigo, Integer mediaCrescimento, Integer crescimentoMensal,
                                         Integer receita, String analise, LocalDate dataRegistro, DetalhesCliente empresa) {

    public DetalhesEstatisticaCliente(Estatistica estatistica){
        this(estatistica.getCodigo(), estatistica.getMediaCrescimento(), estatistica.getCrescimentoMensal(),
                estatistica.getReceita(), estatistica.getAnalise(), estatistica.getDataRegistro(), new DetalhesCliente(estatistica.getCliente()));
    }
}
