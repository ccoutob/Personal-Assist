package br.com.Personal.Assist.model.cliente;


import br.com.Personal.Assist.dto.cliente.CadastroCliente;
import br.com.Personal.Assist.model.estatistica.Estatistica;
import br.com.Personal.Assist.model.suporte.Suporte;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "TB_CLIENTE")//Tabela do banco de dados
@EntityListeners(AuditingEntityListener.class)
public class Cliente {

    //Chave Primária
    @Id
    @GeneratedValue
    @Column(name = "ID_CLIENTE")
    private Long codigo;

    //Coluna da tabela
    @Column(name = "NM_CLIENTE", length = 100, nullable = false)
    private String nome;

    //Coluna da tabela
    @Column(name = "DS_EMAIL", length = 100, nullable = false)
    private String email;

    ////Coluna da tabela
    @Column(name = "NR_CPF", length = 30, unique = true, nullable = false)
    private String cpf;

    //Coluna da tabela
    @Column(name = "PERFIL_CLIENTE", length = 10, nullable = false)
    @Enumerated(EnumType.STRING)
    private PerfilCliente perfil;

    //Coluna da tabela
    @Column(name = "DS_OBJETIVO", length = 100)
    private String objetivo;

    @OneToMany(mappedBy = "cliente")
    private List<Suporte> suportes;

    @OneToMany(mappedBy = "cliente")
    private List<Estatistica> estatisticasCliente;

    //Dto da classe
    public Cliente(CadastroCliente cliente){
        nome = cliente.nome();
        email = cliente.email();
        cpf = cliente.cpf();
        perfil = cliente.perfil();
        objetivo = cliente.objetivo();
    }

    //Dto da classe
    public void atualizarDados(CadastroCliente atualizacao){
        if(atualizacao.nome() != null)
            nome = atualizacao.nome();
        if(atualizacao.email() != null)
            email = atualizacao.email();
        if(atualizacao.cpf() != null)
            cpf = atualizacao.cpf();
        if(atualizacao.perfil() != null)
            perfil = atualizacao.perfil();
        if(atualizacao.objetivo() != null)
            objetivo = atualizacao.objetivo();
    }


}
