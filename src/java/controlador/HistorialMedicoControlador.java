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

@WebServlet(name = "HistorialMedicoControlador", urlPatterns = {"/HistorialMedicoControlador"})
public class HistorialMedicoControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idUsuario = (int) request.getSession().getAttribute("idUsuario");
        ArrayList<SolicitudDescanso> listaSolicitudes = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT id, fecha_inicio, duracion, motivo, estado, documento_adjunto "
                       + "FROM solicitudes_descanso WHERE id_usuario = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                SolicitudDescanso solicitud = new SolicitudDescanso();
                solicitud.setId(rs.getInt("id"));
                solicitud.setFechaInicio(rs.getString("fecha_inicio"));
                solicitud.setDuracion(rs.getInt("duracion"));
                solicitud.setMotivo(rs.getString("motivo"));
                solicitud.setEstado(rs.getString("estado"));
                solicitud.setDocumentoAdjunto(rs.getString("documento_adjunto"));
                listaSolicitudes.add(solicitud);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Pasar la lista al JSP
        request.setAttribute("listaSolicitudes", listaSolicitudes);
        request.getRequestDispatcher("historial_medico.jsp").forward(request, response);
    }
}
