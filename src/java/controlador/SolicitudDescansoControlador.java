package controlador;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import modelo.DBConnection;

@WebServlet(name = "SolicitudDescansoControlador", urlPatterns = {"/SolicitudDescansoControlador"})
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024 * 2, // 2MB
    maxFileSize = 1024 * 1024 * 10,      // 10MB
    maxRequestSize = 1024 * 1024 * 50   // 50MB
)
public class SolicitudDescansoControlador extends HttpServlet {

    private static final String UPLOAD_DIR = "uploads";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener datos del formulario
        int idUsuario = (int) request.getSession().getAttribute("idUsuario");
        String fechaInicio = request.getParameter("fecha_inicio");
        int duracion = Integer.parseInt(request.getParameter("duracion"));
        String motivo = request.getParameter("motivo");
        Part documentoAdjunto = request.getPart("documento_adjunto");

        String filePath = null;

        // Procesar archivo adjunto
        if (documentoAdjunto != null && documentoAdjunto.getSize() > 0) {
            String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIR;
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            String fileName = new File(documentoAdjunto.getSubmittedFileName()).getName();
            filePath = UPLOAD_DIR + File.separator + fileName;
            documentoAdjunto.write(uploadPath + File.separator + fileName);
        }

        // Insertar solicitud en la base de datos
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO solicitudes_descanso (id_usuario, fecha_inicio, duracion, motivo, documento_adjunto) "
                       + "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idUsuario);
            ps.setString(2, fechaInicio);
            ps.setInt(3, duracion);
            ps.setString(4, motivo);
            ps.setString(5, filePath);
            ps.executeUpdate();

            // Redirigir al dashboard con mensaje de éxito
            request.getSession().setAttribute("success", "Solicitud enviada correctamente.");
            response.sendRedirect("dashboard.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            request.getSession().setAttribute("error", "Error al enviar la solicitud.");
            response.sendRedirect("solicitud_descanso.jsp");
        }
    }
}
