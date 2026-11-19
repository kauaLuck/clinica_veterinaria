package com.dt2.clinica_veterinaria.repository;

import com.dt2.clinica_veterinaria.entities.Veterinario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeterinarioRepository extends JpaRepository<Veterinario, Integer> {
}
