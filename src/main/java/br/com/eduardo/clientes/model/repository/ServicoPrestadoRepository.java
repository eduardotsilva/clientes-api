package br.com.eduardo.clientes.model.repository;

import br.com.eduardo.clientes.model.entity.ServicoPrestado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicoPrestadoRepository extends JpaRepository<ServicoPrestado,Integer> {

    @Query(
            " select s from ServicoPrestado s join s.cliente c " +
            " where (upper( c.nome) like upper( :nome ) or '%todos%' = :nome ) and (MONTH(s.data) =:mes or 0 = :mes)"
          )
    List<ServicoPrestado> findByNomeClienteAndMes(
            @Param("nome") String nome,
            @Param("mes") Integer mes
    );
}
