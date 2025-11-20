package org.example.agenda;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static int contadorId = 1;

    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== Agenda Digital ===");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Listar tareas");
            System.out.println("3. Filtrar tareas por estado");
            System.out.println("4. Marcar tarea como completada");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la descripción de la tarea: ");
                    String descripcion = scanner.nextLine();

                    System.out.print("Ingrese la fecha (YYYY-MM-DD): ");
                    String fechaStr = scanner.nextLine();
                    LocalDate fecha = LocalDate.parse(fechaStr);

                    Tarea nuevaTarea = new Tarea(contadorId++, descripcion, fecha);
                    agenda.agregarTarea(nuevaTarea);
                    System.out.println("Tarea agregada con éxito.");
                    break;

                case 2:
                    System.out.println("\n--- Lista de Tareas ---");
                    List<Tarea> todas = agenda.listarTareas();
                    todas.forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("¿Filtrar completadas? (true/false): ");
                    boolean estado = scanner.nextBoolean();
                    List<Tarea> filtradas = agenda.filtrarPorEstado(estado);
                    System.out.println("\n--- Tareas filtradas ---");
                    filtradas.forEach(System.out::println);
                    break;

                case 4:
                    System.out.print("Ingrese el ID de la tarea a marcar como completada: ");
                    int id = scanner.nextInt();
                    boolean exito = agenda.marcarComoCompletada(id);
                    if (exito) {
                        System.out.println("Tarea marcada como completada.");
                    } else {
                        System.out.println("No se encontró una tarea con ese ID.");
                    }
                    break;

                case 5:
                    System.out.println("Saliendo de la agenda...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}