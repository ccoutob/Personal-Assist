package br.com.Personal.Assist.controller.application.empresa;

import br.com.Personal.Assist.dto.application.empresa.CadastroEmpresa;
import br.com.Personal.Assist.dto.application.empresa.DetalhesEmpresa;
import br.com.Personal.Assist.dto.application.empresa.DetalhesEmpresaServico;
import br.com.Personal.Assist.model.application.empresa.Empresa;
import br.com.Personal.Assist.repository.application.empresa.EmpresaRepository;
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

@RequestMapping("empresas")
@RestController
@Tag(name = "Empresas", description = "Operações relacionadas as empresas clientes da Personal Assist")
public class EmpresaController {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private ServicoRepository servicoRepository;

    @GetMapping
    @Operation(summary = "Lista todas as empresas", description = "Lista todas as empresas do nosso sistema")
    public ResponseEntity<List<DetalhesEmpresa>> listar(Pageable pageable){
        var lista = empresaRepository.findAll(pageable)
                .stream().map(DetalhesEmpresa::new).toList();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("{id}")
    @Operation(summary = "Lista empresa específica pelo ID", description = "Lista uma unica empresa pelo ID")
    public ResponseEntity<DetalhesEmpresa> buscar(@PathVariable("id") Long id){
        var empresa = empresaRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesEmpresa(empresa));
    }

    //Post da empresa
    @PostMapping
    @Transactional
    @Operation(summary = "Cadastra uma Empresa", description = "Realiza o cadastro de uma Empresa em nossa aplicação")
    public ResponseEntity<DetalhesEmpresa> cadastrar(@RequestBody CadastroEmpresa empresaPost,
                                                     UriComponentsBuilder uri){
        var empresa = new Empresa(empresaPost);
        empresaRepository.save(empresa);
        var url = uri.path("/empresas/{id}").buildAndExpand(empresa.getCodigo()).toUri();
        return ResponseEntity.created(url).body(new DetalhesEmpresa(empresa));
    }

    @PutMapping("{idEmpresa}/servico/{idServico}")
    @Transactional
    @Operation(summary = "Adiciona um servico a uma Empresa", description = "Adiciona um servico a uma Empresa pelo id da Empresa e o id do servico")
    public ResponseEntity<DetalhesEmpresaServico> put(@PathVariable("idEmpresa") Long idEmpresa,
                                                      @PathVariable("idServico") Long idServico) {
        var empresa = empresaRepository.getReferenceById(idEmpresa);
        var servico = servicoRepository.getReferenceById(idServico);
        empresa.getServico().add(servico); //Acessa a lista de tags do post e adiciona a nova tag
        return ResponseEntity.ok(new DetalhesEmpresaServico(empresa));
    }

    @PutMapping("{id}")
    @Transactional
    @Operation(summary = "Atualiza uma empresa pelo ID", description = "Atualiza uma empresa de nosso sistema pelo seu ID")
    public ResponseEntity<DetalhesEmpresa> atualizar(@PathVariable("id") Long id,
                                                     @RequestBody CadastroEmpresa empresaPut){
        var empresa = empresaRepository.getReferenceById(id);
        empresa.atualizarDados(empresaPut);
        return ResponseEntity.ok(new DetalhesEmpresa(empresa));
    }

    @DeleteMapping("{id}")
    @Transactional
    @Operation(summary = "Deleta uma empresa pelo ID", description = "Deleta uma empresa de nosso sistema pelo seu ID")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id){
        empresaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{idEmpresa}/servico")
    @Transactional
    @Operation(summary = "Remover empresa do servico", description = "Remove uma empresa do servico pelo ID de ambos")
    public ResponseEntity<Void> deleteServicos(@PathVariable("idEmpresa") Long idEmpresa){
        var empresa = empresaRepository.getReferenceById(idEmpresa);
        empresa.getServico().clear();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{idEmpresa}/servico/{idServico}")
    @Transactional
    @Operation(summary = "Remover servico da empresa", description = "Remove um servico da empresa pelo ID de ambos")
    public ResponseEntity<Void> delete(@PathVariable("idEmpresa") Long idEmpresa,
                                       @PathVariable("idServico") Long idServico) {
        var empresa = empresaRepository.getReferenceById(idEmpresa);
        var servico = servicoRepository.getReferenceById(idServico);
        empresa.getServico().remove(servico);
        return ResponseEntity.noContent().build();
    }
}
