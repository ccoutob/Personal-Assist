package br.com.Personal.Assist.model.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name="TB_USUARIO")
@Getter @Setter @NoArgsConstructor
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue
    @Column(name="cd_usuario")
    private Long id;

    @Column(name="ds_login", nullable = false, unique = true, length = 50)
    private String login;

    @Column(name="ds_senha", nullable = false)
    private String senha;

    @Column(name="ds_email", nullable = false, unique = true)
    private String email;

    public Usuario(String login,String senha, String email){
        this.login = login;
        this.senha = senha;
        this.email = email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
