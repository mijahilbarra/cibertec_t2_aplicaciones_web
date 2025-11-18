package com.cibertec.clase2.models;

import jakarta.persistence.*;

@Entity(name = "AlumnosTabla")
@Table(name = "Alumnos")
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String nombre;
    @Column(name = "lastName")
    private String apellido;
    private String carrera;
    private Long codigoEstudiante;
    private double promedioNotas;
    private boolean activo;

    public Alumno() {
    }

    public Alumno(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public Long getCodigoEstudiante() {
        return codigoEstudiante;
    }

    public void setCodigoEstudiante(Long codigoEstudiante) {
        this.codigoEstudiante = codigoEstudiante;
    }

    public double getPromedioNotas() {
        return promedioNotas;
    }

    public void setPromedioNotas(double promedioNotas) {
        this.promedioNotas = promedioNotas;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
