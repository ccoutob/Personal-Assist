package br.com.Personal.Assist.dto.suporte;

import br.com.Personal.Assist.dto.cliente.DetalhesCliente;
import br.com.Personal.Assist.dto.empresa.DetalhesEmpresa;
import br.com.Personal.Assist.model.suporte.PrioridadeTicket;
import br.com.Personal.Assist.model.suporte.StatusTicket;
import br.com.Personal.Assist.model.suporte.Suporte;

import java.time.LocalDate;

public record DetalhesSuporte(Long codigo, String descricao, StatusTicket status,
                              PrioridadeTicket prioridade, LocalDate dataCriacao,
                              LocalDate dataFinal) {

    public DetalhesSuporte(Suporte suporte){
        this(suporte.getCodigo(), suporte.getDescricao(), suporte.getStatus(), suporte.getPrioridade(),
        suporte.getDataCriacao(), suporte.getDataFinal());
    }
}
