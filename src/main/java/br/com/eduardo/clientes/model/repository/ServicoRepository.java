package br.com.eduardo.clientes.model.repository;

import br.com.eduardo.clientes.model.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico,Integer> {
}
