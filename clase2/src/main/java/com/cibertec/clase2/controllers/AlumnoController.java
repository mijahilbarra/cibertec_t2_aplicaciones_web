package com.cibertec.clase2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AlumnoController {

    @GetMapping
    public String holaMundo(Model model) {
        model.addAttribute("mensaje", "Este es el mensaje desde el controlador");
        return "index";
    }
}
