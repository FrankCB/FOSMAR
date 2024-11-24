package controlador;

import modelo.DBConnection;
import modelo.HistorialMedico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HistorialMedicoControlador {

    public List<HistorialMedico> obtenerHistorialPorUsuario(int idUsuario) {
        List<HistorialMedico> historial = new ArrayList<>();
        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT * FROM historial_medico WHERE idUsuario = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, idUsuario);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                HistorialMedico registro = new HistorialMedico(
                    rs.getInt("id"),
                    rs.getInt("idUsuario"),
                    rs.getInt("idSolicitud"),
                    rs.getString("descripcion")
                );
                historial.add(registro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return historial;
    }
}
