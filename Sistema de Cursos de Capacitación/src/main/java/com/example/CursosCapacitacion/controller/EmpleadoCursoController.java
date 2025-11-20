package com.example.CursosCapacitacion.controller;

import com.example.CursosCapacitacion.model.Curso;
import com.example.CursosCapacitacion.model.Empleado;
import com.example.CursosCapacitacion.model.Inscripcion;
import com.example.CursosCapacitacion.repository.CursoRepository;
import com.example.CursosCapacitacion.repository.EmpleadoRepository;
import com.example.CursosCapacitacion.repository.InscripcionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/empleado/cursos")
public class EmpleadoCursoController {

    private final CursoRepository cursoRepository;
    private final EmpleadoRepository empleadoRepository;
    private final InscripcionRepository inscripcionRepository;

    public EmpleadoCursoController(CursoRepository cursoRepository,
                                   EmpleadoRepository empleadoRepository,
                                   InscripcionRepository inscripcionRepository) {
        this.cursoRepository = cursoRepository;
        this.empleadoRepository = empleadoRepository;
        this.inscripcionRepository = inscripcionRepository;
    }

    @GetMapping
    public String verCursosDisponibles(Model model,
                                       Principal principal,
                                       @ModelAttribute("mensajeExito") String mensajeExito,
                                       @ModelAttribute("mensajeError") String mensajeError) {

        List<Curso> cursos = cursoRepository.findAll();
        model.addAttribute("cursos", cursos);

        if (mensajeExito != null && !mensajeExito.isEmpty()) {
            model.addAttribute("mensajeExito", mensajeExito);
        }
        if (mensajeError != null && !mensajeError.isEmpty()) {
            model.addAttribute("mensajeError", mensajeError);
        }

        Set<Long> cursosInscritoIds = new HashSet<>();
        Set<Long> cursosLlenosIds = new HashSet<>();

        if (principal != null) {
            String username = principal.getName();

            Empleado empleado = empleadoRepository.findByUsername(username)
                    .orElse(null);

            if (empleado != null) {
                List<Inscripcion> misInscripciones = inscripcionRepository.findByEmpleado(empleado);
                cursosInscritoIds = misInscripciones.stream()
                        .map(ins -> ins.getCurso().getId())
                        .collect(Collectors.toSet());
            }

            for (Curso curso : cursos) {
                Integer cupoMaximo = curso.getCupoMaximo();
                if (cupoMaximo != null && cupoMaximo > 0) {
                    long inscritos = inscripcionRepository.countByCurso(curso);
                    if (inscritos >= cupoMaximo) {
                        cursosLlenosIds.add(curso.getId());
                    }
                }
            }
        }

        model.addAttribute("cursosInscritoIds", cursosInscritoIds);
        model.addAttribute("cursosLlenosIds", cursosLlenosIds);

        return "empleado/cursos"; // templates/empleado/cursos.html
    }

    @PostMapping("/{id}/inscribirse")
    public String inscribirseEnCurso(@PathVariable("id") Long cursoId,
                                     Principal principal,
                                     RedirectAttributes redirectAttributes) {

        String username = principal.getName();

        Empleado empleado = empleadoRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("Empleado no encontrado para username: " + username));

        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new IllegalArgumentException("Curso no encontrado con id: " + cursoId));

        // 1) Validar si ya está inscrito
        if (inscripcionRepository.existsByEmpleadoAndCurso(empleado, curso)) {
            redirectAttributes.addFlashAttribute("mensajeError",
                    "Ya estás inscrito en el curso: " + curso.getNombre());
            return "redirect:/empleado/cursos";
        }

        // 2) Validar cupo disponible
        Integer cupoMaximo = curso.getCupoMaximo();
        if (cupoMaximo != null && cupoMaximo > 0) {
            long inscritos = inscripcionRepository.countByCurso(curso);
            if (inscritos >= cupoMaximo) {
                redirectAttributes.addFlashAttribute("mensajeError",
                        "El curso \"" + curso.getNombre() + "\" ya no tiene cupos disponibles.");
                return "redirect:/empleado/cursos";
            }
        }

        // 3) Crear inscripción
        Inscripcion inscripcion = new Inscripcion();
        inscripcion.setEmpleado(empleado);
        inscripcion.setCurso(curso);
        inscripcion.setFechaInscripcion(LocalDate.now());

        inscripcionRepository.save(inscripcion);

        redirectAttributes.addFlashAttribute("mensajeExito",
                "Te has inscrito correctamente al curso: " + curso.getNombre());

        return "redirect:/empleado/cursos";
    }

    @GetMapping("/mis-inscripciones")
    public String verMisInscripciones(Model model, Principal principal) {
        String username = principal.getName();

        Empleado empleado = empleadoRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("Empleado no encontrado para username: " + username));

        List<Inscripcion> inscripciones = inscripcionRepository.findByEmpleado(empleado);

        model.addAttribute("empleado", empleado);
        model.addAttribute("inscripciones", inscripciones);

        return "empleado/mis-inscripciones"; // templates/empleado/mis-inscripciones.html
    }
}