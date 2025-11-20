package cl.universidad.biblioteca.dao;

import cl.universidad.biblioteca.model.Solicitud;
import java.util.List;

public interface SolicitudDAO {
    void insertar(Solicitud s);
    List<Solicitud> listar();
}