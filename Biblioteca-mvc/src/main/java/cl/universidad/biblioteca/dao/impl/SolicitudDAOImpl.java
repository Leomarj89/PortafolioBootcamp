package cl.universidad.biblioteca.dao.impl;

import cl.universidad.biblioteca.dao.SolicitudDAO;
import cl.universidad.biblioteca.model.Solicitud;
import cl.universidad.biblioteca.util.DB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SolicitudDAOImpl implements SolicitudDAO {
    @Override
    public void insertar(Solicitud s) {
        String sql = "INSERT INTO solicitudes(nombre_usuario, correo, libro_id, creada_en) VALUES(?,?,?,NOW())";
        try (Connection cn = DB.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, s.getNombreUsuario());
            ps.setString(2, s.getCorreo());
            ps.setInt(3, s.getLibroId());
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Solicitud> listar() {
        String sql = "SELECT id, nombre_usuario, correo, libro_id, creada_en FROM solicitudes ORDER BY creada_en DESC";
        List<Solicitud> out = new ArrayList<>();
        try (Connection cn = DB.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Solicitud s = new Solicitud();
                s.setId(rs.getInt("id"));
                s.setNombreUsuario(rs.getString("nombre_usuario"));
                s.setCorreo(rs.getString("correo"));
                s.setLibroId(rs.getInt("libro_id"));
                s.setCreadaEn(rs.getTimestamp("creada_en").toLocalDateTime());
                out.add(s);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return out;
    }
}