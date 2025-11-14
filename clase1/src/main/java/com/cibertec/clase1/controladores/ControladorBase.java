package com.cibertec.clase1.controladores;

import com.cibertec.clase1.entidades.Alumno;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alumno")
public class ControladorBase {

    @GetMapping("/1")
    public Alumno holaAlumnos() {
        return new Alumno();
    }

    @GetMapping("/2")
    public ResponseEntity<Alumno> holaAlumnos2() {
        return new ResponseEntity<>(new Alumno(), HttpStatus.CREATED);
    }
}
