package br.com.Personal.Assist.controller.estatistica;

import br.com.Personal.Assist.dto.cliente.CadastroCliente;
import br.com.Personal.Assist.dto.cliente.DetalhesCliente;
import br.com.Personal.Assist.dto.empresa.CadastroEmpresa;
import br.com.Personal.Assist.dto.empresa.DetalhesEmpresa;
import br.com.Personal.Assist.dto.estatistica.CadastroEstatistica;
import br.com.Personal.Assist.dto.estatistica.DetalhesEstatistica;
import br.com.Personal.Assist.dto.estatistica.DetalhesEstatisticaCliente;
import br.com.Personal.Assist.dto.estatistica.DetalhesEstatisticaEmpresa;
import br.com.Personal.Assist.model.cliente.Cliente;
import br.com.Personal.Assist.model.empresa.Empresa;
import br.com.Personal.Assist.model.estatistica.Estatistica;
import br.com.Personal.Assist.repository.cliente.ClienteRepository;
import br.com.Personal.Assist.repository.empresa.EmpresaRepository;
import br.com.Personal.Assist.repository.estatistica.EstatisticaRepository;
import jakarta.validation.Valid;
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
    private EstatisticaRepository estatisticarepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public ResponseEntity<List<DetalhesEstatistica>> listar(Pageable pageable){
        var lista = estatisticarepository.findAll(pageable)
                .stream().map(DetalhesEstatistica::new).toList();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("{id}")
    public ResponseEntity<DetalhesEstatistica> buscar(@PathVariable("id") Long id){
        var estatistica = estatisticarepository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesEstatistica(estatistica));
    }

    //Post da tabela Estatistica para Clientes
    @PostMapping("{id}/estatisticaCliente")
    @Transactional
    public ResponseEntity<DetalhesEstatisticaCliente> postEstatisticaCliente(@PathVariable("id") Long id,
                                                                      @RequestBody @Valid CadastroEstatistica dto,
                                                                      UriComponentsBuilder uriBuilder){
        var cliente = clienteRepository.getReferenceById(id);
        var estatistica = new Estatistica(dto, cliente);
        estatisticarepository.save(estatistica);
        var uri = uriBuilder.path("estatisticaCliente/{id}").buildAndExpand(estatistica.getCodigo()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesEstatisticaCliente(estatistica));
    }

    //Post da tabela Estatistica
    @PostMapping("{id}/estatisticaEmpresa")
    @Transactional
    public ResponseEntity<DetalhesEstatisticaEmpresa> postEstatisticaEmpresa(@PathVariable("id") Long id,
                                                                      @RequestBody @Valid CadastroEstatistica dto,
                                                                      UriComponentsBuilder uriBuilder){
        var empresa = empresaRepository.getReferenceById(id);
        var estatistica = new Estatistica(dto, empresa);
        estatisticarepository.save(estatistica);
        var uri = uriBuilder.path("estatisticaEmpresa/{id}").buildAndExpand(estatistica.getCodigo()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesEstatisticaEmpresa(estatistica));
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<DetalhesEstatistica> atualizar(@PathVariable("id") Long id,
                                                     @RequestBody CadastroEstatistica estatisticaPut){
        var estatistica = estatisticarepository.getReferenceById(id);
        estatistica.atualizarDados(estatisticaPut);
        return ResponseEntity.ok(new DetalhesEstatistica(estatistica));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id){
        estatisticarepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
