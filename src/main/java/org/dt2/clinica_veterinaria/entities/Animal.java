package com.dt2.clinica_veterinaria.entities;

import jakarta.persistence.*;

@Entity
public class Animal {
    @Id
    @GeneratedValue
    private int id;
    private String nome;
    private  String especie;
    private String raca;
    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    public Animal(int id, String nome, String especie, String raca, Cliente cliente) {
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.cliente = cliente;
    }

    public Animal(String nome, String especie, String raca, Cliente cliente) {
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.cliente = cliente;
    }

    public Animal(){}

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

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
