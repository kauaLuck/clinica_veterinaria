package com.dt2.clinica_veterinaria.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @CreationTimestamp
    private LocalDateTime data_hora;
    @ManyToOne
    @JoinColumn(name = "animal_id", nullable = false)
    private Animal animal;
    @ManyToOne
    @JoinColumn(name = "veterinario_id", nullable = false)
    private Veterinario veterinario;

    public Consulta(int id, LocalDateTime data_hora, Animal animal, Veterinario veterinario) {
        this.id = id;
        this.data_hora = data_hora;
        this.animal = animal;
        this.veterinario = veterinario;
    }

    public Consulta(LocalDateTime data_hora, Animal animal, Veterinario veterinario) {
        this.data_hora = data_hora;
        this.animal = animal;
        this.veterinario = veterinario;
    }

    public Consulta(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getData_hora() {
        return data_hora;
    }

    public void setData_hora(LocalDateTime data_hora) {
        this.data_hora = data_hora;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }
}
