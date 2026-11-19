package com.dt2.clinica_veterinaria.controller;

import com.dt2.clinica_veterinaria.entities.Consulta;
import com.dt2.clinica_veterinaria.entities.Veterinario;
import com.dt2.clinica_veterinaria.repository.ConsultaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/consulta")
public class ConsultaController {

    private final ConsultaRepository repository;
    public ConsultaController(ConsultaRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public String criarConsulta(@RequestBody Consulta consulta){
        try {
            return "Dados salvos com sucesso!" + repository.save(consulta);
        }
        catch (Exception e){
            return "Dados inválidos!";
        }
    }

    @GetMapping
    public List<Consulta> mostrar(){
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
    public void atualizar(@PathVariable int id, @RequestBody Consulta c){
        Consulta consulta = repository.getReferenceById(id);

        consulta.setData_hora(c.getData_hora());
        consulta.setVeterinario(c.getVeterinario());
        consulta.setAnimal(c.getAnimal());
        repository.save(consulta);
    }


}
