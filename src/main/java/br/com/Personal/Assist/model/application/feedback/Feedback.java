package br.com.Personal.Assist.model.application.feedback;

import br.com.Personal.Assist.dto.application.cliente.CadastroCliente;
import br.com.Personal.Assist.dto.application.empresa.CadastroEmpresa;
import br.com.Personal.Assist.dto.application.feedback.CadastroFeedback;
import br.com.Personal.Assist.model.application.empresa.Empresa;
import br.com.Personal.Assist.model.application.cliente.Cliente;
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
