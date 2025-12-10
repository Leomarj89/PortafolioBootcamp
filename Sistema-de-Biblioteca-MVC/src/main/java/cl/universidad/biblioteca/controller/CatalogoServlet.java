package cl.universidad.biblioteca.controller;

import cl.universidad.biblioteca.dao.LibroDAO;
import cl.universidad.biblioteca.dao.impl.LibroDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/catalogo")
public class CatalogoServlet extends HttpServlet {
    private final LibroDAO libroDAO = new LibroDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("libros", libroDAO.listar());
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}