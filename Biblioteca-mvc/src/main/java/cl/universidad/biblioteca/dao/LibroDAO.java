package cl.universidad.biblioteca.dao;

import cl.universidad.biblioteca.model.Libro;
import java.util.List;

public interface LibroDAO {
    List<Libro> listar();
    Libro obtenerPorId(int id);
    boolean reservarSiDisponible(int id);
}
