package com.cibertec.clase2.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "carrera")
public class Carrera {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "nombre_carrera", nullable = false, length = 100)
    private String nombreCarrera;
    
    @Column(nullable = false, length = 100)
    private String facultad;
    
    @OneToMany(mappedBy = "carrera")
    private List<Alumno> alumnos;
    
    @OneToMany(mappedBy = "carrera")
    private List<Curso> cursos;
    
    public Carrera() {
    }
    
    public Carrera(String nombreCarrera, String facultad) {
        this.nombreCarrera = nombreCarrera;
        this.facultad = facultad;
    }
    
    // Getters y Setters
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getNombreCarrera() {
        return nombreCarrera;
    }
    
    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }
    
    public String getFacultad() {
        return facultad;
    }
    
    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }
    
    public List<Alumno> getAlumnos() {
        return alumnos;
    }
    
    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
    
    public List<Curso> getCursos() {
        return cursos;
    }
    
    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
}
