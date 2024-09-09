package br.com.Personal.Assist.model.application.servico;

import br.com.Personal.Assist.dto.application.servico.CadastroServico;
import br.com.Personal.Assist.model.application.cliente.Cliente;
import br.com.Personal.Assist.model.application.empresa.Empresa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "TB_SERVICO")
@EntityListeners(AuditingEntityListener.class)
public class Servico {

    @Id
    @GeneratedValue
    @Column(name = "ID_SERVICO")
    private Long codigo;

    @Column(name = "NM_SERVICO", length = 70, nullable = false)
    private String nome;

    @Column(name = "DESC_SERVICO", length = 255, nullable = false)
    private String descricao;

    @Column(name = "PRECO_SERVICO", nullable = false)
    private Integer preco;

    @Column(name = "CATEG_SERVICO", length = 50, nullable = false)
    @Enumerated(EnumType.STRING)
    private CategoriaServico categoria;

    @ManyToMany(mappedBy = "servico")
    private List<Empresa> empresas;

    @ManyToMany(mappedBy = "servico")
    private List<Cliente> clientes;

    public Servico(CadastroServico servico){
        nome = servico.nome();
        descricao = servico.descricao();
        preco = servico.preco();
        categoria = servico.categoria();
    }

    public void atualizarDados(CadastroServico atualizacao){
        if(atualizacao.nome() != null)
            nome = atualizacao.nome();
        if(atualizacao.descricao() != null)
            descricao = atualizacao.descricao();
        if(atualizacao.preco() != null)
            preco = atualizacao.preco();
        if(atualizacao.categoria() != null)
            categoria = atualizacao.categoria();
    }

}
