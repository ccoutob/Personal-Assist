package br.com.Personal.Assist.dto.suporte;

import br.com.Personal.Assist.model.suporte.PrioridadeTicket;
import br.com.Personal.Assist.model.suporte.StatusTicket;

import java.time.LocalDate;

public record CadastroSuporte(Long codigo, String descricao, StatusTicket status, PrioridadeTicket prioridade,
                              LocalDate dataCriacao, LocalDate dataFinal) {
}
