package cl.universidad.biblioteca.dao.impl;

import cl.universidad.biblioteca.dao.LibroDAO;
import cl.universidad.biblioteca.model.Libro;
import cl.universidad.biblioteca.util.DB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibroDAOImpl implements LibroDAO {
    @Override
    public List<Libro> listar() {
        String sql = "SELECT id, nombre, autor, disponible FROM libros";
        List<Libro> out = new ArrayList<>();
        try (Connection cn = DB.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Libro l = new Libro();
                l.setId(rs.getInt("id"));
                l.setNombre(rs.getString("nombre"));
                l.setAutor(rs.getString("autor"));
                l.setDisponible(rs.getBoolean("disponible"));
                out.add(l);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return out;
    }

    @Override
    public Libro obtenerPorId(int id) {
        String sql = "SELECT id, nombre, autor, disponible FROM libros WHERE id = ?";
        try (Connection cn = DB.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Libro l = new Libro();
                    l.setId(rs.getInt("id"));
                    l.setNombre(rs.getString("nombre"));
                    l.setAutor(rs.getString("autor"));
                    l.setDisponible(rs.getBoolean("disponible"));
                    return l;
                }
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean reservarSiDisponible(int id) {
        String sql = "UPDATE libros SET disponible = FALSE WHERE id = ? AND disponible = TRUE";
        try (Connection cn = DB.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, id);
            int updated = ps.executeUpdate();
            return updated == 1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}