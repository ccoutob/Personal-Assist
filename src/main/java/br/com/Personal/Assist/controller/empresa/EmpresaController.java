package br.com.Personal.Assist.controller.empresa;

import br.com.Personal.Assist.dto.empresa.CadastroEmpresa;
import br.com.Personal.Assist.dto.empresa.DetalhesEmpresa;
import br.com.Personal.Assist.dto.estatistica.CadastroEstatistica;
import br.com.Personal.Assist.dto.estatistica.DetalhesEstatistica;
import br.com.Personal.Assist.dto.estatistica.DetalhesEstatisticaEmpresa;
import br.com.Personal.Assist.dto.suporte.CadastroSuporte;
import br.com.Personal.Assist.dto.suporte.DetalhesSuporte;
import br.com.Personal.Assist.dto.suporte.DetalhesSuporteEmpresa;
import br.com.Personal.Assist.model.empresa.Empresa;
import br.com.Personal.Assist.model.estatistica.Estatistica;
import br.com.Personal.Assist.model.suporte.Suporte;
import br.com.Personal.Assist.repository.empresa.EmpresaRepository;
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

@RequestMapping("empresas")
@Controller
public class EmpresaController {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private SuporteRepository suporteRepository;

    @Autowired
    private EstatisticaRepository estatisticarepository;

    @GetMapping
    public ResponseEntity<List<DetalhesEmpresa>> listar(Pageable pageable){
        var lista = empresaRepository.findAll(pageable)
                .stream().map(DetalhesEmpresa::new).toList();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("{id}")
    public ResponseEntity<DetalhesEmpresa> buscar(@PathVariable("id") Long id){
        var empresa = empresaRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesEmpresa(empresa));
    }

    //Post da tabela Suporte
    @PostMapping("{id}/suporteEmpresa")
    @Transactional
    public ResponseEntity<DetalhesSuporteEmpresa> postSuporte(@PathVariable("id") Long id,
                                                       @RequestBody @Valid CadastroSuporte dto,
                                                       UriComponentsBuilder uriBuilder){
        //chamar o repository post para pesquisar o post pelo codigo
        var empresa = empresaRepository.getReferenceById(id);
        //instanciar o comentário com o dto
        var suporte = new Suporte(dto, empresa);
        suporteRepository.save(suporte);
        var uri = uriBuilder.path("suporteEmpresa/{id}").buildAndExpand(suporte.getCodigo()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesSuporteEmpresa(suporte));
    }

    //Post da tabela Estatistica
    @PostMapping("{id}/estatisticaEmpresa")
    @Transactional
    public ResponseEntity<DetalhesEstatisticaEmpresa> postEstatistica(@PathVariable("id") Long id,
                                                           @RequestBody @Valid CadastroEstatistica dto,
                                                           UriComponentsBuilder uriBuilder){
        //chamar o repository post para pesquisar o post pelo codigo
        var empresa = empresaRepository.getReferenceById(id);
        //instanciar o comentário com o dto
        var estatistica = new Estatistica(dto, empresa);
        estatisticarepository.save(estatistica);
        var uri = uriBuilder.path("estatisticaEmpresa/{id}").buildAndExpand(estatistica.getCodigo()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesEstatisticaEmpresa(estatistica));
    }

    //Post da empresa
    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesEmpresa> cadastrar(@RequestBody CadastroEmpresa empresaPost,
                                                     UriComponentsBuilder uri){
        var empresa = new Empresa(empresaPost);
        empresaRepository.save(empresa);
        var url = uri.path("/empresas/{id}").buildAndExpand(empresa.getCodigo()).toUri();
        return ResponseEntity.created(url).body(new DetalhesEmpresa(empresa));
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<DetalhesEmpresa> atualizar(@PathVariable("id") Long id,
                                                     @RequestBody CadastroEmpresa empresaPut){
        var empresa = empresaRepository.getReferenceById(id);
        empresa.atualizarDados(empresaPut);
        return ResponseEntity.ok(new DetalhesEmpresa(empresa));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id){
        empresaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
