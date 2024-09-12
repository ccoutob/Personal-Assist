package br.com.Personal.Assist.controller.security;

import br.com.Personal.Assist.dto.application.cliente.DetalhesCliente;
import br.com.Personal.Assist.dto.security.usuario.CadastroUsuarioDto;
import br.com.Personal.Assist.dto.security.usuario.DetalhesUsuarioDto;
import br.com.Personal.Assist.model.user.Usuario;
import br.com.Personal.Assist.repository.user.UsuarioRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("auth")
@Tag(name = "Usuario", description = "Operações relacionadas ao Usuario do nosso sistema")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("usuarios")
    @Operation(summary = "Listar todos os usuários", description = "Lista todos os usuarios do nosso sistema")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Usuarios listados com sucesso"),
            @ApiResponse(responseCode = "404", description = "Usuarios não encontrados"),
            @ApiResponse(responseCode = "403", description = "Usuário não autenticado")
    })
    public ResponseEntity<List<DetalhesUsuarioDto>> listar(Pageable pageable){
        var lista = usuarioRepository.findAll(pageable)
                .stream().map(DetalhesUsuarioDto::new).toList();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("usuarios/{id}")
    @Operation(summary = "Listar usuário por ID", description = "Lista um usuario em especifico com ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Usuario listado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Usuario não encontrado"),
            @ApiResponse(responseCode = "403", description = "Usuário não autenticado")
    })
    public ResponseEntity<DetalhesUsuarioDto> buscar(@PathVariable("id") Long id){
        var usuario = usuarioRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesUsuarioDto(usuario));
    }

    @PostMapping("register")
    @Transactional
    @Operation(summary = "Cadastrar usuário", description = "Cadastra um usuário em nosso sistema")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Usuario cadastrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Internal Server Error"),
            @ApiResponse(responseCode = "403", description = "Usuário não autenticado")
    })
    public ResponseEntity<DetalhesUsuarioDto> post(@RequestBody @Valid CadastroUsuarioDto dto,
                                                   UriComponentsBuilder builder){
        var usuario = new Usuario(dto.username(), passwordEncoder.encode(dto.password()), dto.email());
        usuarioRepository.save(usuario);
        var url = builder.path("usuario/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(url).body(new DetalhesUsuarioDto(usuario));

        /*
        {
    "username": "generico",
    "password": 123
}
         */
    }

}
