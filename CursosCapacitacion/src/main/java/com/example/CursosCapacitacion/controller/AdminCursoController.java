package com.example.CursosCapacitacion.controller;

import com.example.CursosCapacitacion.model.Curso;
import com.example.CursosCapacitacion.repository.CursoRepository;
import com.example.CursosCapacitacion.repository.InstructorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/cursos")
public class AdminCursoController {

    private final CursoRepository cursoRepository;
    private final InstructorRepository instructorRepository;

    public AdminCursoController(CursoRepository cursoRepository,
                                InstructorRepository instructorRepository) {
        this.cursoRepository = cursoRepository;
        this.instructorRepository = instructorRepository;
    }

    @GetMapping
    public String listarCursos(Model model) {
        model.addAttribute("cursos", cursoRepository.findAll());
        return "admin/cursos"; // templates/admin/cursos.html
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevoCurso(Model model) {
        model.addAttribute("curso", new Curso());
        model.addAttribute("instructores", instructorRepository.findAll());
        return "admin/curso-form"; // templates/admin/curso-form.html
    }

    @PostMapping("/guardar")
    public String guardarCurso(@ModelAttribute("curso") Curso curso) {
        cursoRepository.save(curso);
        return "redirect:/admin/cursos";
    }

    @GetMapping("/editar/{id}")
    public String editarCurso(@PathVariable Long id, Model model) {
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Curso no encontrado: " + id));
        model.addAttribute("curso", curso);
        model.addAttribute("instructores", instructorRepository.findAll());
        return "admin/curso-form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCurso(@PathVariable Long id) {
        cursoRepository.deleteById(id);
        return "redirect:/admin/cursos";
    }
}