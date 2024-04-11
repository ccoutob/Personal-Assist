package br.com.Personal.Assist.dto.estatistica;

import java.time.LocalDate;

public record CadastroEstatistica(Long codigo, Integer mediaCrescimento, Integer crescimentoMensal,
                                  Integer receita, String analise, LocalDate dataRegistro) {

}
