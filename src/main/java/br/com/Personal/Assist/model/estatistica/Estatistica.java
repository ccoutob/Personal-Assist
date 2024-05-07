package br.com.Personal.Assist.model.estatistica;

import br.com.Personal.Assist.dto.estatistica.CadastroEstatistica;
import br.com.Personal.Assist.model.cliente.Cliente;
import br.com.Personal.Assist.model.empresa.Empresa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "estatisticasEmpresa")
    private Empresa empresa;

    @ManyToOne
    @JoinColumn(name = "estatisticasCliente")
    private Cliente cliente;

    public Estatistica(CadastroEstatistica estatistica){
        mediaCrescimento = estatistica.mediaCrescimento();
        crescimentoMensal = estatistica.crescimentoMensal();
        receita = estatistica.receita();
        analise = estatistica.analise();
        dataRegistro = estatistica.dataRegistro();
    }

    public Estatistica(CadastroEstatistica estatistica, Empresa empresa){
        mediaCrescimento = estatistica.mediaCrescimento();
        crescimentoMensal = estatistica.crescimentoMensal();
        receita = estatistica.receita();
        analise = estatistica.analise();
        dataRegistro = estatistica.dataRegistro();
        this.empresa = empresa;
    }

    public Estatistica(CadastroEstatistica estatistica, Cliente cliente){
        mediaCrescimento = estatistica.mediaCrescimento();
        crescimentoMensal = estatistica.crescimentoMensal();
        receita = estatistica.receita();
        analise = estatistica.analise();
        dataRegistro = estatistica.dataRegistro();
        this.cliente = cliente;
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
