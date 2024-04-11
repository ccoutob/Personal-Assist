package br.com.Personal.Assist.controller.empresa;

import br.com.Personal.Assist.dto.empresa.CadastroEmpresa;
import br.com.Personal.Assist.dto.empresa.DetalhesEmpresa;
import br.com.Personal.Assist.model.empresa.Empresa;
import br.com.Personal.Assist.repository.empresa.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RequestMapping("empresas")
@Controller
public class EmpresaController {

    @Autowired
    private EmpresaRepository repository;

    @GetMapping
    public ResponseEntity<List<DetalhesEmpresa>> listar(Pageable pageable){
        var lista = repository.findAll(pageable)
                .stream().map(DetalhesEmpresa::new).toList();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("{id}")
    public ResponseEntity<DetalhesEmpresa> buscar(@PathVariable("id") Long id){
        var empresa = repository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesEmpresa(empresa));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesEmpresa> cadastrar(@RequestBody CadastroEmpresa empresaPost,
                                                     UriComponentsBuilder uri){
        var empresa = new Empresa(empresaPost);
        repository.save(empresa);
        var url = uri.path("/empresas/{id}").buildAndExpand(empresa.getCodigo()).toUri();
        return ResponseEntity.created(url).body(new DetalhesEmpresa(empresa));
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<DetalhesEmpresa> atualizar(@PathVariable("id") Long id,
                                                     @RequestBody CadastroEmpresa empresaPut){
        var empresa = repository.getReferenceById(id);
        empresa.atualizarDados(empresaPut);
        return ResponseEntity.ok(new DetalhesEmpresa(empresa));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
