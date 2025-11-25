package com.cibertec.clase2.services;

import com.cibertec.clase2.models.Alumno;
import com.cibertec.clase2.repositories.AlumnoRepository;
import org.springframework.stereotype.Service;

@Service
public class AlumnoService {
    
    private final AlumnoRepository alumnoRepository;
    
    public AlumnoService(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }
    
    public Iterable<Alumno> findAll() {
        return alumnoRepository.findAll();
    }
    
    public Alumno save(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }
}
