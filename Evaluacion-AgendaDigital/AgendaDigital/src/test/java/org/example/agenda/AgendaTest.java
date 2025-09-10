package org.example.agenda;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class AgendaTest {

    @Test
    void testAgregarTarea() {
        Agenda agenda = new Agenda();
        Tarea tarea = new Tarea(1, "Prueba", LocalDate.now());
        agenda.agregarTarea(tarea);

        assertEquals(1, agenda.listarTareas().size());
    }

    @Test
    void testFiltrarPorEstado() {
        Agenda agenda = new Agenda();
        Tarea tarea1 = new Tarea(1, "Pendiente", LocalDate.now());
        Tarea tarea2 = new Tarea(2, "Completada", LocalDate.now());
        tarea2.setCompletada(true);

        agenda.agregarTarea(tarea1);
        agenda.agregarTarea(tarea2);

        assertEquals(1, agenda.filtrarPorEstado(true).size());
        assertEquals(1, agenda.filtrarPorEstado(false).size());
    }

    @Test
    void testMarcarComoCompletada() {
        Agenda agenda = new Agenda();
        Tarea tarea = new Tarea(1, "Tarea de prueba", LocalDate.now());
        agenda.agregarTarea(tarea);

        assertTrue(agenda.marcarComoCompletada(1));
        assertTrue(tarea.isCompletada());
    }
}