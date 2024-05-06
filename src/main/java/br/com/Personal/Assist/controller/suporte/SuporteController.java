package br.com.Personal.Assist.controller.suporte;

import br.com.Personal.Assist.dto.servico.CadastroServico;
import br.com.Personal.Assist.dto.suporte.CadastroSuporte;
import br.com.Personal.Assist.dto.suporte.DetalhesSuporte;
import br.com.Personal.Assist.dto.suporte.DetalhesSuporteCliente;
import br.com.Personal.Assist.dto.suporte.DetalhesSuporteEmpresa;
import br.com.Personal.Assist.model.suporte.Suporte;
import br.com.Personal.Assist.repository.suporte.SuporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RequestMapping("suporte")
@Controller
public class SuporteController {

    @Autowired
    private SuporteRepository repository;

    @GetMapping
    public ResponseEntity<List<DetalhesSuporte>> listarEmpresas(Pageable pageable){
        var lista = repository.findAll(pageable)
                .stream().map(DetalhesSuporte::new).toList();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("{id}")
    public ResponseEntity<DetalhesSuporte> buscar(@PathVariable("id") Long id){
        var suporte = repository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesSuporte(suporte));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesSuporte> cadastrar(@RequestBody CadastroSuporte suportePost,
                                                     UriComponentsBuilder uri){
        var suporte = new Suporte(suportePost);
        repository.save(suporte);
        var url = uri.path("/suporte/{id}").buildAndExpand(suporte.getCodigo()).toUri();
        return ResponseEntity.created(url).body(new DetalhesSuporte(suporte));
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<DetalhesSuporte> atualizar(@PathVariable("id") Long id,
                                                     @RequestBody CadastroSuporte suportePut){
        var suporte = repository.getReferenceById(id);
        suporte.atualizarDados(suportePut);
        return ResponseEntity.ok(new DetalhesSuporte(suporte));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
