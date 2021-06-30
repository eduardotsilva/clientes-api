package br.com.eduardo.clientes.service;

import br.com.eduardo.clientes.exception.UsuarioCadastradoException;
import br.com.eduardo.clientes.model.entity.Usuario;
import br.com.eduardo.clientes.model.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements UserDetailsService {


    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario salvar(Usuario usuario) {
       boolean exists = usuarioRepository.existsByUsername(usuario.getUsername());
        if (exists) {
            throw new UsuarioCadastradoException(usuario.getUsername());
        }
       return usuarioRepository.save(usuario);
    }


    public List<Usuario> listarUsuarios(){
        return  usuarioRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository
                .findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Login não encontrado."));

        return User
                .builder()
                .username(usuario.getUsername())
                .password(usuario.getPassword())
                .roles("USER")
                .build();

    }
}
