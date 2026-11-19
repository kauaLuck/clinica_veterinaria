package com.dt2.clinica_veterinaria.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Veterinario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String crmv;
    private String especialista;

    public Veterinario(int id, String nome, String crmv, String especialista) {
        this.id = id;
        this.nome = nome;
        this.crmv = crmv;
        this.especialista = especialista;
    }

    public Veterinario(String nome, String crmv, String especialista) {
        this.nome = nome;
        this.crmv = crmv;
        this.especialista = especialista;
    }

    public Veterinario(){};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCrmv() {
        return crmv;
    }

    public void setCrmv(String crmv) {
        this.crmv = crmv;
    }

    public String getEspecialista() {
        return especialista;
    }

    public void setEspecialista(String especialista) {
        this.especialista = especialista;
    }
}
