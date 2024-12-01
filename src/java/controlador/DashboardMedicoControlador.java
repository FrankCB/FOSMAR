package controlador;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.DBConnection;
import modelo.SolicitudDescanso;

@WebServlet(name = "DashboardMedicoControlador", urlPatterns = {"/DashboardMedicoControlador"})
public class DashboardMedicoControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<SolicitudDescanso> listaSolicitudes = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT sd.id, sd.fecha_inicio, sd.duracion, sd.motivo, sd.estado, u.id AS idPaciente, u.nombre AS pacienteNombre "
                       + "FROM solicitudes_descanso sd "
                       + "INNER JOIN usuarios u ON sd.id_usuario = u.id";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                SolicitudDescanso solicitud = new SolicitudDescanso();
                solicitud.setId(rs.getInt("id"));
                solicitud.setFechaInicio(rs.getString("fecha_inicio"));
                solicitud.setDuracion(rs.getInt("duracion"));
                solicitud.setMotivo(rs.getString("motivo"));
                solicitud.setEstado(rs.getString("estado"));
                solicitud.setIdPaciente(rs.getInt("idPaciente"));
                solicitud.setPacienteNombre(rs.getString("pacienteNombre"));
                listaSolicitudes.add(solicitud);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("listaSolicitudes", listaSolicitudes);
        request.getRequestDispatcher("dashboard_medico.jsp").forward(request, response);
    }
}
