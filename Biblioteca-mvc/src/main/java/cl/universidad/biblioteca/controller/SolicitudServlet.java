package cl.universidad.biblioteca.controller;

import cl.universidad.biblioteca.dao.SolicitudDAO;
import cl.universidad.biblioteca.dao.LibroDAO;
import cl.universidad.biblioteca.dao.impl.SolicitudDAOImpl;
import cl.universidad.biblioteca.dao.impl.LibroDAOImpl;
import cl.universidad.biblioteca.model.Solicitud;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/solicitar")
public class SolicitudServlet extends HttpServlet {
    private final SolicitudDAO solicitudDAO = new SolicitudDAOImpl();
    private final LibroDAO libroDAO = new LibroDAOImpl(); // <-- añade esto

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String nombre = req.getParameter("nombre");
        String correo = req.getParameter("correo");
        String libroId = req.getParameter("libroId");

        if (nombre == null || nombre.isBlank() ||
                correo == null || correo.isBlank() ||
                libroId == null || libroId.isBlank()) {
            req.setAttribute("error", "Todos los campos son obligatorios.");
            req.getRequestDispatcher("/solicitud.jsp").forward(req, resp);
            return;
        }

        int idLibro;
        try {
            idLibro = Integer.parseInt(libroId.trim());
        } catch (NumberFormatException ex) {
            req.setAttribute("error", "ID de libro inválido.");
            req.getRequestDispatcher("/solicitud.jsp").forward(req, resp);
            return;
        }

        boolean reservado = libroDAO.reservarSiDisponible(idLibro);
        if (!reservado) {
            // No existe o ya está NO disponible → informar
            req.setAttribute("error", "El libro no está disponible o no existe.");
            req.getRequestDispatcher("/solicitud.jsp").forward(req, resp);
            return;
        }

        Solicitud s = new Solicitud();
        s.setNombreUsuario(nombre.trim());
        s.setCorreo(correo.trim());
        s.setLibroId(idLibro);

        try {
            solicitudDAO.insertar(s);
        } catch (RuntimeException e) {
            throw e;
        }

        req.setAttribute("solicitud", s);
        req.getRequestDispatcher("/confirmacion.jsp").forward(req, resp);
    }
}