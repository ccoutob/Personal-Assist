package br.com.Personal.Assist.model.suporte;

import br.com.Personal.Assist.dto.estatistica.CadastroEstatistica;
import br.com.Personal.Assist.dto.suporte.CadastroSuporte;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "TB_SUPORTE")
@EntityListeners(AuditingEntityListener.class)
public class Suporte {

    @Id
    @GeneratedValue
    @Column(name = "ID_SUPORTE")
    private Long codigo;

    @Column(name = "DESC_PROBLEMA", length = 255, nullable = false)
    private String descricao;

    @Column(name = "STAT_TICKET", length = 30, nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusTicket status;

    @Column(name = "PRIOR_TICKET", length = 30, nullable = false)
    @Enumerated(EnumType.STRING)
    private PrioridadeTicket prioridade;

    @Column(name = "DT_CRIACAO", nullable = false)
    private LocalDate dataCriacao;

    @Column(name = "DT_FINAL")
    private LocalDate dataFinal;

    public Suporte(CadastroSuporte suporte){
        descricao = suporte.descricao();
        status = suporte.status();
        prioridade = suporte.prioridade();
        dataCriacao = suporte.dataCriacao();
        dataFinal = suporte.dataFinal();
    }

    public void atualizarDados(CadastroSuporte atualizacao){
        if(atualizacao.descricao() != null)
            descricao = atualizacao.descricao();
        if(atualizacao.status() != null)
            status = atualizacao.status();
        if(atualizacao.prioridade() != null)
            prioridade = atualizacao.prioridade();
        if(atualizacao.dataCriacao() != null)
            dataCriacao = atualizacao.dataCriacao();
        if(atualizacao.dataFinal() != null)
            dataFinal = atualizacao.dataFinal();
    }
}
