package com.cibertec.clase2.models;

import jakarta.persistence.*;

@Entity
@Table(name = "curso")
public class Curso {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "nombre_curso", nullable = false, length = 100)
    private String nombreCurso;
    
    @Column(nullable = false)
    private Integer ciclo;
    
    @Column(nullable = false, length = 100)
    private String docente;
    
    @ManyToOne
    @JoinColumn(name = "carrera_id")
    private Carrera carrera;
    
    public Curso() {
    }
    
    public Curso(String nombreCurso, Integer ciclo, String docente, Carrera carrera) {
        this.nombreCurso = nombreCurso;
        this.ciclo = ciclo;
        this.docente = docente;
        this.carrera = carrera;
    }
    
    // Getters y Setters
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getNombreCurso() {
        return nombreCurso;
    }
    
    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }
    
    public Integer getCiclo() {
        return ciclo;
    }
    
    public void setCiclo(Integer ciclo) {
        this.ciclo = ciclo;
    }
    
    public String getDocente() {
        return docente;
    }
    
    public void setDocente(String docente) {
        this.docente = docente;
    }
    
    public Carrera getCarrera() {
        return carrera;
    }
    
    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }
}
