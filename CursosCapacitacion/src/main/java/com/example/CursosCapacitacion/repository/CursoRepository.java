package com.example.CursosCapacitacion.repository;

import com.example.CursosCapacitacion.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}