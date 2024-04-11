package br.com.Personal.Assist.controller.estatistica;

import br.com.Personal.Assist.dto.cliente.CadastroCliente;
import br.com.Personal.Assist.dto.cliente.DetalhesCliente;
import br.com.Personal.Assist.dto.estatistica.CadastroEstatistica;
import br.com.Personal.Assist.dto.estatistica.DetalhesEstatistica;
import br.com.Personal.Assist.model.cliente.Cliente;
import br.com.Personal.Assist.model.estatistica.Estatistica;
import br.com.Personal.Assist.repository.cliente.ClienteRepository;
import br.com.Personal.Assist.repository.estatistica.EstatisticaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RequestMapping("estatisticas")
@Controller
public class EstatisticaController {

    @Autowired
    private EstatisticaRepository repository;

    @GetMapping
    public ResponseEntity<List<DetalhesEstatistica>> listar(Pageable pageable){
        var lista = repository.findAll(pageable)
                .stream().map(DetalhesEstatistica::new).toList();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("{id}")
    public ResponseEntity<DetalhesEstatistica> buscar(@PathVariable("id") Long id){
        var estatistica = repository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesEstatistica(estatistica));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesEstatistica> cadastrar(@RequestBody CadastroEstatistica estatisticaPost,
                                                     UriComponentsBuilder uri){
        var estatistica = new Estatistica(estatisticaPost);
        repository.save(estatistica);
        var url = uri.path("/estatistica/{id}").buildAndExpand(estatistica.getCodigo()).toUri();
        return ResponseEntity.created(url).body(new DetalhesEstatistica(estatistica));
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<DetalhesEstatistica> atualizar(@PathVariable("id") Long id,
                                                     @RequestBody CadastroEstatistica estatisticaPut){
        var estatistica = repository.getReferenceById(id);
        estatistica.atualizarDados(estatisticaPut);
        return ResponseEntity.ok(new DetalhesEstatistica(estatistica));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
