package br.edu.unievangelica.saas.oauthjwt.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import br.edu.unievangelica.saas.oauthjwt.domain.usuario.Usuario;
import lombok.Getter;

public class UsuarioSistema extends User {

    @Getter
    private Usuario usuario;

    public UsuarioSistema(Usuario usuario, Collection<? extends GrantedAuthority> authorities) {
        super(usuario.getEmail(), usuario.getSenha(), authorities);
        this.usuario = usuario;
    }
}
