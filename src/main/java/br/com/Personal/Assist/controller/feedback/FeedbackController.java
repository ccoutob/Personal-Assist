package br.com.Personal.Assist.controller.feedback;

import br.com.Personal.Assist.dto.cliente.CadastroCliente;
import br.com.Personal.Assist.dto.cliente.DetalhesCliente;
import br.com.Personal.Assist.dto.feedback.CadastroFeedback;
import br.com.Personal.Assist.dto.feedback.DetalhesFeedback;
import br.com.Personal.Assist.model.cliente.Cliente;
import br.com.Personal.Assist.model.feedback.Feedback;
import br.com.Personal.Assist.repository.feedback.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RequestMapping("feedback")
@Controller
public class FeedbackController {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @GetMapping
    public ResponseEntity<List<DetalhesFeedback>> listar(Pageable pageable){
        var lista = feedbackRepository.findAll(pageable)
                .stream().map(DetalhesFeedback::new).toList();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("{id}")
    public ResponseEntity<DetalhesFeedback> buscar(@PathVariable("id") Long id){
        var feedback = feedbackRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesFeedback(feedback));
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<DetalhesFeedback> atualizar(@PathVariable("id") Long id,
                                                     @RequestBody CadastroFeedback feedbackPut){
        var feedback = feedbackRepository.getReferenceById(id);
        feedback.atualizarDados(feedbackPut);
        return ResponseEntity.ok(new DetalhesFeedback(feedback));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id){
        feedbackRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
