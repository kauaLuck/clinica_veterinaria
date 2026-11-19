package com.dt2.clinica_veterinaria.controller;

import com.dt2.clinica_veterinaria.entities.Cliente;
import com.dt2.clinica_veterinaria.repository.ClienteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("api/clientes")
public class ClienteController {

    private final ClienteRepository repository;
    public ClienteController(ClienteRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public String criarCliente(@RequestBody Cliente cliente){
        try {
            return "Dados salvos com sucesso!" + repository.save(cliente);
        }
        catch (Exception e){
            return "Dados inválidos";
        }
    }

    @GetMapping
    public List<Cliente> mostrar(){
        return repository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable int id){
        repository.deleteById(id);
    }

    @GetMapping("/{id}")
    public void buscarId(@PathVariable int id){
        repository.findById(id);
    }

    @PutMapping
    public void atualizar(@PathVariable int id, @RequestBody Cliente c){
        Cliente cliente = repository.getReferenceById(id);

        cliente.setNome(c.getNome());
        cliente.setTelefone(c.getTelefone());
        cliente.setEmail(c.getEmail());
        repository.save(cliente);
    }
}
