package br.com.eduardo.clientes.model.repository;

import br.com.eduardo.clientes.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
}
