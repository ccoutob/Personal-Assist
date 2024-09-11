package br.com.Personal.Assist.dto.application.suporte;

import br.com.Personal.Assist.model.application.suporte.PrioridadeTicket;
import br.com.Personal.Assist.model.application.suporte.StatusTicket;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record CadastroSuporte(@NotBlank @Size(max = 255)
                              @Schema(description = "Descrição do Suporte", type = "String", maximum = "255")
                              String descricao,
                              @NotNull
                              @Schema(description = "Status do Ticket", type = "String")
                              StatusTicket status,
                              @NotNull
                              @Schema(description = "Prioridade do Ticket", type = "String")
                              PrioridadeTicket prioridade,
                              @NotNull
                              @Schema(description = "Data criação do Ticket", type = "LocalDate")
                              LocalDate dataCriacao,
                              @Schema(description = "Data final do Ticket", type = "LocalDate")
                              LocalDate dataFinal) {
}
