package br.com.Personal.Assist.model.application.empresa;

import br.com.Personal.Assist.dto.application.empresa.CadastroEmpresa;
import br.com.Personal.Assist.model.application.servico.Servico;
import br.com.Personal.Assist.model.application.estatistica.Estatistica;
import br.com.Personal.Assist.model.application.feedback.Feedback;
import br.com.Personal.Assist.model.application.suporte.Suporte;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "TB_EMPRESA")//Tabela do banco de dados
@EntityListeners(AuditingEntityListener.class)
public class Empresa {

    //Chave Primária
    @Id
    @GeneratedValue
    @Column(name = "ID_EMPRESA")
    private Long codigo;

    //Coluna da tabela
    @Column(name = "NM_EMPRESA", length = 100, nullable = false)
    private String nome;

    //Coluna da tabela
    @Column(name = "CNPJ_EMPRESA", length = 14, nullable = false)
    private String cnpj;

    //Coluna da tabela
    @Column(name = "SEG_EMPRESA", length = 30, nullable = false)
    @Enumerated(EnumType.STRING)
    private SegEmpresa seguimento;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
    private List<Suporte> suportes;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
    private List<Estatistica> estatisticasEmpresa;

    @ManyToMany
    @JoinTable(name="TB_EMPRESA_SERVICO",
            joinColumns = @JoinColumn(name="ID_EMPRESA"),
            inverseJoinColumns = @JoinColumn(name="ID_SERVICO"))
    private Set<Servico> servico = new HashSet<>();

    @OneToOne(mappedBy = "empresa", cascade = CascadeType.ALL)
    private Feedback feedback;

    public Empresa(CadastroEmpresa empresa){
        nome = empresa.nome();
        cnpj = empresa.cnpj();
        seguimento = empresa.seguimento();
        feedback = new Feedback(empresa);
        feedback.setEmpresa(this);
    }

    public void atualizarDados(CadastroEmpresa atualizacao){
        if(atualizacao.nome() != null)
            nome = atualizacao.nome();
        if(atualizacao.cnpj() != null)
            cnpj = atualizacao.cnpj();
        if(atualizacao.seguimento() != null)
            seguimento = atualizacao.seguimento();
    }

}
