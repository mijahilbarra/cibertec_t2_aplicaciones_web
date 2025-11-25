package com.cibertec.clase2.services;

import com.cibertec.clase2.models.Curso;
import com.cibertec.clase2.repositories.CursoRepository;
import org.springframework.stereotype.Service;

@Service
public class CursoService {
    
    private final CursoRepository cursoRepository;
    
    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }
    
    public Iterable<Curso> findAll() {
        return cursoRepository.findAll();
    }
    
    public Iterable<Curso> findByCarreraNombre(String nombreCarrera) {
        return cursoRepository.findByCarreraNombreCarreraContaining(nombreCarrera);
    }
}
