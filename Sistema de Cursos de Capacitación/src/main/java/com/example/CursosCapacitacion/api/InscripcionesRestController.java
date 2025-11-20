package com.example.CursosCapacitacion.api;

import com.example.CursosCapacitacion.api.dto.InscripcionRequest;
import com.example.CursosCapacitacion.api.dto.InscripcionResponse;
import com.example.CursosCapacitacion.model.Curso;
import com.example.CursosCapacitacion.model.Empleado;
import com.example.CursosCapacitacion.model.Inscripcion;
import com.example.CursosCapacitacion.repository.CursoRepository;
import com.example.CursosCapacitacion.repository.EmpleadoRepository;
import com.example.CursosCapacitacion.repository.InscripcionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.time.LocalDate;
import java.util.Map;

@RestController
@RequestMapping("/api/inscripciones")
@CrossOrigin(origins = "*")
public class InscripcionesRestController {

    private final CursoRepository cursoRepository;
    private final EmpleadoRepository empleadoRepository;
    private final InscripcionRepository inscripcionRepository;

    public InscripcionesRestController(CursoRepository cursoRepository,
                                       EmpleadoRepository empleadoRepository,
                                       InscripcionRepository inscripcionRepository) {
        this.cursoRepository = cursoRepository;
        this.empleadoRepository = empleadoRepository;
        this.inscripcionRepository = inscripcionRepository;
    }

    @PostMapping
    public ResponseEntity<?> crearInscripcion(@RequestBody InscripcionRequest request,
                                              Principal principal) {

        if (request.getCursoId() == null) {
            return ResponseEntity.badRequest()
                    .body(Map.of("error", "El campo cursoId es obligatorio"));
        }

        String username = principal.getName();

        Empleado empleado = empleadoRepository.findByUsername(username)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "No se encontró un empleado asociado al usuario autenticado: " + username
                ));

        Curso curso = cursoRepository.findById(request.getCursoId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Curso no encontrado con id: " + request.getCursoId()
                ));

        // 1) Validar si ya está inscrito
        if (inscripcionRepository.existsByEmpleadoAndCurso(empleado, curso)) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(Map.of("error", "Ya estás inscrito en este curso"));
        }

        // 2) Validar cupo disponible
        Integer cupoMaximo = curso.getCupoMaximo();
        if (cupoMaximo != null && cupoMaximo > 0) {
            long inscritos = inscripcionRepository.countByCurso(curso);
            if (inscritos >= cupoMaximo) {
                return ResponseEntity.status(HttpStatus.CONFLICT)
                        .body(Map.of("error", "El curso ya no tiene cupos disponibles"));
            }
        }

        // 3) Crear inscripción
        Inscripcion inscripcion = new Inscripcion();
        inscripcion.setCurso(curso);
        inscripcion.setEmpleado(empleado);
        inscripcion.setFechaInscripcion(LocalDate.now());

        inscripcionRepository.save(inscripcion);

        // 4) Construir respuesta
        InscripcionResponse response = new InscripcionResponse();
        response.setInscripcionId(inscripcion.getId());
        response.setCursoId(curso.getId());
        response.setCursoNombre(curso.getNombre());
        response.setEmpleadoId(empleado.getId());
        response.setEmpleadoNombre(empleado.getNombreCompleto());
        response.setFechaInscripcion(inscripcion.getFechaInscripcion());

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}