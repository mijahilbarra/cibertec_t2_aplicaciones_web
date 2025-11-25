package com.cibertec.clase2.controllers;

import com.cibertec.clase2.services.CursoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/curso")
public class CursoController {
    
    private final CursoService cursoService;
    
    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }
    
    @GetMapping("/listar")
    public String listarCursos(@RequestParam(required = false) String carrera, Model model) {
        if (carrera != null && !carrera.isEmpty()) {
            model.addAttribute("cursos", cursoService.findByCarreraNombre(carrera));
        } else {
            model.addAttribute("cursos", cursoService.findAll());
        }
        model.addAttribute("carrera", carrera);
        return "curso_listar";
    }
}
