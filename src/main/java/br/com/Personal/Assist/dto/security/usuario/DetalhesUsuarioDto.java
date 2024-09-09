package br.com.Personal.Assist.dto.security.usuario;


import br.com.Personal.Assist.model.user.Usuario;

public record DetalhesUsuarioDto(Long id, String username, String email) {

    public DetalhesUsuarioDto(Usuario usuario) {
        this(usuario.getId(),usuario.getUsername(), usuario.getEmail());
    }

}
