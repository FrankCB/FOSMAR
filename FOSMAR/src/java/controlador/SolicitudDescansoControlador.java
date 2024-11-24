package controlador;

import modelo.DBConnection;
import modelo.SolicitudDescanso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SolicitudDescansoControlador {

    public boolean crearSolicitud(SolicitudDescanso solicitud) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "INSERT INTO solicitudes_descanso (idUsuario, fechaInicio, duracionDias, motivo, estado) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, solicitud.getIdUsuario());
            stmt.setDate(2, new java.sql.Date(solicitud.getFechaInicio().getTime()));
            stmt.setInt(3, solicitud.getDuracionDias());
            stmt.setString(4, solicitud.getMotivo());
            stmt.setString(5, solicitud.getEstado());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<SolicitudDescanso> obtenerSolicitudesPorUsuario(int idUsuario) {
        List<SolicitudDescanso> solicitudes = new ArrayList<>();
        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT * FROM solicitudes_descanso WHERE idUsuario = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, idUsuario);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                SolicitudDescanso solicitud = new SolicitudDescanso(
                    rs.getInt("id"),
                    rs.getInt("idUsuario"),
                    rs.getDate("fechaInicio"),
                    rs.getInt("duracionDias"),
                    rs.getString("motivo"),
                    rs.getString("estado")
                );
                solicitudes.add(solicitud);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return solicitudes;
    }
}
