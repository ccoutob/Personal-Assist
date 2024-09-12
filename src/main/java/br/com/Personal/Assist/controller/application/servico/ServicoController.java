package br.com.Personal.Assist.controller.application.servico;

import br.com.Personal.Assist.dto.application.servico.CadastroServico;
import br.com.Personal.Assist.dto.application.servico.DetalhesServico;
import br.com.Personal.Assist.model.application.servico.Servico;
import br.com.Personal.Assist.repository.application.servico.ServicoRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RequestMapping("servico")
@RestController
@Tag(name = "Servico", description = "Operações relacionadas ao Serviço da Personal Assist")
public class ServicoController {

    @Autowired
    private ServicoRepository repository;

    @GetMapping
    @Operation(summary = "Listar todos os Servicos")
    public ResponseEntity<List<DetalhesServico>> listar(Pageable pageable){
        var lista = repository.findAll(pageable)
                .stream().map(DetalhesServico::new).toList();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("{id}")
    @Operation(summary = "Listar servico por ID")
    public ResponseEntity<DetalhesServico> buscar(@PathVariable("id") Long id){
        var servico = repository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesServico(servico));
    }

    @PostMapping
    @Transactional
    @Operation(summary = "Cadastrar um Servico")
    public ResponseEntity<DetalhesServico> cadastrar(@RequestBody @Valid CadastroServico servicoPost,
                                                     UriComponentsBuilder uri){
        var servico = new Servico(servicoPost);
        repository.save(servico);
        var url = uri.path("/servicos/{id}").buildAndExpand(servico.getCodigo()).toUri();
        return ResponseEntity.created(url).body(new DetalhesServico(servico));
    }

    @PutMapping("{id}")
    @Transactional
    @Operation(summary = "Atualizar servico por ID")
    public ResponseEntity<DetalhesServico> atualizar(@PathVariable("id") Long id,
                                                     @RequestBody CadastroServico servicoPut){
        var servico = repository.getReferenceById(id);
        servico.atualizarDados(servicoPut);
        return ResponseEntity.ok(new DetalhesServico(servico));
    }

    @DeleteMapping("{id}")
    @Transactional
    @Operation(summary = "Deletar servico por ID")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
