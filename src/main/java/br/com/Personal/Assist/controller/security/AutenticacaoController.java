package br.com.Personal.Assist.controller.security;


import br.com.Personal.Assist.dto.security.autenticacao.DadosLoginDto;
import br.com.Personal.Assist.dto.security.autenticacao.TokenJwtDto;
import br.com.Personal.Assist.model.user.Usuario;
import br.com.Personal.Assist.service.TokenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
@Tag(name = "Autenticação", description = "Operações relacionadas a autenticação da nossa API")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    @Operation(summary = "Realiza o Login de um Usuario", description = "Realiza o Login de um Usuario que retornará um JWT para utilizarmos")
    public ResponseEntity<TokenJwtDto> post(@RequestBody @Valid DadosLoginDto dto){
        var autenticacaoToken = new UsernamePasswordAuthenticationToken(dto.login(), dto.password());
        var authenticate = authenticationManager.authenticate(autenticacaoToken);
        var token = tokenService.gerarToken((Usuario) authenticate.getPrincipal());
        return ResponseEntity.ok(new TokenJwtDto(token));

        /*
        {
    "login": "Nome Do Usuario",
    "password": Senha Do Usuario (integer)
    "email": "Email do usuario"
}
         */
    }

}
