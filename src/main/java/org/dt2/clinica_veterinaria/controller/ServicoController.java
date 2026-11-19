package com.dt2.clinica_veterinaria.controller;

import com.dt2.clinica_veterinaria.entities.Servico;
import com.dt2.clinica_veterinaria.repository.ServicoRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/serviços")
public class ServicoController {

    private final ServicoRepository repository;
    public ServicoController(ServicoRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public String criarServiço(@RequestBody Servico servico){
        try {
            return "Dados salvos com sucesso!" + repository.save(servico);
        }
        catch (Exception e){
            return "Dados inválidos";
        }
    }



}
