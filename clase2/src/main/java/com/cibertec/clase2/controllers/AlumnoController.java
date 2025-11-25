package com.cibertec.clase2.controllers;

import com.cibertec.clase2.models.Alumno;
import com.cibertec.clase2.services.AlumnoService;
import com.cibertec.clase2.services.CarreraService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/alumno")
public class AlumnoController {
    
    private final AlumnoService alumnoService;
    private final CarreraService carreraService;
    
    public AlumnoController(AlumnoService alumnoService, CarreraService carreraService) {
        this.alumnoService = alumnoService;
        this.carreraService = carreraService;
    }
    
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("alumno", new Alumno());
        model.addAttribute("carreras", carreraService.findAll());
        model.addAttribute("alumnos", alumnoService.findAll());
        return "alumno_nuevo";
    }
    
    @PostMapping("/guardar")
    public String guardarAlumno(@ModelAttribute Alumno alumno) {
        alumnoService.save(alumno);
        return "redirect:/alumno/nuevo";
    }
}
