package com.dt2.clinica_veterinaria.controller;
import com.dt2.clinica_veterinaria.entities.Animal;
import com.dt2.clinica_veterinaria.repository.AnimalRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pets")
public class AnimalController {

    private final AnimalRepository repository;
    public AnimalController(AnimalRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public String criarAnimal(@RequestBody Animal animal){
        try {
            return "Dados salvos com sucesso!" + repository.save(animal);
        }
        catch (Exception e){
            return "Dados inválidos!";
        }
    }

    @GetMapping
    public List<Animal> mostrar(){
        return repository.findAll();
    }

    @DeleteMapping("{id}")
    public void deletar(@PathVariable int id){
        repository.deleteById(id);
    }

    @GetMapping("{id}")
    public void buscarId(@PathVariable int id){
        repository.findById(id);
    }

    @PutMapping("{id}")
    public void atualizar(@PathVariable int id, @RequestBody Animal a){
        Animal animal = repository.getReferenceById(id);

        animal.setNome(a.getNome());
        animal.setEspecie(a.getEspecie());
        animal.setRaca(a.getRaca());
        animal.setCliente(a.getCliente());
        repository.save(animal);
    }

}
