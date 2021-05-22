package br.com.eduardo.clientes.util;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BigDecimalConverter {

    public BigDecimal converter(String valor) {
        if (valor == null) {
            return null;
        }
        valor = valor.replace(".", "");
        valor = valor.replace(",", ".");

        return new BigDecimal(valor);

    }
}
