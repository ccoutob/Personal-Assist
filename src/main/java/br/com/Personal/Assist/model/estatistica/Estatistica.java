package br.com.Personal.Assist.model.estatistica;

import br.com.Personal.Assist.dto.estatistica.CadastroEstatistica;
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
@Table(name = "TB_ESTATISTICA")
@EntityListeners(AuditingEntityListener.class)
public class Estatistica {

    @Id
    @GeneratedValue
    @Column(name = "ID_ESTATISTICA")
    private Long codigo;

    @Column(name = "MED_CRESCIMENTO")
    private Integer mediaCrescimento; //Em porcentagem

    @Column(name = "TAX_CRESC_MES")
    private Integer crescimentoMensal; //Em porcentagem

    @Column(name = "RECEITA_LIQ")
    private Integer receita;

    @Column(name = "ANALISE_DESC", length = 500)
    private String analise;

    @Column(name = "DT_REGISTRO", nullable = false)
    private LocalDate dataRegistro;

    public Estatistica(CadastroEstatistica estatistica){
        mediaCrescimento = estatistica.mediaCrescimento();
        crescimentoMensal = estatistica.crescimentoMensal();
        receita = estatistica.receita();
        analise = estatistica.analise();
        dataRegistro = estatistica.dataRegistro();
    }

    public void atualizarDados(CadastroEstatistica atualizacao){
        if(atualizacao.mediaCrescimento() != null)
            mediaCrescimento = atualizacao.mediaCrescimento();
        if(atualizacao.crescimentoMensal() != null)
            crescimentoMensal = atualizacao.crescimentoMensal();
        if(atualizacao.receita() != null)
            receita = atualizacao.receita();
        if(atualizacao.analise() != null)
            analise = atualizacao.analise();
        if(atualizacao.dataRegistro() != null)
            dataRegistro = atualizacao.dataRegistro();
    }


}
