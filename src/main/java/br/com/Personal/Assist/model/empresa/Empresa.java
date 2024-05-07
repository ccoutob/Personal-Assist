package br.com.Personal.Assist.model.empresa;

import br.com.Personal.Assist.dto.cliente.CadastroCliente;
import br.com.Personal.Assist.dto.empresa.CadastroEmpresa;
import br.com.Personal.Assist.dto.empresa.DetalhesEmpresa;
import br.com.Personal.Assist.model.estatistica.Estatistica;
import br.com.Personal.Assist.model.servico.Servico;
import br.com.Personal.Assist.model.suporte.Suporte;
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

    public Empresa(CadastroEmpresa empresa){
        nome = empresa.nome();
        cnpj = empresa.cnpj();
        seguimento = empresa.seguimento();
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
