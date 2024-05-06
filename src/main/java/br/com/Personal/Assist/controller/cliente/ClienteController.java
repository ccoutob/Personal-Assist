package br.com.Personal.Assist.controller.cliente;

import br.com.Personal.Assist.dto.cliente.CadastroCliente;
import br.com.Personal.Assist.dto.cliente.DetalhesCliente;
import br.com.Personal.Assist.dto.estatistica.CadastroEstatistica;
import br.com.Personal.Assist.dto.estatistica.DetalhesEstatisticaCliente;
import br.com.Personal.Assist.dto.suporte.CadastroSuporte;
import br.com.Personal.Assist.dto.suporte.DetalhesSuporteCliente;
import br.com.Personal.Assist.model.cliente.Cliente;
import br.com.Personal.Assist.model.estatistica.Estatistica;
import br.com.Personal.Assist.model.suporte.Suporte;
import br.com.Personal.Assist.repository.cliente.ClienteRepository;
import br.com.Personal.Assist.repository.estatistica.EstatisticaRepository;
import br.com.Personal.Assist.repository.suporte.SuporteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RequestMapping("clientes")
@Controller
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public ResponseEntity<List<DetalhesCliente>> listar(Pageable pageable){
        var lista = clienteRepository.findAll(pageable)
                .stream().map(DetalhesCliente::new).toList();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("{id}")
    public ResponseEntity<DetalhesCliente> buscar(@PathVariable("id") Long id){
        var cliente = clienteRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesCliente(cliente));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesCliente> cadastrar(@RequestBody CadastroCliente clientePost,
                                                     UriComponentsBuilder uri){
        var cliente = new Cliente(clientePost);
        clienteRepository.save(cliente);
        var url = uri.path("/clientes/{id}").buildAndExpand(cliente.getCodigo()).toUri();
        return ResponseEntity.created(url).body(new DetalhesCliente(cliente));
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<DetalhesCliente> atualizar(@PathVariable("id") Long id,
                                                     @RequestBody CadastroCliente clientePut){
        var cliente = clienteRepository.getReferenceById(id);
        cliente.atualizarDados(clientePut);
        return ResponseEntity.ok(new DetalhesCliente(cliente));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id){
        clienteRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
