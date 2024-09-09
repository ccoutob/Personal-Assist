package br.com.Personal.Assist.dto.application.suporte;

import br.com.Personal.Assist.model.application.suporte.PrioridadeTicket;
import br.com.Personal.Assist.model.application.suporte.StatusTicket;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record CadastroSuporte(@NotBlank @Size(max = 255)
                              String descricao,
                              @NotNull
                              StatusTicket status,
                              @NotNull
                              PrioridadeTicket prioridade,
                              @NotNull
                              LocalDate dataCriacao,
                              LocalDate dataFinal) {
}
