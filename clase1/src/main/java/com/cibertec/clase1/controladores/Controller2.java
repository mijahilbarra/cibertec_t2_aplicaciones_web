package com.cibertec.clase1.controladores;

import com.cibertec.clase1.servicios.AlumnoServicios;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controller2 {

    private AlumnoServicios servicios;

    public Controller2(AlumnoServicios servicios) {
        this.servicios = servicios;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("mensaje", "Hola Miguel, esto viene desde el Controller 😎");
        model.addAttribute("alumnos", servicios.findAll());
        return "index"; // carga templates/index.html
    }
}
