package br.com.Personal.Assist.model.feedback;

import br.com.Personal.Assist.dto.cliente.CadastroCliente;
import br.com.Personal.Assist.dto.empresa.CadastroEmpresa;
import br.com.Personal.Assist.dto.feedback.CadastroFeedback;
import br.com.Personal.Assist.model.cliente.Cliente;
import br.com.Personal.Assist.model.empresa.Empresa;
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
@Table(name = "TB_FEEDBACK")//Tabela do banco de dados
@EntityListeners(AuditingEntityListener.class)
public class Feedback {

    @Id
    @GeneratedValue
    @Column(name = "ID_FEEDBACK")
    private Long codigo;

    @Column(name = "NOTA_FEEDBACK", nullable = false)
    private Integer nota;

    @Column(name = "POSITIVO_FEEDBACK", nullable = false, length = 255)
    private String positivo;

    @Column(name = "NEGATIVO_FEEDBACK", nullable = false, length = 255)
    private String negativo;

    @OneToOne
    @JoinColumn(name = "ID_CLIENTE", unique = true)
    private Cliente cliente;

    @OneToOne
    @JoinColumn(name = "ID_EMPRESA", unique = true)
    private Empresa empresa;

    public Feedback(CadastroCliente feedback){
        nota = feedback.nota();
        positivo = feedback.positivo();
        negativo = feedback.negativo();
    }

    public Feedback(CadastroEmpresa feedback){
        nota = feedback.nota();
        positivo = feedback.positivo();
        negativo = feedback.negativo();
    }

    public Feedback(CadastroFeedback feedback){
        nota = feedback.nota();
        positivo = feedback.positivo();
        negativo = feedback.negativo();
    }

    public void atualizarDados(CadastroFeedback atualizacao) {
        if (atualizacao.nota() != null)
            nota = atualizacao.nota();
        if (atualizacao.positivo() != null)
            positivo = atualizacao.positivo();
        if (atualizacao.negativo() != null)
            negativo = atualizacao.negativo();
    }


}
