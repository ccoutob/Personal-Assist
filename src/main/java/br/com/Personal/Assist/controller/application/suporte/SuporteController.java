package br.com.Personal.Assist.controller.application.suporte;

import br.com.Personal.Assist.dto.application.suporte.CadastroSuporte;
import br.com.Personal.Assist.dto.application.suporte.DetalhesSuporteCliente;
import br.com.Personal.Assist.dto.application.suporte.DetalhesSuporteEmpresa;
import br.com.Personal.Assist.model.application.suporte.Suporte;
import br.com.Personal.Assist.repository.application.cliente.ClienteRepository;
import br.com.Personal.Assist.repository.application.empresa.EmpresaRepository;
import br.com.Personal.Assist.repository.application.suporte.SuporteRepository;
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

@RequestMapping("suporte")
@RestController
@Tag(name = "Suporte", description = "Operações relacionadas ao Suporte da personal asssit")
public class SuporteController {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private SuporteRepository suporteRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    @GetMapping
    @Operation(summary = "Listar todos os suportes")
    public ResponseEntity<List<DetalhesSuporteCliente>> listar(Pageable pageable){
        var lista = suporteRepository.findAll(pageable)
                .stream().map(DetalhesSuporteCliente::new).toList();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("{id}")
    @Operation(summary = "Listar suporte por ID")
    public ResponseEntity<DetalhesSuporteCliente> buscar(@PathVariable("id") Long id){
        var suporte = suporteRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesSuporteCliente(suporte));
    }

    //Post da tabela Suporte para Clientes
    @PostMapping("{id}/suporteCliente")
    @Transactional
    @Operation(summary = "Cadastrar suporte para cliente")
    public ResponseEntity<DetalhesSuporteCliente> postSuporteCliente(@PathVariable("id") Long id,
                                                              @RequestBody @Valid CadastroSuporte dto,
                                                              UriComponentsBuilder uriBuilder){
        var cliente = clienteRepository.getReferenceById(id);
        var suporte = new Suporte(dto, cliente);
        suporteRepository.save(suporte);
        var uri = uriBuilder.path("suporteCliente/{id}").buildAndExpand(suporte.getCodigo()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesSuporteCliente(suporte));
    }

    //Post da tabela Suporte para Empresas
    @PostMapping("{id}/suporteEmpresa")
    @Transactional
    @Operation(summary = "Cadastrar suporte para empresa")
    public ResponseEntity<DetalhesSuporteEmpresa> postSuporteEmpresa(@PathVariable("id") Long id,
                                                              @RequestBody @Valid CadastroSuporte dto,
                                                              UriComponentsBuilder uriBuilder){
        var empresa = empresaRepository.getReferenceById(id);
        var suporte = new Suporte(dto, empresa);
        suporteRepository.save(suporte);
        var uri = uriBuilder.path("suporteCliente/{id}").buildAndExpand(suporte.getCodigo()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesSuporteEmpresa(suporte));
    }

    @DeleteMapping("{id}")
    @Transactional
    @Operation(summary = "Deletar suporte por ID")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id){
        suporteRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    @Transactional
    @Operation(summary = "Atualizar suporte por ID")
    public ResponseEntity<DetalhesSuporteCliente> atualizar(@PathVariable("id") Long id,
                                                     @RequestBody CadastroSuporte suportePut){
        var suporte = suporteRepository.getReferenceById(id);
        suporte.atualizarDados(suportePut);
        return ResponseEntity.ok(new DetalhesSuporteCliente(suporte));
    }
}
