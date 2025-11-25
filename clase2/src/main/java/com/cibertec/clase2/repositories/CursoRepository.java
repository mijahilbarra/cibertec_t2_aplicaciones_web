package com.cibertec.clase2.repositories;

import com.cibertec.clase2.models.Curso;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends CrudRepository<Curso, Integer> {
    
    @Query("SELECT c FROM Curso c WHERE c.carrera.nombreCarrera LIKE %:nombreCarrera%")
    Iterable<Curso> findByCarreraNombreCarreraContaining(@Param("nombreCarrera") String nombreCarrera);
}
