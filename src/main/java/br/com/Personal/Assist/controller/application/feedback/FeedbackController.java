package br.com.Personal.Assist.controller.application.feedback;

import br.com.Personal.Assist.dto.application.feedback.CadastroFeedback;
import br.com.Personal.Assist.dto.application.feedback.DetalhesFeedback;
import br.com.Personal.Assist.repository.application.feedback.FeedbackRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("feedback")
@RestController
@Tag(name = "Feedback", description = "Operações relacionadas ao Feedback de empresas e clientes")
public class FeedbackController {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @GetMapping
    @Operation(summary = "Listar todos os feedbacks")
    public ResponseEntity<List<DetalhesFeedback>> listar(Pageable pageable){
        var lista = feedbackRepository.findAll(pageable)
                .stream().map(DetalhesFeedback::new).toList();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("{id}")
    @Operation(summary = "Listar feedback por ID")
    public ResponseEntity<DetalhesFeedback> buscar(@PathVariable("id") Long id){
        var feedback = feedbackRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesFeedback(feedback));
    }

    @PutMapping("{id}")
    @Transactional
    @Operation(summary = "Atualizar feedback por ID")
    public ResponseEntity<DetalhesFeedback> atualizar(@PathVariable("id") Long id,
                                                     @RequestBody CadastroFeedback feedbackPut){
        var feedback = feedbackRepository.getReferenceById(id);
        feedback.atualizarDados(feedbackPut);
        return ResponseEntity.ok(new DetalhesFeedback(feedback));
    }

    @DeleteMapping("{id}")
    @Transactional
    @Operation(summary = "Deletar feedback por ID")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id){
        feedbackRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
