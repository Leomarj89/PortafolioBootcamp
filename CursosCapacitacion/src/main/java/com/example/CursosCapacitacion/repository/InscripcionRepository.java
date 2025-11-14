package com.example.CursosCapacitacion.repository;

import com.example.CursosCapacitacion.model.Inscripcion;
import com.example.CursosCapacitacion.model.Empleado;
import com.example.CursosCapacitacion.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {

    List<Inscripcion> findByEmpleado(Empleado empleado);

    boolean existsByEmpleadoAndCurso(Empleado empleado, Curso curso);

    long countByCurso(Curso curso);
}