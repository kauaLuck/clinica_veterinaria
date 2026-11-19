package com.dt2.clinica_veterinaria.controller;

import com.dt2.clinica_veterinaria.entities.Veterinario;
import com.dt2.clinica_veterinaria.repository.VeterinarioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/veterinarios")
public class VeterinarioController {

    private final VeterinarioRepository repository;
    public VeterinarioController(VeterinarioRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public String criarVeterinario(@RequestBody Veterinario veterinario){
        try {
            return "Dados salvos com sucesso!" + repository.save(veterinario);
        }
        catch (Exception e){
            return "Dados inválidos!";
        }
    }

    @GetMapping
    public List<Veterinario> mostrar(){
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
    public void atualizar(@PathVariable int id, @RequestBody Veterinario v){
         Veterinario veterinario = repository.getReferenceById(id);

        veterinario.setNome(v.getNome());
        veterinario.setCrmv(v.getCrmv());
        veterinario.setEspecialista(v.getEspecialista());
        repository.save(veterinario);
    }
}
