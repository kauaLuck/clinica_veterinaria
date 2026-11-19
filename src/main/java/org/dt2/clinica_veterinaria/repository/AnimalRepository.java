package com.dt2.clinica_veterinaria.repository;
import com.dt2.clinica_veterinaria.entities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AnimalRepository extends JpaRepository<Animal, Integer>{
}
