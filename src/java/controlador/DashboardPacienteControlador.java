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
import modelo.HistorialMedico;

@WebServlet(name = "DashboardPacienteControlador", urlPatterns = {"/DashboardPacienteControlador"})
public class DashboardPacienteControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idUsuario = (int) request.getSession().getAttribute("idUsuario");
        ArrayList<SolicitudDescanso> listaSolicitudes = new ArrayList<>();
        HistorialMedico historialMedico = null;

        try (Connection conn = DBConnection.getConnection()) {
            // Recuperar solicitudes del usuario
            String sqlSolicitudes = "SELECT id, fecha_inicio, duracion, motivo, estado "
                                  + "FROM solicitudes_descanso WHERE id_usuario = ?";
            PreparedStatement psSolicitudes = conn.prepareStatement(sqlSolicitudes);
            psSolicitudes.setInt(1, idUsuario);
            ResultSet rsSolicitudes = psSolicitudes.executeQuery();

            while (rsSolicitudes.next()) {
                SolicitudDescanso solicitud = new SolicitudDescanso();
                solicitud.setId(rsSolicitudes.getInt("id"));
                solicitud.setFechaInicio(rsSolicitudes.getString("fecha_inicio"));
                solicitud.setDuracion(rsSolicitudes.getInt("duracion"));
                solicitud.setMotivo(rsSolicitudes.getString("motivo"));
                solicitud.setEstado(rsSolicitudes.getString("estado"));
                listaSolicitudes.add(solicitud);
            }

            // Recuperar historial médico del usuario
            String sqlHistorial = "SELECT descripcion, documento_adjunto "
                                + "FROM historial_medico WHERE id_usuario = ?";
            PreparedStatement psHistorial = conn.prepareStatement(sqlHistorial);
            psHistorial.setInt(1, idUsuario);
            ResultSet rsHistorial = psHistorial.executeQuery();

            if (rsHistorial.next()) {
                historialMedico = new HistorialMedico();
                historialMedico.setDescripcion(rsHistorial.getString("descripcion"));
                historialMedico.setDocumentoAdjunto(rsHistorial.getString("documento_adjunto"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Pasar datos al JSP
        request.setAttribute("listaSolicitudes", listaSolicitudes);
        request.setAttribute("historialMedico", historialMedico);
        request.getRequestDispatcher("dashboard_paciente.jsp").forward(request, response);
    }
}
