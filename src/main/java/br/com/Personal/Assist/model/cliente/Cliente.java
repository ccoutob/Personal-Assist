package br.com.Personal.Assist.model.cliente;


import br.com.Personal.Assist.dto.cliente.CadastroCliente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "TB_CLIENTE")
@EntityListeners(AuditingEntityListener.class)
public class Cliente {

    @Id
    @GeneratedValue
    @Column(name = "ID_CLIENTE")
    private Long codigo;

    @Column(name = "NM_CLIENTE", length = 100, nullable = false)
    private String nome;

    @Column(name = "DS_EMAIL", length = 100, nullable = false)
    private String email;

    //O CPF será um campo único em nosso sistema
    @Column(name = "NR_CPF", length = 30, unique = true, nullable = false)
    private String cpf;

    @Column(name = "PERFIL_CLIENTE", length = 10, nullable = false)
    @Enumerated(EnumType.STRING)
    private PerfilCliente perfil;

    @Column(name = "DS_OBJETIVO", length = 100)
    private String objetivo;

    public Cliente(CadastroCliente cliente){
        nome = cliente.nome();
        email = cliente.email();
        cpf = cliente.cpf();
        perfil = cliente.perfil();
        objetivo = cliente.objetivo();
    }

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
