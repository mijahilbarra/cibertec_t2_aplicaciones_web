package com.cibertec.clase2.repositories;

import com.cibertec.clase2.models.Carrera;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarreraRepository extends CrudRepository<Carrera, Integer> {
    Iterable<Carrera> findByNombreCarreraContainingIgnoreCase(String nombreCarrera);
}
