package br.com.Personal.Assist.controller.cliente;

import br.com.Personal.Assist.dto.cliente.CadastroCliente;
import br.com.Personal.Assist.dto.cliente.DetalhesCliente;
import br.com.Personal.Assist.dto.estatistica.CadastroEstatistica;
import br.com.Personal.Assist.dto.estatistica.DetalhesEstatisticaCliente;
import br.com.Personal.Assist.dto.suporte.CadastroSuporte;
import br.com.Personal.Assist.dto.suporte.DetalhesSuporte;
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

    @Autowired
    private SuporteRepository suporteRepository;

    @Autowired
    private EstatisticaRepository estatisticaRepository;

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

    //Post da tabela Suporte
    @PostMapping("{id}/suporteCliente")
    @Transactional
    public ResponseEntity<DetalhesSuporteCliente> postCliente(@PathVariable("id") Long id,
                                                       @RequestBody @Valid CadastroSuporte dto,
                                                       UriComponentsBuilder uriBuilder){
        //chamar o repository post para pesquisar o post pelo codigo
        var cliente = clienteRepository.getReferenceById(id);
        //instanciar o comentário com o dto
        var suporte = new Suporte(dto, cliente);
        suporteRepository.save(suporte);
        var uri = uriBuilder.path("suporteCliente/{id}").buildAndExpand(suporte.getCodigo()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesSuporteCliente(suporte));
    }

    //Post da tabela Estatistica
    @PostMapping("{id}/estatisticaCliente")
    @Transactional
    public ResponseEntity<DetalhesEstatisticaCliente> postEstatistica(@PathVariable("id") Long id,
                                                           @RequestBody @Valid CadastroEstatistica dto,
                                                           UriComponentsBuilder uriBuilder){
        //chamar o repository post para pesquisar o post pelo codigo
        var cliente = clienteRepository.getReferenceById(id);
        //instanciar o comentário com o dto
        var estatistica = new Estatistica(dto, cliente);
        estatisticaRepository.save(estatistica);
        var uri = uriBuilder.path("estatisticaCliente/{id}").buildAndExpand(estatistica.getCodigo()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesEstatisticaCliente(estatistica));
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
