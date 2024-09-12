package br.com.Personal.Assist.controller.application.cliente;

import br.com.Personal.Assist.dto.application.cliente.CadastroCliente;
import br.com.Personal.Assist.dto.application.cliente.DetalhesCliente;
import br.com.Personal.Assist.dto.application.cliente.DetalhesClienteServico;
import br.com.Personal.Assist.model.application.cliente.Cliente;
import br.com.Personal.Assist.repository.application.cliente.ClienteRepository;
import br.com.Personal.Assist.repository.application.servico.ServicoRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RequestMapping("clientes")
@RestController
@Tag(name = "Cliente", description = "Operações relacionadas aos clientes da Personal Assist")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ServicoRepository servicoRepository;

    @GetMapping
    @Operation(summary = "Lista todos os clientes", description = "Lista todos os clientes do nosso sistema")
    public ResponseEntity<List<DetalhesCliente>> listar(Pageable pageable){
        var lista = clienteRepository.findAll(pageable)
                .stream().map(DetalhesCliente::new).toList();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("{id}")
    @Operation(summary = "Lista cliente específico pelo ID", description = "Lista um unico cliente pelo ID")
    public ResponseEntity<DetalhesCliente> buscar(@PathVariable("id") Long id){
        var cliente = clienteRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesCliente(cliente));
    }

    @PostMapping
    @Transactional
    @Operation(summary = "Cadastra um Cliente", description = "Realiza o cadastro de um cliente em nossa aplicação")
    public ResponseEntity<DetalhesCliente> cadastrar(@RequestBody CadastroCliente clientePost,
                                                     UriComponentsBuilder uri){
        var cliente = new Cliente(clientePost);
        clienteRepository.save(cliente);
        var url = uri.path("/clientes/{id}").buildAndExpand(cliente.getCodigo()).toUri();
        return ResponseEntity.created(url).body(new DetalhesCliente(cliente));
    }

    @PutMapping("{idCliente}/servico/{idServico}")
    @Transactional
    @Operation(summary = "Adiciona um servico a um cliente", description = "Adiciona um servico a um cliente pelo id do cliente e o id do servico")
    public ResponseEntity<DetalhesClienteServico> put(@PathVariable("idCliente") Long idCliente,
                                                      @PathVariable("idServico") Long idServico) {
        var cliente = clienteRepository.getReferenceById(idCliente);
        var servico = servicoRepository.getReferenceById(idServico);
        cliente.getServico().add(servico); //Acessa a lista de tags do post e adiciona a nova tag
        return ResponseEntity.ok(new DetalhesClienteServico(cliente));
    }

    @PutMapping("{id}")
    @Transactional
    @Operation(summary = "Atualiza um cliente pelo ID", description = "Atualiza um cliente de nosso sistema pelo seu ID")
    public ResponseEntity<DetalhesCliente> atualizar(@PathVariable("id") Long id,
                                                     @RequestBody CadastroCliente clientePut){
        var cliente = clienteRepository.getReferenceById(id);
        cliente.atualizarDados(clientePut);
        return ResponseEntity.ok(new DetalhesCliente(cliente));
    }

    @DeleteMapping("{id}")
    @Transactional
    @Operation(summary = "Deleta um cliente pelo ID", description = "Deleta um cliente de nosso sistema pelo seu ID")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id){
        clienteRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{idCliente}/servico")
    @Transactional
    @Operation(summary = "Remover cliente do servico", description = "Remove um cliente do servico pelo ID de ambos")
    public ResponseEntity<Void> deleteServicos(@PathVariable("idCliente") Long idCliente){
        var cliente = clienteRepository.getReferenceById(idCliente);
        cliente.getServico().clear();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{idCliente}/servico/{idServico}")
    @Transactional
    @Operation(summary = "Remover servico do cliente", description = "Remove um servico do cliente pelo ID de ambos")
    public ResponseEntity<Void> delete(@PathVariable("idCliente") Long idCliente,
                                       @PathVariable("idServico") Long idServico) {
        var cliente = clienteRepository.getReferenceById(idCliente);
        var servico = servicoRepository.getReferenceById(idServico);
        cliente.getServico().remove(servico);
        return ResponseEntity.noContent().build();
    }
}
