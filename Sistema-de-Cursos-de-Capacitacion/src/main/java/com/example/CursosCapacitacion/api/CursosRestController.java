package com.example.CursosCapacitacion.api;

import com.example.CursosCapacitacion.api.dto.CursoDto;
import com.example.CursosCapacitacion.model.Curso;
import com.example.CursosCapacitacion.repository.CursoRepository;
import com.example.CursosCapacitacion.repository.InscripcionRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/cursos")
@CrossOrigin(origins = "*") // para permitir peticiones desde otros orígenes (demo académica)
public class CursosRestController {

    private final CursoRepository cursoRepository;
    private final InscripcionRepository inscripcionRepository;

    public CursosRestController(CursoRepository cursoRepository,
                                InscripcionRepository inscripcionRepository) {
        this.cursoRepository = cursoRepository;
        this.inscripcionRepository = inscripcionRepository;
    }

    @GetMapping
    public List<CursoDto> listarCursos() {
        List<Curso> cursos = cursoRepository.findAll();

        return cursos.stream()
                .map(this::mapearACursoDto)
                .collect(Collectors.toList());
    }

    private CursoDto mapearACursoDto(Curso curso) {
        long inscritos = inscripcionRepository.countByCurso(curso);

        Integer cupoMaximo = curso.getCupoMaximo();
        Integer cuposDisponibles = null;
        boolean lleno = false;

        if (cupoMaximo != null && cupoMaximo > 0) {
            long diff = cupoMaximo - inscritos;
            if (diff < 0) {
                cuposDisponibles = 0;
            } else {
                cuposDisponibles = (int) diff;
            }
            lleno = inscritos >= cupoMaximo;
        }

        String instructorNombre = curso.getInstructor() != null
                ? curso.getInstructor().getNombre()
                : null;

        CursoDto dto = new CursoDto();
        dto.setId(curso.getId());
        dto.setNombre(curso.getNombre());
        dto.setDescripcion(curso.getDescripcion());
        dto.setFechaInicio(curso.getFechaInicio());
        dto.setFechaFin(curso.getFechaFin());
        dto.setCupoMaximo(curso.getCupoMaximo());
        dto.setCantidadInscritos(inscritos);
        dto.setCuposDisponibles(cuposDisponibles);
        dto.setCursoLleno(lleno);
        dto.setInstructorNombre(instructorNombre);

        return dto;
    }
}
