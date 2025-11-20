package org.example.agenda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Agenda {
    private List<Tarea> tareas;

    public Agenda() {
        this.tareas = new ArrayList<>();
    }

    // Agregar tarea
    public void agregarTarea(Tarea tarea) {
        tareas.add(tarea);
    }

    // Listar todas las tareas
    public List<Tarea> listarTareas() {
        return tareas;
    }

    // Filtrar tareas por estado
    public List<Tarea> filtrarPorEstado(boolean completadas) {
        return tareas.stream()
                .filter(t -> t.isCompletada() == completadas)
                .collect(Collectors.toList());
    }

    // Marcar tarea como completada
    public boolean marcarComoCompletada(int id) {
        for (Tarea tarea : tareas) {
            if (tarea.getId() == id) {
                tarea.setCompletada(true);
                return true;
            }
        }
        return false;
    }
}