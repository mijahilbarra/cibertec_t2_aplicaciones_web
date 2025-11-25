package com.cibertec.clase2.repositories;

import com.cibertec.clase2.models.Alumno;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepository extends CrudRepository<Alumno, Integer> {
}
