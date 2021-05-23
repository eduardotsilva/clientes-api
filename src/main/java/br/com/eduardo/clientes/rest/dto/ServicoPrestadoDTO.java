package br.com.eduardo.clientes.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServicoPrestadoDTO {

    private String Descricao;
    private String preco;
    private String data;
    private Integer idCliente;


}
