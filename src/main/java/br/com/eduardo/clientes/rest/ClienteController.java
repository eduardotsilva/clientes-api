package br.com.eduardo.clientes.rest;

import br.com.eduardo.clientes.model.entity.Cliente;
import br.com.eduardo.clientes.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {


    private final ClienteRepository repository;

    @Autowired
    public ClienteController(ClienteRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente salvar(@RequestBody Cliente cliente){
        System.out.println(cliente);
        return repository.save(cliente);
    }

    @GetMapping("/{id}")
    public Cliente acharPorId(@PathVariable Integer id){

        return repository.findById(id).orElseThrow( ()-> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id){

        repository.findById(id)
                .map( cliente ->{
                    repository.deleteById(id);
                    return Void.TYPE;
                })
                .orElseThrow( ()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}
