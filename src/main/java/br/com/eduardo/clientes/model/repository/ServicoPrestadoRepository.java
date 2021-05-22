package br.com.eduardo.clientes.model.repository;

import br.com.eduardo.clientes.model.entity.ServicoPrestado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoPrestadoRepository extends JpaRepository<ServicoPrestado,Integer> {
}
